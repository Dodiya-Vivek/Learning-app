package com.example.skillupnow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.skillupnow.databinding.ActivitySignInPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;

public class SignInPage extends AppCompatActivity {

    private ActivitySignInPageBinding binding;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private static final String PREFS_NAME = "UserPrefs";
    private static final String IS_SIGNED_UP = "IsSignedUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize FirebaseAuth and FirebaseStorage
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();

        // Check if user is already signed up
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean(IS_SIGNED_UP, false)) {
            startActivity(new Intent(SignInPage.this, LoginPage.class));
            finish();
            return;
        }

        // Set click listener for sign-up button
        binding.rjSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });

        // Set click listener for sign-in button
        binding.rjSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInPage.this, LoginPage.class));
                //finish();
            }
        });
    }

    private void signUpUser() {
        String email = binding.rjMail.getText().toString().trim();
        String password = binding.rjPass.getText().toString().trim();
        String username = binding.rjUser.getText().toString().trim();

        // Validate form inputs
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create user with email and password
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                // Update user profile with username
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username)
                                        .build();

                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // Username updated successfully
                                                    Toast.makeText(SignInPage.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                                                    // Save sign-up state to SharedPreferences
                                                    SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    editor.putBoolean(IS_SIGNED_UP, true);
                                                    editor.apply();

                                                    // Navigate to login page
                                                    startActivity(new Intent(SignInPage.this, LoginPage.class));
                                                    finish(); // Optional: Finish the current activity
                                                } else {
                                                    Toast.makeText(SignInPage.this, "Failed to update username", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(SignInPage.this, "Sign up failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

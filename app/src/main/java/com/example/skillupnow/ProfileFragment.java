package com.example.skillupnow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.skillupnow.Quiz.QuizActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;

    private TextView name, text10, text13, text11, signOutButton;
    private ImageView profileImage;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private Uri imageUri;
    private Uri cameraImageUri;
    private ImageButton edit;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize FirebaseAuth and FirebaseStorage
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();

        name = rootView.findViewById(R.id.name);
        profileImage = rootView.findViewById(R.id.imageView2);
        progressBar = rootView.findViewById(R.id.progressBar);
        edit = rootView.findViewById(R.id.edit);
        signOutButton = rootView.findViewById(R.id.text14);

        // About Click
        text10 = rootView.findViewById(R.id.text10);
        text10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        // Status click
        text13 = rootView.findViewById(R.id.text13);
        text13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StatusActivity.class);
                startActivity(intent);
            }
        });

        text11 = rootView.findViewById(R.id.text11);
        text11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
            }
        });

        // Add click listener for profile image to pick an image
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePickerDialog();
            }
        });

        // Add long click listener for profile image to show full image
        profileImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showFullImageDialog();
                return true;
            }
        });

        // Add click listener for edit button
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditNameDialog();
            }
        });

        // Add click listener for sign-out button
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        // Load user info
        loadUserInfo();

        return rootView;
    }

    // Method to load user information from Firebase
    private void loadUserInfo() {
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            // Display user's name if available, otherwise display email
            String userName = currentUser.getDisplayName();
            if (userName != null && !userName.isEmpty()) {
                name.setText("User Name: " + userName);
            } else {
                String userEmail = currentUser.getEmail();
                name.setText(userEmail);
            }

            // Load profile picture
            loadProfilePicture(currentUser.getUid());
        } else {
            // If user is not signed in, show a message or redirect to login page
            name.setText("User Not Signed In");
            // Optionally, redirect to login page
            startActivity(new Intent(getActivity(), LoginPage.class));
            getActivity().finish();
        }
    }

    // Method to load profile picture from Firebase Storage
    private void loadProfilePicture(String userId) {
        // Show the progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Reference to the profile picture in Firebase Storage
        StorageReference profileRef = storage.getReference().child("profileImages").child(userId + ".jpg");

        // Load profile picture using Glide library
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into the ImageView using Glide
                Glide.with(getActivity())
                        .load(uri)
                        .placeholder(R.drawable.bot3) // Placeholder image
                        .into(profileImage);
                // Hide the progress bar
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Profile picture loaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Hide the progress bar
                progressBar.setVisibility(View.GONE);
                // Handle failure
                Toast.makeText(getActivity(), "Failed to load profile picture", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Show dialog to choose between gallery and camera
    private void showImagePickerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Image");
        builder.setItems(new CharSequence[]{"Gallery", "Camera"}, (dialog, which) -> {
            switch (which) {
                case 0:
                    // Open gallery
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                    break;
                case 1:
                    // Open camera
                    if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        openCamera();
                    } else {
                        requestPermissions(new String[]{android.Manifest.permission.CAMERA}, CAMERA_REQUEST);
                    }
                    break;
            }
        });
        builder.show();
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Handle error
                Toast.makeText(getActivity(), "Error creating image file", Toast.LENGTH_SHORT).show();
            }
            if (photoFile != null) {
                cameraImageUri = FileProvider.getUriForFile(getActivity(),
                        "com.example.skillupnow.fileprovider",
                        photoFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImageUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir("Pictures");
        return File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(getActivity(), "Camera permission is required to take photos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == getActivity().RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            uploadImage(imageUri);
        } else if (requestCode == CAMERA_REQUEST && resultCode == getActivity().RESULT_OK) {
            if (cameraImageUri != null) {
                uploadImage(cameraImageUri);
            }
        }
    }

    // Method to upload the image to Firebase Storage
    private void uploadImage(Uri uri) {
        if (uri != null) {
            FirebaseUser currentUser = auth.getCurrentUser();
            if (currentUser != null) {
                // Show the progress dialog
                Dialog progressDialog = new Dialog(getActivity());
                progressDialog.setContentView(R.layout.dialog_pro);
                progressDialog.setCancelable(false);
                progressDialog.show();

                StorageReference fileReference = storage.getReference().child("profileImages").child(currentUser.getUid() + ".jpg");

                fileReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Glide.with(getActivity())
                                        .load(uri)
                                        .placeholder(R.drawable.bot3) // Placeholder image
                                        .into(profileImage);
                                // Hide the progress dialog
                                progressDialog.dismiss();
                                Toast.makeText(getActivity(), "Profile picture updated", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Hide the progress dialog
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Failed to upload profile picture", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else {
            Toast.makeText(getActivity(), "No image selected", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to show full image in a dialog
    private void showFullImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_full_image, null);
        builder.setView(dialogView);

        ImageView fullImageView = dialogView.findViewById(R.id.fullImageView);

        // Load the full image into the dialog ImageView using Glide
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            StorageReference profileRef = storage.getReference().child("profileImages").child(currentUser.getUid() + ".jpg");
            profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(getActivity())
                            .load(uri)
                            .placeholder(R.drawable.bot3) // Placeholder image
                            .into(fullImageView);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(), "Failed to load full image", Toast.LENGTH_SHORT).show();
                }
            });
        }

        builder.setNegativeButton("", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    // Method to show edit name dialog
    private void showEditNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Update Name");

        // Set up the input
        final EditText input = new EditText(getActivity());
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("Save", (dialog, which) -> {
            String newName = input.getText().toString().trim();
            if (!newName.isEmpty()) {
                saveUserName(newName);
            } else {
                Toast.makeText(getActivity(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    // Method to save the updated user name
    private void saveUserName(String newName) {
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(newName)
                    .build();

            currentUser.updateProfile(profileUpdates).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    name.setText("User Name: " + newName);
                    Toast.makeText(getActivity(), "User name updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Failed to update user name", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // Method to sign out the user
    private void signOut() {
        auth.signOut();
        Toast.makeText(getActivity(), "Signed out successfully", Toast.LENGTH_SHORT).show();
        // Navigate to SignInActivity
        startActivity(new Intent(getActivity(), SignInPage.class));
        getActivity().finish();
    }
}

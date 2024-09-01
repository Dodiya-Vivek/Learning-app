package com.example.skillupnow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.skillupnow.databinding.ActivityFragmentBinding;

public class FragmentActivity extends AppCompatActivity {

    @NonNull
    ActivityFragmentBinding binding;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();

        replaceFragment(new HomeFragment());

        binding.BottomNav.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home1) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.caln2) {
                replaceFragment(new CalFragment());
                return true;
            } else if (itemId == R.id.Video3) {
                replaceFragment(new SearchFragment());
                return true;
            } else if (itemId == R.id.profile4) {
                replaceFragment(new ProfileFragment());
                return true;
            } else if (itemId == R.id.books5) {
                replaceFragment(new PDFFragment());
                return true;
            } else {
                return true;
            }
        });
    }

    private void navigateToFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fram_lauout, fragment);
        fragmentTransaction.commit();
    }

    public void navigateToUiCaourseFragment() {
        UiCaourseFragment uiCaourseFragment = new UiCaourseFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, uiCaourseFragment)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToDigitalFragment() {
        DigitalMarketingFragment digitalMarketingFragment = new DigitalMarketingFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, digitalMarketingFragment)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToMotionGraphicsFragment() {
        MotionGraphicsFragment motionGraphicsFragment = new MotionGraphicsFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, motionGraphicsFragment)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToProgramming3() {
        Programming3 programming3 = new Programming3();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, programming3)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToSearchFragment() {
        SearchFragment searchFragment = new SearchFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, searchFragment)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToCalFragment() {
        CalFragment calFragment = new CalFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fram_lauout, calFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        // Check if HomeFragment is already displayed
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fram_lauout);
        if (!(currentFragment instanceof HomeFragment)) {
            // Navigate to HomeFragment if it is not currently displayed
            replaceFragment(new HomeFragment());
        } else {
            // If HomeFragment is displayed, let the default back press behavior happen
            super.onBackPressed();
        }
    }
}

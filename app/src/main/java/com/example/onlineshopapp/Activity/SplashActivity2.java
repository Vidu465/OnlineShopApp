package com.example.onlineshopapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineshopapp.databinding.ActivitySplash2Binding;

public class SplashActivity2 extends AppCompatActivity {
    private ActivitySplash2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySplash2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // CORRECTED PART:
        // Changed the click listener from 'binding.main' to 'binding.button'
        // 'binding.button' refers to the button with android:id="@+id/button" in your XML
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity when the button is clicked
                startActivity(new Intent(SplashActivity2.this, MainActivity.class));

                // Finish this activity so the user can't go back to the splash screen
                finish();
            }
        });
    }
}

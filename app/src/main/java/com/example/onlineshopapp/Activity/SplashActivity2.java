package com.example.onlineshopapp.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineshopapp.databinding.ActivitySplash2Binding;

public class SplashActivity2 extends AppCompatActivity {
    private ActivitySplash2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivitySplash2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startBtn.setOnClickListener(v ->
                startActivity(new Intent(SplashActivity2.this,MainActivity.class)));


    }
}
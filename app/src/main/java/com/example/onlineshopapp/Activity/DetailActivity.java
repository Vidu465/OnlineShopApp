package com.example.onlineshopapp.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.onlineshopapp.Domain.ItemsModel;
import com.example.onlineshopapp.Helper.ManagmentCart;
import com.example.onlineshopapp.R;
import com.example.onlineshopapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
private ActivityDetailBinding binding;
private ItemsModel object;
private int numberOrder=1;
private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart=new ManagmentCart(this);

        getBundle();


    }

    private void getBundle() {
        object=get
    }
}
package com.example.onlineshopapp.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.onlineshopapp.Adapter.CategoryAdapter;
import com.example.onlineshopapp.ViewModel.MainViewModel;
import com.example.onlineshopapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new MainViewModel();
        initCategory();
    }

    private void initCategory() {
        binding.progressBar2Category.setVisibility(View.VISIBLE);

        viewModel.LoadCategory().observeForever(categoryModels -> {
            if (categoryModels != null) {
                binding.categoryView.setLayoutManager(
                        new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false)
                );

                binding.categoryView.setAdapter(new CategoryAdapter(categoryModels));
                binding.categoryView.setNestedScrollingEnabled(true);
            }

            binding.progressBar2Category.setVisibility(View.GONE);
        });
    }
}

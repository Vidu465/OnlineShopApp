package com.example.onlineshopapp.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.onlineshopapp.Adapter.CategoryAdapter;
import com.example.onlineshopapp.Adapter.SliderAdapter;
import com.example.onlineshopapp.Domain.BannerModel;
import com.example.onlineshopapp.ViewModel.MainViewModel;
import com.example.onlineshopapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

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
    initSlider();
    initPopular();
    }

    private void initPopular() {
        binding.progressBar2Popular.setVisibility(View.VISIBLE);
        viewModel.loadPopular().observeForever(itemsModels -> {
            if(!itemsModels.isEmpty()){

            }
        });
    }

    private void initSlider() {
        binding.progressBarSlider.setVisibility(View.VISIBLE);
        viewModel.LoadBanner().observeForever(bannerModels -> {
            if(bannerModels!=null && !bannerModels.isEmpty()){
                banners(bannerModels);
                binding.progressBarSlider.setVisibility(View.GONE);
            }
        });

        viewModel.LoadBanner();

    }

    private void banners(ArrayList<BannerModel> bannerModels) {
        binding.viewPagerSlider.setAdapter(new SliderAdapter(bannerModels,binding.viewPagerSlider));
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        binding.viewPagerSlider.setPageTransformer(compositePageTransformer);


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

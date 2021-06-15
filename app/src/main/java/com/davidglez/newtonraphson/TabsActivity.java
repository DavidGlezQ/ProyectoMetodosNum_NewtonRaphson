package com.davidglez.newtonraphson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.davidglez.newtonraphson.databinding.ActivityTabsBinding;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    ActivityTabsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabsBinding.inflate(getLayoutInflater());


        View view = binding.getRoot();
        setContentView(view);
    }
}
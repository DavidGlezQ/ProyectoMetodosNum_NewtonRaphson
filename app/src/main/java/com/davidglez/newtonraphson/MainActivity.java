package com.davidglez.newtonraphson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import com.davidglez.newtonraphson.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String valorX, valorY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //Validar funciones
        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorX = binding.etX.getText().toString();
                valorY = binding.etY.getText().toString();

                if (!valorX.isEmpty() && !valorY.isEmpty()){ //Validar X y Y
                    
                } else {
                    Toast.makeText(MainActivity.this, "Debes de llenar los campos de X y Y", Toast.LENGTH_SHORT).show();
                }
            }
        });

        View view = binding.getRoot();
        setContentView(view);
    }
}
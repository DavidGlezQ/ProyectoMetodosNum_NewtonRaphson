package com.davidglez.newtonraphson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.davidglez.newtonraphson.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String valorX, valorY, fun1Valor1, fun1Valor2, fun1Valor3, fun2Valor1, fun2Valor2, fun2Valor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //Validaciones de X y Y, y de funciones
        valorX = binding.etX.getText().toString();
        valorY = binding.etY.getText().toString();

        fun1Valor1 = binding.etFun1Valor1.getText().toString();
        fun1Valor2 = binding.etFun1Valor2.getText().toString();
        fun1Valor3 = binding.etFun1Valor3.getText().toString();

        fun2Valor1 = binding.etFun2Valor1.getText().toString();
        fun2Valor2 = binding.etFun2Valor2.getText().toString();
        fun2Valor3 = binding.etFun2Valor3.getText().toString();

        //Validar funciones
        binding.btnFunciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valorX.isEmpty() && !valorY.isEmpty()){
                    Toast.makeText(MainActivity.this, "Debes de llenar los campos de X y Y", Toast.LENGTH_SHORT);
                } else {

                }
            }
        });

        //Ayuda al usuario
        binding.ivAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogAyuda = new AlertDialog.Builder(MainActivity.this);
                dialogAyuda.setTitle("Como llenar los siguientes datos?");
                dialogAyuda.setMessage("Mensaje de explicacion");
                dialogAyuda.setCancelable(true);

                dialogAyuda.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v, "Bien", Snackbar.LENGTH_SHORT).show();
                    }
                });

                dialogAyuda.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v, "Bien", Snackbar.LENGTH_SHORT).show();
                    }
                });
                dialogAyuda.create().show();
            }
        });


        View view = binding.getRoot();
        setContentView(view);
    }
}
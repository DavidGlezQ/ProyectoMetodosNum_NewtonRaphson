package com.davidglez.newtonraphson.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.davidglez.newtonraphson.MainActivity;
import com.davidglez.newtonraphson.R;
import com.davidglez.newtonraphson.databinding.FragmentExampleNewton1ragmentBinding;

public class ExampleNewton1ragment extends Fragment {

    public FragmentExampleNewton1ragmentBinding binding;
    private String valorX, valorY;
    private Double finalValorX, finalValorY, res1, res2, res3, res4, valorSusFun1, valorSusFun2,
            jacobiInverso1, jacobiInverso2, jacobiInverso3, jacobiInverso4, resSubFinal1, resSubFinal2, primerIteracionX, primerIteracionY;

    public ExampleNewton1ragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExampleNewton1ragmentBinding.inflate(getLayoutInflater());

        //Validar funciones
        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valorX = binding.etX.getText().toString();
                valorY = binding.etY.getText().toString();

                if (!valorX.isEmpty() && !valorY.isEmpty()){
                    finalValorX = Double.parseDouble(valorX);
                    finalValorY = Double.parseDouble(valorY);

                    res1 = (2 * Double.parseDouble(valorX) + Double.parseDouble(valorY));
                    res2 = Double.parseDouble(valorX);
                    res3 = (3 * (Double.parseDouble(valorY) * Double.parseDouble(valorY)));
                    res4 = (1 + 6 * Double.parseDouble(valorX) * Double.parseDouble(valorY));

                    String res1String = String.valueOf(res1);
                    String res2String = String.valueOf(res2);
                    String res3String = String.valueOf(res3);
                    String res4String = String.valueOf(res4);

                    binding.tvJacobi1.setText(res1String);
                    binding.tvJacobi2.setText(res2String);
                    binding.tvJacobi3.setText(res3String);
                    binding.tvJacobi4.setText(res4String);

                    //Funciones y sustitucion por x,y
                    binding.valorJacobFun1.setText(res1String);
                    binding.valorJacobFun2.setText(res2String);
                    binding.valorJacobFun3.setText(res3String);
                    binding.valorJacobFun4.setText(res4String);

                    valorSusFun1 = (Double.parseDouble(valorX) * Double.parseDouble(valorX) + Double.parseDouble(valorX) * Double.parseDouble(valorY) - 10);
                    String valorSusFun1String = String.valueOf(valorSusFun1);
                    binding.valorSustFun1.setText(valorSusFun1String);

                    valorSusFun2 = (Double.parseDouble(valorY) + 3 * Double.parseDouble(valorX) * (Double.parseDouble(valorY) * Double.parseDouble(valorY)) - 57);
                    String valorSusFun2String = String.valueOf(valorSusFun2);
                    binding.valorSustFun2.setText(valorSusFun2String);

                    //Calculamos la inversa -1
                    jacobiInverso1 = (1 / (res1 * res4 - res2 * res3) * res4);
                    jacobiInverso2 = (1 / (res1 * res4 - res2 * res3) * (-res2));
                    jacobiInverso3 = (1 / (res1 * res4 - res2 * res3) * (-res3));
                    jacobiInverso4 = (1 / (res1 * res4 - res2 * res3) * res1);

                    resSubFinal1 = jacobiInverso1 * valorSusFun1 + jacobiInverso2 * valorSusFun2;
                    String valorCasiFinal1 = String.valueOf(resSubFinal1);
                    binding.tvResCasiFinal1.setText(valorCasiFinal1);

                    resSubFinal2 = jacobiInverso3 * valorSusFun1 + jacobiInverso4 * valorSusFun2;
                    String valorCasiFinal2 = String.valueOf(resSubFinal2);
                    binding.tvResCasiFinal2.setText(valorCasiFinal2);

                    //Valores de la primera iteracion
                    valorX = String.valueOf(Double.parseDouble(valorX) - resSubFinal1);
                    String inversaX = String.valueOf(valorX);
                    binding.tvPrimerInversaX.setText("X: " + inversaX);

                    valorY = String.valueOf(Double.parseDouble(valorY) - resSubFinal2);
                    String inversaY = String.valueOf(valorY);
                    binding.tvPrimerInversaY.setText("X: " + inversaY);

                    //Segunda iteracion
                    res1 = (2 * Double.parseDouble(inversaX) + Double.parseDouble(inversaX));
                    res1 = (2 * Double.parseDouble(inversaX) + Double.parseDouble(inversaY));
                    res2 = Double.parseDouble(inversaX);
                    res3 = (3 * (Double.parseDouble(inversaY) * Double.parseDouble(inversaY)));
                    res4 = (1 + 6 * Double.parseDouble(inversaX) * Double.parseDouble(inversaY));

                    valorSusFun1 = (Double.parseDouble(inversaX) * Double.parseDouble(inversaX) + Double.parseDouble(inversaX) * Double.parseDouble(inversaY) - 10);

                    valorSusFun2 = (Double.parseDouble(inversaX) + 3 * Double.parseDouble(inversaX) * (Double.parseDouble(inversaY) * Double.parseDouble(inversaY)) - 57);

                    jacobiInverso1 = (1 / (res1 * res4 - res2 * res3) * res4);
                    jacobiInverso2 = (1 / (res1 * res4 - res2 * res3) * (-res2));
                    jacobiInverso3 = (1 / (res1 * res4 - res2 * res3) * (-res3));
                    jacobiInverso4 = (1 / (res1 * res4 - res2 * res3) * res1);

                    resSubFinal1 = jacobiInverso1 * valorSusFun1 + jacobiInverso2 * valorSusFun2;
                    resSubFinal2 = jacobiInverso3 * valorSusFun1 + jacobiInverso4 * valorSusFun2;

                    inversaX = String.valueOf(Double.parseDouble(inversaX) - resSubFinal1);
                    String inversaXIteracion2 = String.valueOf(inversaX);
                    binding.tvSegundaInversaX.setText("X: " + inversaXIteracion2);

                    inversaY = String.valueOf(Double.parseDouble(inversaY) - resSubFinal2);
                    String inversaYIteracion2 = String.valueOf(inversaY);
                    binding.tvSegundaInversaY.setText("X: " + inversaYIteracion2);

                    //Tercera iteracion
                    res1 = (2 * Double.parseDouble(inversaX) + Double.parseDouble(inversaX));
                    res1 = (2 * Double.parseDouble(inversaX) + Double.parseDouble(inversaY));
                    res2 = Double.parseDouble(inversaX);
                    res3 = (3 * (Double.parseDouble(inversaY) * Double.parseDouble(inversaY)));
                    res4 = (1 + 6 * Double.parseDouble(inversaX) * Double.parseDouble(inversaY));

                    valorSusFun1 = (Double.parseDouble(inversaX) * Double.parseDouble(inversaX) + Double.parseDouble(inversaX) * Double.parseDouble(inversaY) - 10);

                    valorSusFun2 = (Double.parseDouble(inversaX) + 3 * Double.parseDouble(inversaX) * (Double.parseDouble(inversaY) * Double.parseDouble(inversaY)) - 57);

                    jacobiInverso1 = (1 / (res1 * res4 - res2 * res3) * res4);
                    jacobiInverso2 = (1 / (res1 * res4 - res2 * res3) * (-res2));
                    jacobiInverso3 = (1 / (res1 * res4 - res2 * res3) * (-res3));
                    jacobiInverso4 = (1 / (res1 * res4 - res2 * res3) * res1);

                    resSubFinal1 = jacobiInverso1 * valorSusFun1 + jacobiInverso2 * valorSusFun2;
                    resSubFinal2 = jacobiInverso3 * valorSusFun1 + jacobiInverso4 * valorSusFun2;

                    inversaX = String.valueOf(Double.parseDouble(inversaX) - resSubFinal1);
                    String inversaXIteracion3 = String.valueOf(inversaX);
                    binding.tvTerceraInversaX.setText("X: " + inversaXIteracion3);

                    inversaY = String.valueOf(Double.parseDouble(inversaY) - resSubFinal2);
                    String inversaYIteracion3 = String.valueOf(inversaY);
                    binding.tvTerceraInversaY.setText("X: " + inversaYIteracion3);
                } else {
                    Toast.makeText(getContext(), "Debes de llenar X y X", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return binding.getRoot();
    }
}
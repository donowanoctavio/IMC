package com.example.octavio.calculadora_imc;

import android.app.Activity;
import android.content.DialogInterface;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lblResultado;
    private TextView lblSituacao;
    private EditText txtPeso;
    private EditText txtAltura;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         lblResultado = (TextView) findViewById(R.id.lblResultado);
         lblSituacao = (TextView) findViewById(R.id.lblSituacao);
         txtPeso = (EditText) findViewById(R.id.txtPeso);
         txtAltura = (EditText) findViewById(R.id.txtAltura);
         Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
         Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
         btnLimpar.setOnClickListener(this);
         btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float peso = Float.parseFloat(txtPeso.getText().toString());
        float altura = Float.parseFloat(txtAltura.getText().toString());
        float resultado = peso / (altura * altura);
        DecimalFormat df = new DecimalFormat("0.##");
        //formatando para duas casas decimais
        String resultadox = df.format(resultado);


        if (v.getId() == R.id.btnCalcular) {

            if (resultado < 16) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Magreza Grave");
            } else if (resultado > 16 && resultado <= 17) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Magreza Moderada");
            } else if (resultado > 17 && resultado <= 18.5) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Magreza Leve");
            } else if (resultado > 18.5 && resultado <= 25) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Peso Normal");
            } else if (resultado > 25 && resultado <= 30) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Sobrepeso");
            } else if (resultado > 30 && resultado <= 35) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Obeso Grau 1");
            } else if (resultado > 35 && resultado <= 40) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Obeso Grau 2 Severa");
            } else if (resultado > 40) {
                lblResultado.setText(resultadox);
                lblSituacao.setText("Obeso Grau 3 Mórbida");
            }

        } else if (v.getId() == R.id.btnLimpar) {
            lblResultado.setText("");
            lblSituacao.setText("");
            txtAltura.setText("");
            txtPeso.setText("");

        }
    }
}

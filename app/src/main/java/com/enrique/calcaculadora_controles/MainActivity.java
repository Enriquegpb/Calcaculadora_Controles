package com.enrique.calcaculadora_controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
String[] operadores={"+","-","*","/"};
String operacion;
public EditText edt1;
public EditText edt2;
public TextView tvr;
public Button btnr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1=(EditText) findViewById(R.id.op1);
        EditText edt2=(EditText) findViewById(R.id.op2);
        TextView tvr=(TextView) findViewById(R.id.tvr);

        Spinner sp=(Spinner) findViewById(R.id.sp);

        btnr=(Button) findViewById(R.id.br);

        sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,operadores));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                operacion= sp.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvr.setText("No hay seleccion");
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero;
                numero=(calcular_resultado(Integer.parseInt((String) edt1.getText().toString()),operacion,Integer.parseInt((String) edt2.getText().toString())));
               tvr.setText(String.valueOf(numero));
            }
        });
    }
    public int calcular_resultado(int op1,String operacion,int op2){
        int resultado=0;
        switch (operacion){
            case "+":
                resultado= op1+op2;
                break;
            case "-":
                resultado= op1-op2;
                break;
            case "*":
                resultado= op1*op2;
                break;
            case "/":
                resultado= op1/op2;
                break;
        }
        return resultado;
    }
}
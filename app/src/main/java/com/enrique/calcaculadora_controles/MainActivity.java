package com.enrique.calcaculadora_controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tsp=sp.getSelectedItem().toString();
                operacion=tsp;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvr.setText(calcular_resultado(op1,operacion,op2));
            }
        });

    }
    public int calcular_resultado(int op1,String operacion,int op2){
        switch (operacion){
            case "+":
                return op1+op2;
                break;
            case "-":
                return op1-op2;
                break;
            case "*":
                return op1*op2;
                break;
            case "/":
                return op1/op2;
                break;
        }
    }
}
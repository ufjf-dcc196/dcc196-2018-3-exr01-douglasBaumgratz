package com.example.douglas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExternoActivity extends AppCompatActivity {
    private EditText edtExterno;
    private EditText edtEmail;
    private Button btnCadastroExterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);
        edtExterno = (EditText) findViewById(R.id.edt_externo);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        btnCadastroExterno = (Button) findViewById(R.id.btn_cadastrar_externo);

        btnCadastroExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultadoExterno = new Intent();
                resultadoExterno.putExtra(MainActivity.NOME, edtExterno.getText().toString());
                resultadoExterno.putExtra(MainActivity.EXTRA, edtEmail.getText().toString());
                setResult(Activity.RESULT_OK, resultadoExterno);
                finish();
            }
        });

        Toast.makeText(getApplicationContext(), "Olá Externo!", Toast.LENGTH_SHORT).show();

    }
}

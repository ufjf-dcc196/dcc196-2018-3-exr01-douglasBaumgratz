package com.example.douglas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlunoActivity extends AppCompatActivity {

    private EditText edtAluno;
    private EditText edtMatricula;
    private Button btnCadastroAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        edtAluno = (EditText) findViewById(R.id.edt_aluno);
        edtMatricula = (EditText) findViewById(R.id.edt_matricula);
        btnCadastroAluno = (Button) findViewById(R.id.btn_cadastrar_aluno);

        btnCadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultadoAluno = new Intent();
                resultadoAluno.putExtra(MainActivity.NOME, edtAluno.getText().toString());
                resultadoAluno.putExtra(MainActivity.EXTRA, edtMatricula.getText().toString());
                setResult(Activity.RESULT_OK, resultadoAluno);
                finish();
            }
        });

        Toast.makeText(getApplicationContext(), "Olá Aluno!", Toast.LENGTH_SHORT).show();

    }
}

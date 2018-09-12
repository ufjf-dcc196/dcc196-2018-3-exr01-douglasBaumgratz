package com.example.douglas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String NOME = "nome";
    public static final String EXTRA = "extra";
    public static final int REQUEST_ALUNO = 1;
    public static final int REQUEST_SERVIDOR = 2;
    public static final int REQUEST_EXTERNO = 3;

    private Button btnAluno;
    private Button btnServidor;
    private Button btnExterno;
    private TextView txtQtdAluno;
    private TextView txtQtdServidor;
    private TextView txtQtdExterno;
    private HashMap<String, String> alunos;
    private HashMap<String, String> servidores;
    private HashMap<String, String> externos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alunos = new HashMap<>();
        servidores = new HashMap<>();
        externos = new HashMap<>();

        txtQtdAluno = (TextView) findViewById(R.id.txt_quantidade_aluno);
        btnAluno = (Button) findViewById(R.id.btn_aluno);
        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAluno = new Intent(MainActivity.this, AlunoActivity.class);
                startActivityForResult(intentAluno, MainActivity.REQUEST_ALUNO);
            }
        });

        txtQtdServidor = (TextView) findViewById(R.id.txt_quantidade_servidor);
        btnServidor = (Button) findViewById(R.id.btn_servidor);
        btnServidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentServidor = new Intent(MainActivity.this, ServidorActivity.class);
                startActivityForResult(intentServidor, MainActivity.REQUEST_SERVIDOR);
            }
        });

        txtQtdExterno = (TextView) findViewById(R.id.txt_quantidade_externo);
        btnExterno = (Button) findViewById(R.id.btn_externo);
        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExterno = new Intent(MainActivity.this, ExternoActivity.class);
                startActivityForResult(intentExterno, MainActivity.REQUEST_EXTERNO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.REQUEST_ALUNO && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultadoAluno = data.getExtras();
            String nomeAluno = bundleResultadoAluno.getString(MainActivity.NOME);
            String matriculaAluno = bundleResultadoAluno.getString(MainActivity.EXTRA);
            alunos.put(matriculaAluno, nomeAluno);
            Toast.makeText(getApplicationContext(), "Aluno: " + nomeAluno + ". Matrícula: " + matriculaAluno + ". Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            txtQtdAluno.setText("Total de alunos: " + alunos.size());
        } else if (requestCode == MainActivity.REQUEST_SERVIDOR && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultadoServidor = data.getExtras();
            String nomeServidor = bundleResultadoServidor.getString(MainActivity.NOME);
            String siapeServidor = bundleResultadoServidor.getString(MainActivity.EXTRA);
            servidores.put(siapeServidor, nomeServidor);
            Toast.makeText(getApplicationContext(), "Servidor: " + nomeServidor + ". Siape: " + siapeServidor + ". Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            txtQtdServidor.setText("Total de servidores: " + servidores.size());
        } else if (requestCode == MainActivity.REQUEST_EXTERNO && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultadoExterno = data.getExtras();
            String nomeExterno = bundleResultadoExterno.getString(MainActivity.NOME);
            String emailEsterno = bundleResultadoExterno.getString(MainActivity.EXTRA);
            externos.put(emailEsterno, nomeExterno);
            Toast.makeText(getApplicationContext(), "Externo: " + nomeExterno + ". E-mail: " + emailEsterno + ". Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            txtQtdExterno.setText("Total de externos cadastrados: " + externos.size());
        }
    }

}

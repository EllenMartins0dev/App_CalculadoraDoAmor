package com.ellen.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NomesActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNome1;
    private EditText editTextNome2;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomes);

        EditText editTextNome1 = findViewById(R.id.editTextNome1);
        EditText editTextNome2 = findViewById(R.id.editTextNome2);

        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbarNomes);
        setSupportActionBar(toolbar);
    }

    // Faz o ícone da setinha voltar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_voltar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Verifica se o item do menu foi clicado
        if (item.getItemId() == R.id.menu_abrir_tela) {
            // Navegue para a nova tela
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void calcularAmor() {
        String nome1 = editTextNome1.getText().toString();
        String nome2 = editTextNome2.getText().toString();
        String nomesConcatenados = nome1 + nome2;

        int somaNomes = nomesConcatenados.length();
        int porcentagem = somaNomes % 101;
        
        Toast.makeText(this, "A porcentagem de amor é: " + porcentagem + "%", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCalcular) {
            calcularAmor();
        }


    }
}

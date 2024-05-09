package com.ellen.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ellen.myapplication.Som;

public class NomesActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNome1;
    private EditText editTextNome2;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomes);

         editTextNome1 = findViewById(R.id.editTextNome1);
         editTextNome2 = findViewById(R.id.editTextNome2);

        buttonCalcular = findViewById(R.id.buttonCalcular);
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

        if (nome1.isEmpty() || nome2.isEmpty()) {
            Toast.makeText(this, "Por favor, insira o nome.", Toast.LENGTH_SHORT).show();
            return;
        }

        String nomesConcatenados = nome1 + nome2;

        int somaNomes = nomesConcatenados.length();
        int porcentagem = somaNomes % 101;

        Som.tocarMusica(this, porcentagem);

        String mensagem;
        if (porcentagem >= 0 && porcentagem < 30) {
            mensagem = "Sua porcentagem é de " + porcentagem + "%. Isso é tudo, menos amor. Sinto muito :<";
        } else if (porcentagem >= 30 && porcentagem < 50) {
            mensagem = "Sua porcentagem é de " + porcentagem + "%. Talvez isso seja alguma coisa, mas não seja afobado e observe bem";
        }

        else if (porcentagem >= 50 && porcentagem < 80) {
            mensagem = "Sua porcentagem é de " + porcentagem + "%. Você está entrando no amor. Invista e valorize seu parceiro :>";
        } else {
            mensagem = "Sua porcentagem é de " + porcentagem + "%. Isso é com certeza é amor, parabéns <3";
        }

        // Exibir pop-up com a mensagem personalizada
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensagem)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Fecha o diálogo se o usuário clicar em OK
                        dialog.dismiss();
                        Som.parar();
                        Som.tocarTrilha(NomesActivity.this, R.raw.trilha);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();



// limpa os campos
        editTextNome1.setText("");
        editTextNome2.setText("");
    }


    // Para o som ao fechar o app
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Som.parar();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCalcular) {
            calcularAmor();
        }
    }
}

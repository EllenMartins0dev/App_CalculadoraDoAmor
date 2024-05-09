package com.ellen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageButton imageButtonAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButtonAvancar = findViewById(R.id.imageButtonAvancar);
        imageButtonAvancar.setOnClickListener(this);

        Som.executar(this, R.raw.trilha);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButtonAvancar) {
            Intent intent = new Intent(this, NomesActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewNewUser extends AppCompatActivity {

    Button btnConfirmar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_new_user);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);
        Bundle datos = getIntent().getExtras();
        btnConfirmar.setText(datos.getString("btnConfirmar"));
        btnCancelar.setText(datos.getString("btnCancelar"));

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objMenu = new Intent(getApplicationContext(), Home.class);
                startActivity(objMenu);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objAtras = new Intent();
                objAtras.putExtra("atras", "Cancelo la operacion");
                setResult(RESULT_OK, objAtras);
                finish();

            }
        });
    }

}

package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindDeleteOrUpdate extends AppCompatActivity {

    Button btnBuscar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_delete_or_update);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objShowUserFinded = new Intent(getApplicationContext(), ViewNewUser.class);
                objShowUserFinded.putExtra("btnCancelar", "Regresar");
                objShowUserFinded.putExtra("btnConfirmar", "Ir a menu");

                startActivityForResult(objShowUserFinded, 1);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent objHome = new Intent(getApplicationContext(), Home.class);
                startActivity(objHome);
                finish();
            }
        });
    }
}

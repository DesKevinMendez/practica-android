package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewUser extends AppCompatActivity {

    Button btnGuardar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objViewInfoUser = new Intent(getApplicationContext(), ViewNewUser.class);
                objViewInfoUser.putExtra("btnCancelar", "Cancelar");
                objViewInfoUser.putExtra("btnConfirmar", "Confirmar");
                startActivityForResult(objViewInfoUser, 2);

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    TextView edtCorreo, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCorreo = findViewById(R.id.edtCorreo);
        edtPass = findViewById(R.id.edtClave);

        btnAceptar = findViewById(R.id.btnGuardar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtCorreo.getText().toString().trim();
                String clave = edtPass.getText().toString().trim();
                String verificarCorreo = "kevin@mail.com";
                String verificarPass = "secret";
                if (verificarCorreo.equals(email) && verificarPass.equals(clave)) {
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent objHome = new Intent(getApplicationContext(), Home.class);
                    startActivity(objHome);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "No coinciden los datos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

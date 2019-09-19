package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindDeleteOrUpdate extends AppCompatActivity {

    Button btnBuscar, btnCancelar;
    EditText edtCorreo;
    Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_delete_or_update);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnCancelar = findViewById(R.id.btnCancelar);
        edtCorreo = findViewById(R.id.edtCorreo);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = edtCorreo.getText().toString().trim();

                boolean buscarUsers = usuarios.buscarUsuario(correo);
                if (buscarUsers) {

                    Intent objShowUserFinded = new Intent(getApplicationContext(), ViewNewUser.class);
                    objShowUserFinded.putExtra("btnCancelar", "Regresar");
                    objShowUserFinded.putExtra("btnConfirmar", "Ir a menu");
                    objShowUserFinded.putExtra("btnConfirmar", "Ir a menu");
                    objShowUserFinded.putExtra("nombre", usuarios.getNombres(correo));
                    objShowUserFinded.putExtra("correo", correo);
                    objShowUserFinded.putExtra("pass", usuarios.getClaves(correo));
                    objShowUserFinded.putExtra("tipoUsuario", usuarios.getTipos(correo));
                    startActivityForResult(objShowUserFinded, 1);
                } else {
                    Toast.makeText(getApplicationContext(), "No se ha encontrado", Toast.LENGTH_LONG).show();
                }

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

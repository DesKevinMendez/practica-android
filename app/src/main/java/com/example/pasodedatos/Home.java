package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pasodedatos.StaticDataClass.NavegationEditDelete;

public class Home extends AppCompatActivity {

    Button btnNuevo, btnBuscar, btnEditar, btnEliminar, btnSalir, btnListado;
    NavegationEditDelete navegationEditDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnNuevo = findViewById(R.id.btnNuevo);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnSalir = findViewById(R.id.btnSalir);
        btnListado = findViewById(R.id.btnListado);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objNewUser = new Intent(getApplicationContext(), NewEditUser.class);
                startActivity(objNewUser);

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objFindUpdateOrDelete = new Intent(getApplicationContext(), FindDeleteOrUpdate.class);
                startActivity(objFindUpdateOrDelete);

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objFindUpdateOrDelete = new Intent(getApplicationContext(), FindDeleteOrUpdate.class);
                startActivity(objFindUpdateOrDelete);
                navegationEditDelete.setActions("Editar");

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objFindUpdateOrDelete = new Intent(getApplicationContext(), FindDeleteOrUpdate.class);
                startActivity(objFindUpdateOrDelete);
                navegationEditDelete.setActions("Eliminar");

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objSalir = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(objSalir);
                finish();

            }
        });

        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listVIewUser = new Intent(getApplicationContext(), ListViewUser.class);
                startActivity(listVIewUser);
            }
        });
    }
}

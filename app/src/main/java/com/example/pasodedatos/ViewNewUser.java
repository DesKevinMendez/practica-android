package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewNewUser extends AppCompatActivity {

    Button btnConfirmar, btnCancelar;
    TextView txtNombre, txtCorreo, txtClave, txtTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_new_user);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);

        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtPass);
        txtTipo = findViewById(R.id.txtTipo);

        Bundle datos = getIntent().getExtras();

        btnConfirmar.setText(datos.getString("btnConfirmar"));
        btnCancelar.setText(datos.getString("btnCancelar"));

        String nombre = datos.getString("nombre");
        String clave = datos.getString("pass");
        String correo = datos.getString("correo");
        String tipoUsuario = datos.getString("tipoUsuario");

        if (nombre == null) {
            nombre = "";
        }

        if (clave == null) {
            clave = "";
        }

        if (correo == null) {
            correo = "";
        }
        if (tipoUsuario == null) {
            tipoUsuario = "";
        }

        txtNombre.setText("Nombre: " +nombre);
        txtClave.setText("Clave: " +clave);
        txtCorreo.setText("Correo: " +correo);
        txtTipo.setText("Tipo de usuario: " +tipoUsuario);

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

package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pasodedatos.StaticDataClass.NavegationEditDelete;

public class ViewNewUser extends AppCompatActivity {

    Button btnConfirmar, btnCancelar;
    TextView txtNombre, txtCorreo, txtClave, txtTipo;
    NavegationEditDelete navegationEditDelete;
    SQLiteDatabase base;
    String nombre, clave, correo, tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_new_user);

        Datos objDatos = new Datos(getApplicationContext(), "mantoUsuarios", null, 1);
        base = objDatos.getWritableDatabase();

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);

        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtPass);
        txtTipo = findViewById(R.id.txtTipo);

        Bundle datos = getIntent().getExtras();

        btnConfirmar.setText(datos.getString("btnConfirmar"));
        btnCancelar.setText(datos.getString("btnCancelar"));

        nombre = datos.getString("nombre");
        clave = datos.getString("pass");
        correo = datos.getString("correo");
        tipoUsuario = datos.getString("tipoUsuario");

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

        if (navegationEditDelete.getActions().equals("Eliminar")) {
            btnConfirmar.setText(navegationEditDelete.getActions());
        }

        if (navegationEditDelete.getActions().equals("Editar")) {
            btnConfirmar.setText(navegationEditDelete.getActions());
        }

        txtNombre.setText("Nombre: " +nombre);
        txtClave.setText("Clave: " +clave);
        txtCorreo.setText("Correo: " +correo);
        txtTipo.setText("Tipo de usuario: " +tipoUsuario);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (navegationEditDelete.getActions().equals("Eliminar")) {

                    base.execSQL("delete from usuarios where correos = '"+ correo +"'");
                    Intent objMenu = new Intent(getApplicationContext(), Home.class);
                    startActivity(objMenu);

                } else if (navegationEditDelete.getActions().equals("Editar")) {

                    Intent objEditUser = new Intent(getApplicationContext(), NewEditUser.class);
                    objEditUser.putExtra("nombre", nombre);
                    objEditUser.putExtra("clave", clave);
                    objEditUser.putExtra("correo", correo);
                    objEditUser.putExtra("tipoUsuario", tipoUsuario);
                    startActivity(objEditUser);

                } else if (btnConfirmar.getText().equals("Confirmar")
                        || btnConfirmar.getText().equals("Ir a menu")) {

                    Intent objHome = new Intent(getApplicationContext(), Home.class);
                    startActivity(objHome);
                }

                navegationEditDelete.setActions("");

                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objAtras = new Intent();
                objAtras.putExtra("atras", "Cancelo la operacion");
                setResult(RESULT_OK, objAtras);
                navegationEditDelete.setActions("");
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navegationEditDelete.setActions("");
    }
}

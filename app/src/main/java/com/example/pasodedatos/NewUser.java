package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class NewUser extends AppCompatActivity {

    Button btnGuardar, btnCancelar;
    EditText edtNombre, edtCorreo, edtPass, edtConfirPass;
    RadioButton rdbUsuario, rdbAdmin, rdbAsistente;
    Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtPass = findViewById(R.id.edtPass);
        edtConfirPass = findViewById(R.id.edtConfirPass);

        rdbUsuario = findViewById(R.id.rdbUsuario);
        rdbAdmin = findViewById(R.id.rdbAdmin);
        rdbAsistente = findViewById(R.id.rdbAsistente);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = edtNombre.getText().toString().trim();
                String correo = edtCorreo.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                String confiPass = edtConfirPass.getText().toString().trim();
                String tipoUsuario = rdbUsuario.isChecked() ? "Usuario" : rdbAdmin.isChecked() ? "Administrador" : "Asistente";

                if (nombre.isEmpty()) {
                    edtNombre.setError("El nombre es requerido");
                    edtNombre.requestFocus();
                } else if (correo.isEmpty()) {

                    edtCorreo.setError("El correo es requerido");
                    edtCorreo.requestFocus();
                } else if (pass.equals(confiPass)) {

                    Intent objViewInfoUser = new Intent(getApplicationContext(), ViewNewUser.class);
                    objViewInfoUser.putExtra("btnCancelar", "Cancelar");
                    objViewInfoUser.putExtra("btnConfirmar", "Confirmar");
                    objViewInfoUser.putExtra("nombre", nombre);
                    objViewInfoUser.putExtra("correo", correo);
                    objViewInfoUser.putExtra("pass", pass);
                    objViewInfoUser.putExtra("tipoUsuario", tipoUsuario);

                    usuarios.saveMailUser(correo);
                    usuarios.saveNameUser(nombre);
                    usuarios.savePassUser(pass);
                    usuarios.saveTypeUser(tipoUsuario);

                    startActivityForResult(objViewInfoUser, 2);



                } else {
                    Toast.makeText(getApplicationContext(), "Tu contraseña no coincide", Toast.LENGTH_LONG).show();

                }



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

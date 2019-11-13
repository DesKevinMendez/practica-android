package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.pasodedatos.StaticDataClass.Usuarios;

public class NewEditUser extends AppCompatActivity {

    Button btnGuardar, btnCancelar;
    EditText edtNombre, edtCorreo, edtPass, edtConfirPass;
    RadioButton rdbUsuario, rdbAdmin, rdbAsistente;
    Usuarios usuarios;
    SQLiteDatabase base;
    Bundle editar;
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

        Datos dbDatoss = new Datos(getApplicationContext(), "mantoUsuarios", null, 1);
        base = dbDatoss.getWritableDatabase();



        editar = getIntent().getExtras();
        if (editar != null){
            btnGuardar.setText("Actualizar");

            edtCorreo.setText(editar.getString("correo"));
            edtCorreo.setFocusableInTouchMode(false);
            edtCorreo.setFocusable(false);

            edtNombre.setText(editar.getString("nombre"));

            edtPass.setText(editar.getString("clave"));

            edtConfirPass.setText(editar.getString("clave"));

            if (editar.getString("tipoUsuario").equals("Usuario")){

                rdbUsuario.setChecked(true);

            } else if (editar.getString("tipoUsuario").equals("Administrador")){

                rdbAdmin.setChecked(true);

            } else {

                rdbAsistente.setChecked(true);
            }

        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = edtNombre.getText().toString().trim();
                String correo = edtCorreo.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                String confiPass = edtConfirPass.getText().toString().trim();
                String tipoUsuario = rdbUsuario.isChecked() ? "Usuario" : rdbAdmin.isChecked() ? "Administrador" : "Asistente";

                Usuarios.saveMailUser(correo);
                
                if (nombre.isEmpty()) {
                    edtNombre.setError("El nombre es requerido");
                    edtNombre.requestFocus();
                } else if (correo.isEmpty()) {

                    edtCorreo.setError("El correo es requerido");
                    edtCorreo.requestFocus();
                } else if (pass.equals(confiPass)) {

                    if (editar != null) {
                        String consutaInsertSQL = "update usuarios set nombres = '"+ nombre +"'," +
                                "claves= '"+ pass+"', niveles = '"+ tipoUsuario+"'" +
                                "where correos = '"+ correo +"'";

                        base.execSQL(consutaInsertSQL);
                        Intent objHome = new Intent(getApplicationContext(), Home.class);
                        startActivity(objHome);

                    } else {

                        usuarios.saveMailUser(correo);
                        usuarios.saveNameUser(nombre);
                        usuarios.savePassUser(pass);
                        usuarios.saveTypeUser(tipoUsuario);

                        String consutaInsertSQL = "insert into usuarios(correos, nombres, claves, niveles)";
                        consutaInsertSQL += "values('"+correo+"', '"+ nombre +"', '"+ pass +"', '" + tipoUsuario + "')";

                        base.execSQL(consutaInsertSQL);
                    }


                    Intent objViewInfoUser = new Intent(getApplicationContext(), ViewNewUser.class);
                    objViewInfoUser.putExtra("btnCancelar", "Cancelar");
                    objViewInfoUser.putExtra("btnConfirmar", "Confirmar");
                    objViewInfoUser.putExtra("nombre", nombre);
                    objViewInfoUser.putExtra("correo", correo);
                    objViewInfoUser.putExtra("pass", pass);
                    objViewInfoUser.putExtra("tipoUsuario", tipoUsuario);

                    Log.i("MENSAJE", "SE CREO EL USUARIO");
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

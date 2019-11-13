package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pasodedatos.StaticDataClass.Usuarios;

public class FindDeleteOrUpdate extends AppCompatActivity {

    Button btnBuscar, btnCancelar;
    EditText edtCorreo;
    Usuarios usuarios;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_delete_or_update);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnCancelar = findViewById(R.id.btnCancelar);
        edtCorreo = findViewById(R.id.edtCorreo);

        Datos dbDatoss = new Datos(getApplicationContext(), "mantoUsuarios", null, 1);
        base = dbDatoss.getWritableDatabase();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = edtCorreo.getText().toString().trim();


                String consultaSql = "select * from usuarios where correos = '"+correo+"'";

                Cursor matriz = base.rawQuery(consultaSql, null);

                if(matriz.moveToNext()){
                    Intent objShowUserFinded = new Intent(getApplicationContext(), ViewNewUser.class);
                    objShowUserFinded.putExtra("btnCancelar", "Regresar");
                    objShowUserFinded.putExtra("btnConfirmar", "Ir a menu");
                    objShowUserFinded.putExtra("nombre", matriz.getString(1));
                    objShowUserFinded.putExtra("correo", correo);
                    objShowUserFinded.putExtra("pass", matriz.getString(2));
                    objShowUserFinded.putExtra("tipoUsuario", matriz.getString(3));
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

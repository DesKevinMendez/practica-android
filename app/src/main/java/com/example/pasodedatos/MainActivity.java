package com.example.pasodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    TextView edtCorreo, edtPass;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCorreo = findViewById(R.id.edtCorreo);
        edtPass = findViewById(R.id.edtClave);

        btnAceptar = findViewById(R.id.btnGuardar);
        Datos dbDatoss = new Datos(getApplicationContext(), "mantoUsuarios", null, 1);
        base = dbDatoss.getWritableDatabase();
        Log.i("MENSAJE", "SE CREO LA BASE");


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtCorreo.getText().toString().trim();
                String clave = edtPass.getText().toString().trim();

                String consultaSql = "select * from usuarios where correos = '"+email+"' and claves = '"+  clave +"'";

                Cursor matriz = base.rawQuery(consultaSql, null);

                if(matriz.moveToNext()){

                    if (matriz.getString(0).equals(email) && matriz.getString(2).equals(clave)) {
                        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                        Intent objHome = new Intent(getApplicationContext(), Home.class);
                        startActivity(objHome);
                        finish();
                    } else {

                        Toast.makeText(getApplicationContext(), "No coinciden los datos", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Usuario no existente", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

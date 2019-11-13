package com.example.pasodedatos;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pasodedatos.StaticDataClass.Usuarios;

import java.util.ArrayList;

public class ListViewUser extends ListActivity {

    Usuarios usuarios;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Datos objDatos = new Datos(getApplicationContext(), "mantoUsuarios", null, 1);
        base = objDatos.getWritableDatabase();

        ArrayList listado = new ArrayList();

        String consultaSelect = "select * from usuarios";
        Cursor cListado = base.rawQuery(consultaSelect, null);

        usuarios.setCleanData();
        while(cListado.moveToNext()) {
            listado.add("Correo " + cListado.getString(0)
                    + "\nNombre: " + cListado.getString(1)
                    + "\nClave: "+ cListado.getString(2)
                    + "\nTipo Usuario: "+ cListado.getString(3));

            usuarios.saveMailUser(cListado.getString(0));
            usuarios.saveNameUser(cListado.getString(1));
            usuarios.savePassUser(cListado.getString(2));
            usuarios.saveTypeUser(cListado.getString(3));
        }


        ArrayAdapter<String> ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listado);
        setListAdapter(ad);
    }
    public  void onListItemClick(ListView lista, View vista, int indice, long id){

        String correo = usuarios.getEmailUser(indice);

        Toast.makeText(this, correo, Toast.LENGTH_SHORT).show();

        Intent objShowUserFinded = new Intent(getApplicationContext(), ViewNewUser.class);
        objShowUserFinded.putExtra("btnCancelar", "Regresar");
        objShowUserFinded.putExtra("btnConfirmar", "Ir a menu");
        objShowUserFinded.putExtra("nombre", usuarios.getNombres(correo));
        objShowUserFinded.putExtra("correo", correo);
        objShowUserFinded.putExtra("pass", usuarios.getClaves(correo));
        objShowUserFinded.putExtra("tipoUsuario", usuarios.getTipos(correo));
        startActivityForResult(objShowUserFinded, 1);

    }
}

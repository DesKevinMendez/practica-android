package com.example.pasodedatos;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListViewUser extends ListActivity {

    Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList ListUsers = new ArrayList();

        for (int i= 0; i< usuarios.getCantidadRegistros(); i++ ) {
            ListUsers.add(usuarios.getUsuario(i));
        }

        ArrayAdapter<String> ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListUsers);
        setListAdapter(ad);
    }
    public  void onListItemClick(ListView lista, View vista, int indice, long id){

        String correo = usuarios.getEmailUser(indice);

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

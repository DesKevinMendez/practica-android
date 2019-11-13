package com.example.pasodedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Datos extends SQLiteOpenHelper {

    public Datos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuarios(correos text primary key, nombres text, claves text, niveles text)");
        Log.i("MENSAJE", "SE CREO LA TABLA");
        sqLiteDatabase.execSQL("insert into usuarios(correos, nombres, claves, niveles) " +
                "values('kevin@mail.com', 'Kevin Mendez', 'secret', 'administrador')");
        Log.i("MENSAJE", "SE CREO El PRIMER USUARIO");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

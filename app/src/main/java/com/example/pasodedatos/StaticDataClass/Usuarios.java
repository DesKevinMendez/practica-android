package com.example.pasodedatos.StaticDataClass;

import java.util.ArrayList;

public final class Usuarios {

    private static ArrayList correos = new ArrayList();
    private static ArrayList nombres = new ArrayList();
    private static ArrayList claves = new ArrayList();
    private static ArrayList tipos = new ArrayList();

    public static void saveMailUser (String correo) {
        correos.add(correo);
    }
    public static void saveNameUser (String nombre) {
        nombres.add(nombre);
    }
    public static void savePassUser (String pass) {
        claves.add(pass);
    }
    public static void saveTypeUser (String tipo) {
        tipos.add(tipo);
    }

    public static String getNombres(String correo){
        return nombres.get(correos.indexOf(correo)).toString().trim();
    }
    public  static String getClaves(String correo){
        return claves.get(correos.indexOf(correo)).toString().trim();
    }

    public  static String getTipos(String correo){
        return tipos.get(correos.indexOf(correo)).toString().trim();
    }

    public static String getEmailUser(int position) {
        return correos.get(position).toString().trim();
    }

    public static void setCleanData(){
        correos.clear();
        nombres.clear();
        claves.clear();
        tipos.clear();
    }

}

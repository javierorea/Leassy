package com.example.javier.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.ListView;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
{
    public AdminSQLiteOpenHelper(Context context, String Nombre, int version, CursorFactory cursorFactory)
    {
        super(context,Nombre,cursorFactory,version);//llamar al constructor
    }

    public void onCreate(SQLiteDatabase base)
    {
        String query = "CREATE TABLE app(categoria integer, frase text,rutaAudio text)";
        base.execSQL(query);//crear la base de datos local
        ContentValues insertar = new ContentValues();
        insertar.put("categoria",0);
        insertar.put("frase","Solicitar información");
        insertar.put("rutaAudio","null");
        base.insert("app", null, insertar);


        insertar = new ContentValues();
        insertar.put("categoria",0);
        insertar.put("frase","Saludar");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("frase","Pedir horarios");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("frase","Pedir indicaciones");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);


        insertar = new ContentValues();
        insertar.put("categoria",2);
        insertar.put("frase","Tramitar pasaporte");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",2);
        insertar.put("frase","Saludar");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",3);
        insertar.put("frase","Pedir horarios");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",3);
        insertar.put("frase","Pedir indicaciones");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",4);
        insertar.put("frase","Tramitar pasaporte");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);
    }

    public void onUpgrade(SQLiteDatabase base, int valor, int val)
    {
        /*String query = "DROP TABLE IF EXIST app";
        base.execSQL(query);
        query = "CREATE TABLE app(categoria integer,frase text,rutaAudio text);";
        base.execSQL(query);
        ContentValues insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("frase","Pedir indicaciones");
        insertar.put("rutaAudio","null");

        base.insert("app", null, insertar);
        insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("frase","Pedir horarios");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);*/

    }
}

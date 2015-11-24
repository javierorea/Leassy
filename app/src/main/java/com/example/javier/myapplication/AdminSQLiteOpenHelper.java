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
        base.execSQL("CREATE TABLE categorias(id integer, frase text)");//Tabla de categorías

        base.execSQL("insert into categorias values(0, 'Gobierno');");
        base.execSQL("insert into categorias values(1, 'Comida');");
        base.execSQL("insert into categorias values(2, 'Vía Pública');");
        base.execSQL("insert into categorias values(3, 'Transporte');");
        base.execSQL("insert into categorias values(4, 'Deportes');");
        base.execSQL("insert into categorias values(5, 'Información');");
        base.execSQL("insert into categorias values(6, 'Salud');");
        //base.execSQL("insert into categorias values(7, 'Extra');");

        base.execSQL("create table frases(id integer, idfrase integer, frase text, fraseing text, audio text, imagen text)");//Tabla de frases

        base.execSQL("insert into frases values(0, 0, 'Solicitar información', 'Ask for information', 'askforinformation', 'info');");
        base.execSQL("insert into frases values(0, 1, 'Solicitar pasaporte', 'Ask for passport', 'askforpassport', 'passport');");
        base.execSQL("insert into frases values(0, 2, '¿Cómo se llama su presidente?', 'What is your president´s name?', 'whatisyourpresidentsname', 'president');");
        base.execSQL("insert into frases values(0, 3, '¿Cuánto dura su presidente en su rango?', 'How longer does your president last in his post?', 'howlongerdoesyourpresidentlastinhispost', 'durapresidencia');");
        base.execSQL("insert into frases values(0, 4, '¿Cuántos estados tiene su país?', 'How many states do your country have?', 'howmanystatesdoyourcountryhave', 'estados');");

        base.execSQL("insert into frases values(1, 0, '¿Dónde está el restaurant más cercano?', 'Where is the nearest restaurant?', 'whereisthenearestrestaurant', 'restaurant');");
        base.execSQL("insert into frases values(1, 1, '¿Cuál es el mejor lugar para comer?', 'Which one is the best place to eat?', 'whichoneisthebestplacetoeat', 'lugarparacomer');");
        base.execSQL("insert into frases values(1, 2, '¿Dónde puedo encontrar una pizzería?', 'Where can i find a pizza place?', 'wherecanifindapizzaplace', 'pizzeria');");
        base.execSQL("insert into frases values(1, 3, '¿Dónde puedo tomar una taza de café?', 'Where can i drink a cup of coffe?', 'wherecanidrinkacupofcoffee', 'cafe');");
        base.execSQL("insert into frases values(1, 4, '¿Puedo tomar una botella de agua?', 'May i have a bottle of water?', 'mayihaveabottleofwater', 'botellaagua');");

        base.execSQL("insert into frases values(2, 0, '¿Qué calle es esta?', 'What street is this?', 'whatstreetisthis', 'street');");
        base.execSQL("insert into frases values(2, 1, '¿En dónde está el museo?', 'Where is the museum?', 'whereisthemuseum', 'museo');");
        base.execSQL("insert into frases values(2, 2, '¿Dónde está la estación de autobuses?', 'Where is the bus station?', 'whereisthebusstation', 'busstation');");
        base.execSQL("insert into frases values(2, 3, '¿Dónde puedo tomar un taxi?', 'Where can i take a cab?', 'wherecanitakeacab', 'taxi');");
        base.execSQL("insert into frases values(2, 4, '¿Cuál es el hotel más cercano?', 'Which one is the nearest hotel?', 'whichoneisthenearesthotel', 'hotel');");

        base.execSQL("insert into frases values(3, 0, '¿Dónde se encuentra el aeropuerto?', 'Where is the airport?', 'whereistheairport', 'airport');");
        base.execSQL("insert into frases values(3, 1, '¿Me puede llevar a la estación de tren, por favor?', 'Can you take me to the train station, please?', 'canyoutakemetothetrainstationplease', 'trainstation');");
        base.execSQL("insert into frases values(3, 2, '¿Puede indicarme cómo llegar a esta dirección?', 'Can you tell me how can i go to this direction?', 'canyoutellmehowcanigotothisdirection', 'indication');");
        base.execSQL("insert into frases values(3, 3, '¿Qué tan lejos está el centro?', 'How far is the downtown?', 'howfaristhedowntown', 'direction');");
        base.execSQL("insert into frases values(3, 4, '¿Cuánto me cuesta llegar al centro?', 'How much cost me to get to downtown?', 'howmuchcostmetogettodowntown', 'costotaxi');");

        base.execSQL("insert into frases values(4, 0, '¿Cómo se llama el equipo de football local?', 'What is the name of the local football team?', 'whatisthenameofthelocalfootballteam', 'futbolteams');");
        base.execSQL("insert into frases values(4, 1, '¿Qué deporte se practica más por aquí?', 'What is the must common sport around here?', 'whatisthemustcommonsportaroundhere', 'sports');");
        base.execSQL("insert into frases values(4, 2, '¿Dónde puedo hacer ejercicio?', 'Where can i exercise?', 'wherecaniexercise', 'exercise');");
        base.execSQL("insert into frases values(4, 3, '¿Hacia dónde queda el estadio de football?', 'Where is the football stadium?', 'whereisthefootballstadium', 'futbolstadium');");
        base.execSQL("insert into frases values(4, 4, '¿Dónde puedo practicar baseball?', 'Where can i practice baseball?', 'wherecanipracticebaseball', 'batingbox');");

        base.execSQL("insert into frases values(5, 0, '¿Dónde puedo comprar un boleto de autobus?', 'Where can i buy a bus ticket?', 'wherecanibuyabusticket', 'taquilla');");
        base.execSQL("insert into frases values(5, 1, '¿Dónde está la embajada?', 'Where is the embassy?', 'whereistheembassy', 'emajada');");
        base.execSQL("insert into frases values(5, 2, '¿Dónde puedo obtener mi visa?', 'Where can i get my visa?', 'wherecanigetmyvisa', 'visa');");
        base.execSQL("insert into frases values(5, 3, '¿Puedo pagar con tarjeta de crédito?', 'May i pay with my credit card?', 'mayipaywithmycreditcard', 'credcard');");
        base.execSQL("insert into frases values(5, 4, '¿Dónde encuentro información de viajes?', 'Where can i find travel information?', 'wherecanifindtravelinformation', 'travelinfo');");

        base.execSQL("insert into frases values(6, 0, '¿Dónde está el hospital más cercano?', 'Where is the nearest hospital?', 'whereisthenearesthospital', 'hospital');");
        base.execSQL("insert into frases values(6, 1, '¿Cuándo puedo ver al doctor?', 'When can i see the doctor?', 'whencaniseethedoctor', 'doctor');");
        base.execSQL("insert into frases values(6, 2, '¿Me puede vender una aspirina?', 'Can you sell me an aspirine?', 'canyousellmeanaspirine', 'aspirina');");
        base.execSQL("insert into frases values(6, 3, '¿Por dónde hay una farmacia?', 'Where is a pharmacy?', 'whereisapharmacy', 'farmacia');");
        base.execSQL("insert into frases values(6, 4, '¿Me puede ayudar? Creo que me rompí la pierna', 'Can you help me? I think i broke a leg', 'canyouhelpmeithinkibrokealeg', 'ayuda');");

       /* base.execSQL("insert into frases values(7, 0, '¿Qué calle es esta?', 'What street is this?', 'whatstreetisthis', 'street');");
        base.execSQL("insert into frases values(7, 1, '¿En dónde está el museo?', 'Where is the museum?', 'whereisthemuseum', 'museo');");
        base.execSQL("insert into frases values(7, 2, '¿Dónde está la estación de autobuses?', 'Where is the bus station?', 'whereisthebusstation', 'busstation');");
        base.execSQL("insert into frases values(7, 3, '¿Dónde puedo tomar un taxi?', 'Where can i take a cab?', 'wherecanitakeacab', 'taxi');");
        base.execSQL("insert into frases values(7, 4, '¿Cuál es el hotel más cercano?', 'Which one is the nearest hotel?', 'whichoneisthenearesthotel', 'hotel');");

        ContentValues insertar = new ContentValues();
        insertar.put("categoria",0);
        insertar.put("idfrase",0);
        insertar.put("frase","Solicitar información");
        insertar.put("fraseIng","Ask for information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app", null, insertar);

        insertar = new ContentValues();
        insertar.put("categoria",0);
        insertar.put("idfrase",1);
        insertar.put("frase","Saludar");
        insertar.put("fraseIng","Say hellow");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("idfrase",0);
        insertar.put("frase","Pedir horarios");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",1);
        insertar.put("idfrase",0);
        insertar.put("frase","Pedir indicaciones");
        insertar.put("rutaAudio","null");
        base.insert("app",null,insertar);


        insertar = new ContentValues();
        insertar.put("categoria",2);
        insertar.put("idfrase",0);
        insertar.put("frase","Tramitar pasaporte");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",2);
        insertar.put("idfrase",0);
        insertar.put("frase","Saludar");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",3);
        insertar.put("idfrase",0);
        insertar.put("frase","Pedir horarios");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",3);
        insertar.put("idfrase",0);
        insertar.put("frase","Pedir indicaciones");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);

        insertar = new ContentValues();
        insertar.put("categoria",4);
        insertar.put("idfrase",0);
        insertar.put("frase","Tramitar pasaporte");
        insertar.put("fraseIng","Request information");
        insertar.put("rutaAudio","detrasdetiimbecil");
        insertar.put("imagen","adroid");
        base.insert("app",null,insertar);*/
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

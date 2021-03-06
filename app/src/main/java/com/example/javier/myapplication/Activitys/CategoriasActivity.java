package com.example.javier.myapplication.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import com.example.javier.myapplication.AdminSQLiteOpenHelper;
import com.example.javier.myapplication.R;


public class CategoriasActivity extends ActionBarActivity {

    Bundle bundle;

    int idRecibido;
    ListView lista;
    ArrayAdapter <String> adaptador;
    String[] array;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        bundle = getIntent().getExtras();
        idRecibido = bundle.getInt("id");
        consultar();

        lista = (ListView) findViewById(R.id.idRecibido);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),SiguienteActivity.class);
                i.putExtra("idEnviado",position);
                i.putExtra("idcategoria",idRecibido);
                startActivity(i);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categorias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void consultar()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "base", 3, null);
        SQLiteDatabase base = admin.getWritableDatabase();
        String query = "SELECT frase FROM frases WHERE id = "+ idRecibido;
        cursor = base.rawQuery(query,null);
        array = new String[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext())
        {
            array[i] = cursor.getString(0);
            i++;
        }
    }
}

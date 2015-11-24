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


public class FrasesActivity extends ActionBarActivity {

    String categorias[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        consultar();
        ListView lista = (ListView) findViewById(R.id.frasesIniciales);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categorias);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),CategoriasActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frases, menu);
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
        Cursor cursor = base.rawQuery("SELECT frase FROM categorias",null);
        categorias = new String[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext())
        {
            categorias[i] = cursor.getString(0);
            i++;
        }
    }

}

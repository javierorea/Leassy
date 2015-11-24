package com.example.javier.myapplication.Activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.myapplication.AdminSQLiteOpenHelper;
import com.example.javier.myapplication.Fragments.DetallesFragment;
import com.example.javier.myapplication.R;


public class SiguienteActivity extends ActionBarActivity implements DetallesFragment.OnFragmentInteractionListener{



    Bundle bundle;
    Cursor cursor;
    int id, id1;
    MediaPlayer mp;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguiente);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        DetallesFragment fragmento = new DetallesFragment();
        trans.replace(R.id.fragment, fragmento);
        trans.commit();

        /*bundle = getIntent().getExtras();
        id = bundle.getInt("idEnviado");
        id1 = bundle.getInt("idcategoria");
        consultar();
        cursor.moveToFirst();

        TextView text =(TextView)findViewById(R.id.frase);
        text.setText(cursor.getString(0));

        TextView text1 = (TextView)findViewById(R.id.fraseingles);
        text1.setText(cursor.getString(1));

        image = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(getResources().getIdentifier(cursor.getString(3),"drawable",getPackageName()));
        mp = MediaPlayer.create(this,getResources().getIdentifier(cursor.getString(2),"raw",getPackageName()));

    }

    public void hear(View v)
    {

        mp.start();
    }*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_siguiente, menu);
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

    public void onFragmentInteraction(Uri uri)
    {

    }

    /*public void consultar()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "base", 3, null);
        SQLiteDatabase base = admin.getWritableDatabase();
        String query = "SELECT frase, fraseing, audio, imagen FROM frases WHERE id = "+ id1 + " and idfrase = " +id;
        Log.d("Query",query);
        cursor = base.rawQuery(query,null);
    }*/
}

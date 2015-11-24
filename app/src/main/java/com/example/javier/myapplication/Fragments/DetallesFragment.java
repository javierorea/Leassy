package com.example.javier.myapplication.Fragments;

import android.app.Activity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;
import com.example.javier.myapplication.AdminSQLiteOpenHelper;
import com.example.javier.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetallesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetallesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallesFragment extends Fragment {

    Bundle bundle;
    Cursor cursor;
    int id, id1;
    MediaPlayer mp;
    ImageView image;
    ImageButton rep;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallesFragment newInstance(String param1, String param2) {
        DetallesFragment fragment = new DetallesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public DetallesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_detalles, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onStart()
    {
        super.onStart();
        rep = (ImageButton)getView().findViewById(R.id.imageButton);
        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        bundle = getActivity().getIntent().getExtras();
        id = bundle.getInt("idEnviado");
        id1 = bundle.getInt("idcategoria");
        consultar();
        cursor.moveToFirst();
        mp = MediaPlayer.create(getActivity().getApplicationContext(),getResources().getIdentifier(cursor.getString(2),"raw",getActivity().getPackageName()));

        TextView text =(TextView)getActivity().findViewById(R.id.frase);
        text.setText(cursor.getString(0));

        TextView text1 = (TextView)getView().findViewById(R.id.fraseingles);
        text1.setText(cursor.getString(1));

        image = (ImageView)getView().findViewById(R.id.imageView);
        image.setImageResource(getResources().getIdentifier(cursor.getString(3),"drawable",getActivity().getPackageName()));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void consultar()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(), "base", 3, null);
        SQLiteDatabase base = admin.getWritableDatabase();
        String query = "SELECT frase, fraseing, audio, imagen FROM frases WHERE id = "+ id1 + " and idfrase = " +id;
        Log.d("Query",query);
        cursor = base.rawQuery(query,null);
    }

}

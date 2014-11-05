package com.example.listviewmusica;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewmusica.Cancion;
import java.util.ArrayList;

public class MainActivity extends Activity {

    Cancion cancion; 
    MediaPlayer Reproductor; 
    Button play, pausa, stop;
    ListView Canciones; 
    ArrayList<Cancion> listado = new ArrayList<Cancion>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reproductor = new MediaPlayer(); 
        Canciones = (ListView)findViewById(R.id.lvCanciones); 
        listado.add(new Cancion("Coca Cola", R.raw.cocacola)); 
        listado.add(new Cancion("Good Night", R.raw.goodnight)); 
        listado.add(new Cancion("Hidden Lips", R.raw.hiddenlips)); 

        ArrayAdapter<Cancion> l = new ArrayAdapter<Cancion>(getApplicationContext(),android.R.layout.simple_list_item_1, listado);
        Canciones.setAdapter(l);
        play = (Button)findViewById(R.id.btPlay);
        pausa = (Button)findViewById(R.id.btPause);
        stop = (Button)findViewById(R.id.btStop);


        Canciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               
                        cancion = listado.get(i); 
                        Reproductor = MediaPlayer.create(getApplicationContext(), cancion.getId());
                        Toast.makeText(getApplicationContext(),"Reproduciendo - " + cancion.getTitulo(),Toast.LENGTH_LONG).show();
                        if(Reproductor.isPlaying())
                        {
                        	
                        }
                        else
                        	Reproductor.start();
                       

                
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Reproductor.start();
            }
        });
        pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Reproductor.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Reproductor.stop();
            }
        });

    }



    
}

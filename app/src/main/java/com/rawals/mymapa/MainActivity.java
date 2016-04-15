package com.rawals.mymapa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_bici;
    Button b_andar;
    Button b_correr;
    Button b_historial;
    String tipo = "";
    private GestorBD gestorbd = null;
    List<carrera> carreras = new ArrayList<carrera>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestorbd = new GestorBD(this);
        gestorbd.abrirBD();
        carreras = gestorbd.leerCarreras();
        gestorbd.cerrarBD();

        b_bici = (Button) findViewById(R.id.b_bici);
        b_andar = (Button) findViewById(R.id.b_andar);
        b_correr = (Button) findViewById(R.id.b_correr);
        b_historial = (Button) findViewById(R.id.b_historial);

        b_bici.setOnClickListener(this);
        b_correr.setOnClickListener(this);
        b_andar.setOnClickListener(this);
        b_historial.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //Menu de los 3 puntitos
        getMenuInflater().inflate(R.menu.main, menu);

        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Menu de las opciones de los 3 puntitos
        if (item.getItemId() == R.id.legal) {
            startActivity(new Intent(this, LegalNoticesActivity.class));

            return(true);
        }

        return(super.onOptionsItemSelected(item));
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.b_bici:
                tipo = "Bici";
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("tipo",tipo);
                startActivity(intent);

                break;
            case R.id.b_andar:
                tipo = "Andar";
                intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("tipo",tipo);
                startActivity(intent);

                break;
            case R.id.b_correr:
                tipo = "Correr";
                intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("tipo",tipo);
                startActivity(intent);
                break;
            case R.id.b_historial:
                intent = new Intent(MainActivity.this,CarreraList.class);
                startActivity(intent);
                break;

            default:
                break;

        }
    }
}
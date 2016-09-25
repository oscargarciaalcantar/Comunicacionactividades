package com.utl.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Condiciones extends ActionBarActivity {
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);

        //Recibimos los extras
        tvMensaje = (TextView)findViewById(R.id.tvMensaje);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        tvMensaje.setText("Hola " + nombre + " ¿Aceptas las condiciones?");
    }

    public void aceptarCondiciones(View view)
    {
        Intent intent = new Intent();
        /***Forma 1: Definimos un put extra con el dato a regresar***/
        intent.putExtra("resultado", "Aceptado");
        /***Forma 2: Utilizando el método setData del intent para pasarle una cadena***/
        //intent.setData(Uri.parse("Aceptado"));

        setResult(RESULT_OK,intent);
        //Llamamos al método finish para terminar y cerrar la actividad.
        finish();
    }

    public void rechazarCondiciones(View view)
    {
        Intent intent = new Intent();
        /***Forma 1: Definimos un put extra con el dato a regresar***/
        intent.putExtra("resultado", "Rechazado");
        /***Forma 2: Utilizando el método setData del intent para pasarle una cadena***/
        //intent.setData(Uri.parse("Rechazado"));

        setResult(RESULT_OK,intent);
        //Llamamos al método finish para terminar y cerrar la actividad.
        finish();
    }
}


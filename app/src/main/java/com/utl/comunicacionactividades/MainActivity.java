package com.utl.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private EditText txtNombre;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        tvResultado = (TextView)findViewById(R.id.tvResultado);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d("Comunicacion","Entre a on Result");
        if(requestCode==111 && resultCode==RESULT_OK)
        {
            /***Forma 1 Recuperamos dato del extra***/
            String res = data.getExtras().getString("resultado");
            tvResultado.setText("Resultado: " + res);
            /***Forma 2 Recuperamos el dato mediante el método getDataString***/
            //tvResultado.setText("Resultado: " + data.getDataString());
        }
    }

    public void cargaActivityConfirmacion(View view)
    {
        Intent intent = new Intent(this,Condiciones.class);
        intent.putExtra("nombre", txtNombre.getText().toString());
        startActivityForResult(intent, 111);
    }
}


package com.nadershamma.apps.examen_espejo_garcia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2ESGA extends AppCompatActivity {

    private EditText et_numero;
    private Button btn_siguiente;
    private Button btn_cerrar;
    private ListView listViewDatos;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_esga);

        et_numero = findViewById(R.id.editTextNumero);
        btn_siguiente = findViewById(R.id.buttonIngresar);
        btn_cerrar = findViewById(R.id.buttonCerrar);
        listViewDatos = findViewById(R.id.listViewDatos);
        datos = new ArrayList<>();
    }


    public void onClickCargar(View view){
    datos.add(et_numero.getText().toString());
        Toast.makeText(getApplicationContext(), "Dato regresado" + et_numero.getText().toString(),Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter =  //actualizar la lista
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_expandable_list_item_1, datos);
        //asociar el adapter con el control (vista) que va mostrar los datos
        listViewDatos.setAdapter(adapter);
    }

    public void onClickCerrar(View view){
        ArrayList<String> datoSelected = (ArrayList<String>) listViewDatos.getAdapter();

//                Toast.makeText(getApplicationContext(),
//                        "Item seleccionado" + itemSelected,
//                        Toast.LENGTH_LONG).show();
    String dato=datoSelected.get(0);
    int i = 1;
    while (i<datoSelected.size()){
        dato = dato + "_" +datoSelected.get(i);
        i++;
    }
        Intent intent = new Intent();
        intent.setData(Uri.parse(dato));
        setResult(Activity.RESULT_OK, intent);
        finish();
    }




}
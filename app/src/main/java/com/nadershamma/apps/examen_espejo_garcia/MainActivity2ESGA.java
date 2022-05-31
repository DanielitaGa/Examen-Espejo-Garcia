package com.nadershamma.apps.examen_espejo_garcia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    private ArrayList<String> names;
    Boolean a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_esga);

        et_numero = findViewById(R.id.editTextNumero);
        btn_siguiente = findViewById(R.id.buttonIngresar);
        btn_cerrar = findViewById(R.id.buttonCerrar);
        listViewDatos = findViewById(R.id.listViewDatos);
    }


    public void onClickCargar(View view){
    names = new ArrayList<String>();
    a = names.add(et_numero.getText().toString());
        Toast.makeText(getApplicationContext(), "Dato regresado" + a,Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter =  //actualizar la lista
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_expandable_list_item_1, names);
        //asociar el adapter con el control (vista) que va mostrar los datos
        listViewDatos.setAdapter(adapter);
    }
}
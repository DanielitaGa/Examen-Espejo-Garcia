package com.nadershamma.apps.examen_espejo_garcia;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity1ESGA extends AppCompatActivity {

    ArrayList<Integer> original;

    ActivityResultLauncher<Intent> resultado;

    ListView lv_ordenar, lv_indices, lv_original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_esga);
        original = new ArrayList<>();

        lv_ordenar = findViewById(R.id.lv_ordenar);
        lv_indices = findViewById(R.id.lv_indices);
        lv_original = findViewById(R.id.lv_original);

        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent datos = result.getData();
                            String[] itemsOriginal = datos.getDataString().split("_");
                            original =  new ArrayList<>();

                            int i=0;
                            while(i<itemsOriginal.length){
                                original.add(Integer.valueOf(itemsOriginal[i]));
                                i++;
                            }
                        }
                    }



                });
    }

    public void onClicSegundo(View view){
        Intent intent = new Intent(this, MainActivity2ESGA.class);

        resultado.launch(intent);
    }

    public void onClicMostrar(View view){
        ArrayAdapter<Integer> adapterOriginal = new ArrayAdapter<>(getApplicationContext(),
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                original);

        ArrayAdapter<Integer> adapterIndices = new ArrayAdapter<>(getApplicationContext(),
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                ordenarIndices(original));

        lv_original.setAdapter(adapterOriginal);

        lv_indices.setAdapter(adapterIndices);
    }

    public void onClicOrdenar(View view){
        ArrayAdapter<Integer> adapterIndices = new ArrayAdapter<>(getApplicationContext(),
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                generarOrdenado((ArrayList<Integer>) lv_indices.getAdapter()));

        lv_ordenar.setAdapter(adapterIndices);
    }

    private ArrayList<Integer> generarOrdenado(ArrayList<Integer> indices){
        ArrayList<Integer> ordenado = new ArrayList<>();
        for (int item:
             indices) {
            ordenado.add(Integer.valueOf(lv_original.getAdapter().getItem(item).toString()));
        }
        return ordenado;
    }

    private ArrayList<Integer> ordenarIndices(ArrayList<Integer> original){
        ArrayList<Integer> indices = new ArrayList<>(original.size());
        int temp=0;
        int i=0;
        int j=0;

        while(i<original.size()){
            while(j<original.size()){
                if(original.get(i)>original.get(j)){
                    temp = indices.get(j);
                    indices.set(j,indices.get(i));
                    indices.set(i,temp);
                }
                j++;
            }
            i++;
        }

        return indices;
    }


}
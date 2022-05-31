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

import java.util.ArrayList;
import java.util.List;

public class MainActivity1ESGA extends AppCompatActivity {

    ArrayList<Integer> indices, original;

    ActivityResultLauncher<Intent> resultado;

    ListView lv_ordenar, lv_indices, lv_original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_esga);
        indices = new ArrayList<>();
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

                            for (String item:itemsOriginal) {
                                original.add(Integer.valueOf(item));
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

    private ArrayList<Integer> ordenarIndices(ArrayList<Integer> original){
        ArrayList<Integer> indices = new ArrayList<>();
        int temp=0;
        for (int item:
                original) {
            indices.add(temp);
            temp++;
        }
        for (int i=0;i<original.size();i++){
            for(int j=i;j<original.size();j++){
                if(original.get(i)>original.get(j)){
                    temp = indices.get(j);
                    indices.set(j,indices.get(i));
                    indices.set(i,temp);
                }
            }
        }
        return indices;
    }
}
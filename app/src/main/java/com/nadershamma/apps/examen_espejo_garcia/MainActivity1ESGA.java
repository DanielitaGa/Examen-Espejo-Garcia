package com.nadershamma.apps.examen_espejo_garcia;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity1ESGA extends AppCompatActivity {

    ArrayList<Integer> indices;

    ActivityResultLauncher<Intent> resultado;

    ListView lv_ordenar, lv_indices, lv_original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_esga);
        indices = new ArrayList<>();

        lv_ordenar = findViewById(R.id.lv_ordenar);
        lv_indices = findViewById(R.id.lv_indices);
        lv_original = findViewById(R.id.lv_original);

        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent datos = result.getData();

                        }
                    }
                });
    }
}
package com.nadershamma.apps.examen_espejo_garcia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity1ESGA extends AppCompatActivity {

    ArrayList<Integer> indices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_esga);
        indices = new ArrayList<>();
    }
}
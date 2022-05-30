package com.nadershamma.apps.examen_espejo_garcia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity2ESGA extends AppCompatActivity {

    private Button btn_Siguiente;
    private Button btn_Cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_esga);

        btn_Siguiente = findViewById(R.id.buttonIngresar);
        btn_Cerrar = findViewById(R.id.buttonCerrar);
    }
}
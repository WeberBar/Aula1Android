package com.example.helloworld;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        CheckBox checkBox;

        List<CheckBox> checkBoxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CicloDeVida", "onCreate() chamado");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getApplicationContext(), "Opção selecionada!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Opção desmarcada!", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout checkBoxContainer = findViewById(R.id.checkBoxContainer);
        Button btnCheck = findViewById(R.id.btnCheck);
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5"};
        for (String opcao : opcoes)
        {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(opcao);
            checkBoxContainer.addView(checkBox);
            checkBoxList.add(checkBox);
        }
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder selecionados = new StringBuilder("Selecionado: ");
                for (CheckBox checkBox : checkBoxList) {
                    if (checkBox.isChecked()) {
                        selecionados.append(checkBox.getText()).append(", ");
                    }
                }
                if (selecionados.toString().equals("Selecionado: ")) {
                    selecionados = new StringBuilder("Nenhuma opção selecionada!");
                } else {
                    selecionados.setLength(selecionados.length() - 2);
                }
                Toast.makeText(getApplicationContext(), selecionados.toString(), Toast.LENGTH_SHORT).show();
            }
        });





    }
    public void pularTela(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class );
        startActivity(intent);
        finish();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("CicloDeVida", "onStart() chamado"); }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("CicloDeVida", "onRestart() chamado"); }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CicloDeVida", "onResume() chamado"); }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CicloDeVida", "onPause() chamado"); }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("CicloDeVida", "onStop() chamado"); }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("CicloDeVida","onDestroy() chamado");}
}
package com.example.helloworld;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void checkRadios(View view) {
        radioGroup = findViewById(R.id.radioGroup);

        int selectId = radioGroup.getCheckedRadioButtonId();

        if (selectId == -1) {
            Toast.makeText(MainActivity2.this, "Selecione uma opção", Toast.LENGTH_LONG).show();
        } else {
            RadioButton selecRadioButton = findViewById(selectId);
            String selectText = selecRadioButton.getText().toString();

            Toast.makeText(MainActivity2.this, selectText, LENGTH_LONG).show();
        }
    }
    public void voltarTela(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class );
        startActivity(intent);
        finish();
    }
}
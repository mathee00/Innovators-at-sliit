package com.supun.mysccustom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText name_input, description_input, skill_input, rating_input;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        description_input = findViewById(R.id.description_input);
        skill_input = findViewById(R.id.skill_input);
        rating_input = findViewById(R.id.rating_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addWorker(name_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        skill_input.getText().toString().trim(),
                        rating_input.getText().toString().trim());

            }
        });
    }
}
package com.supun.mysccustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title,description, skill_txt_view, rating_txt_view;
    Button edit_button, delete_button;

    String data1,data2;
    String skill_view_data,rating_view_data;
    int myImage;

    private ArrayList worker_id, worker_name, worker_description, worker_skill, worker_rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title1);
        description = findViewById(R.id.description2);
        skill_txt_view = findViewById(R.id.skill_txt_view);
        rating_txt_view = findViewById(R.id.rating_txt_view);

        getData();
        setData();
        edit_button = findViewById(R.id.edit_button);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getData() {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
        getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            skill_view_data = getIntent().getStringExtra("skill_view_data");
            rating_view_data= getIntent().getStringExtra("rating_view_data");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else {
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        skill_txt_view.setText(skill_view_data);
        rating_txt_view.setText(rating_view_data);
        mainImageView.setImageResource(myImage);
    }
}
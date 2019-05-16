package com.myapplicationdev.android.psp05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText title, singer,year;
    RadioGroup rg;
    Button btnInsert, btnShow;

    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTexttitle);
        singer = findViewById(R.id.editTextsinger);
        year = findViewById(R.id.editTextyear);
        rg= findViewById(R.id.rg);
        btnInsert = findViewById(R.id.buttoninsert);
        btnShow = findViewById(R.id.buttonshowlist);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titles = title.getText().toString();
                String singers = singer.getText().toString();
                year.getText().toString();
                int years  = Integer.parseInt(year.getText().toString());
                int selectedBtnID = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedBtnID);
                rb.getText().toString();
                int stars = Integer.parseInt(rb.getText().toString());


                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSong(titles,singers,years,stars);

                dbh.close();

                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

         btnShow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, ShowActivity.class);

                 String data = al.get(0);
                 String title = data.split(",")[0].trim();
                 String singer = data.split(",")[1].trim();
                 String year = data.split(",")[2].trim();
                 String star = data.split(",")[3].trim();

                 Song target = new Song(title,singer,Integer.parseInt(year),Integer.parseInt(star));
                 //i.putExtra("",target);
                 startActivityForResult(i,9);

             }
         });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            btnShow.performClick();
        }
    }
}



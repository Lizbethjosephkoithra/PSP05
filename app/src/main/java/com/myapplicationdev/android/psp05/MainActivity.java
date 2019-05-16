package com.myapplicationdev.android.psp05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title, singer,year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTexttitle);
        singer = findViewById(R.id.editTextsinger);
        year = findViewById(R.id.editTextyear);
    }
}

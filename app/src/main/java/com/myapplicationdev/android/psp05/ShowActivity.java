package com.myapplicationdev.android.psp05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    ArrayList<String> al;
    ListView lv;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lv= findViewById(R.id.lvsong);
        al = new ArrayList<String>();

        aa = new ArrayAdapter<String>(ShowActivity.this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        DBHelper dbh = new DBHelper(ShowActivity.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        dbh.close();

        String txt = "";
        for (int i = 0; i < al.size(); i++) {
            String tmp = al.get(i);
            txt += tmp + "\n";
        }
        al.add(txt);
        aa.notifyDataSetChanged();
    }
}

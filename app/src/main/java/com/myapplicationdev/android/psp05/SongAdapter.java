package com.myapplicationdev.android.psp05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private ArrayList<Song> song;
    private Context context;
    private TextView tvYear;
    private TextView tvSinger;
    private TextView tvTitle;

    public SongAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        song = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvYear = rowView.findViewById(R.id.textViewyearlist);
        tvSinger = rowView.findViewById(R.id.textViewsingerlist);
        tvTitle = rowView.findViewById(R.id.textViewtitlelist);

        Song currenTask = song.get(position);

        tvYear.setText(Integer.toString(currenTask.getYear()));
        tvSinger.setText(currenTask.getSingers());
        tvTitle.setText(currenTask.getTitle());

        return rowView;
    }
}

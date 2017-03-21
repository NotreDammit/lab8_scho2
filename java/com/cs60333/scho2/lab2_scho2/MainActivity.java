package com.cs60333.scho2.lab2_scho2;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Team> teams = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ArrayList<String[]> temp;
        MyCsvFileReader csvFile = new MyCsvFileReader(getApplicationContext());
        temp = csvFile.readCsvFile(R.raw.schedule);

        for (int i=0; i<temp.size(); i++) {
            String[] ex = temp.get(i);
            Team team = new Team(ex);
            teams.add(team);
        }

        ScheduleAdapter adapter = new ScheduleAdapter(getApplicationContext(), teams);//schedule, dates, puppers);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);

        scheduleListView.setAdapter(adapter);
        scheduleListView.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("teams", teams.get(position));
                startActivity(detailIntent);

                //String SelectedItem = schedule[position];
                //Toast.makeText(MainActivity.this, SelectedItem, Toast.LENGTH_SHORT).show();
            }
        });


    }
}

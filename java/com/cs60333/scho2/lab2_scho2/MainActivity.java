package com.cs60333.scho2.lab2_scho2;

import android.content.Intent;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.support.design.*;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleCursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    int num = 0;
    ArrayList<Team> teams;
    StringBuilder dbSchedule;
    StringBuilder gameSchedule;
    ListView scheduleListView;
    private CoordinatorLayout coordinatorLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("ND Athletics");

        teams = new ArrayList<>();
        ArrayList<String[]> temp;
        MyCsvFileReader csvFile = new MyCsvFileReader(getApplicationContext());
        temp = csvFile.readCsvFile(R.raw.schedule);
        gameSchedule = new StringBuilder();
        dbSchedule = new StringBuilder();

        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 2);
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < temp.size(); i++) {
            String[] ex = temp.get(i);
            Team team = new Team(ex);
            teams.add(team);

            gameSchedule.append(ex[0] + ", ");
            gameSchedule.append(ex[6] + ", ");
            gameSchedule.append(ex[8]);
            gameSchedule.append("\n");

            int j = i+1;
            Log.d("HELPME", ex[0]);
            dbHelper.insertData("Team", j, ex);
            //Log.d("help1", ex[0]);
            //Log.d("help2", ex[6]);
            //Log.d("help3", ex[8]);
        }

        ScheduleAdapter adapter = new ScheduleAdapter(getApplicationContext(), teams);//schedule, dates, puppers);
        scheduleListView = (ListView) findViewById(R.id.scheduleListView);

        scheduleListView.setAdapter(adapter);
        scheduleListView.setOnItemClickListener(new OnItemClickListener() {
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

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
            // Code for sharing the schedule
            Intent shareIntent = new Intent();
            shareIntent.setAction(android.content.Intent.ACTION_SEND);
            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "BasketBall Matches");
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, gameSchedule.toString());
            shareIntent.setType("text/plain");
            //startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.app_name)));
            startActivity(shareIntent);
        }

        else if (res_id == R.id.sync) {
            // Snackbar with Try Again action
            coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);
            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();
                }
            });
            snackbar.show();
            // Toast.makeText(MainActivity.this, "Sync is not yet implemented", Toast.LENGTH_SHORT).show();
        }

        else if (res_id == R.id.settings) {
            // Floating Contextual Menu with options
            //ListView context1 = (ListView)findViewById(R.id.contextMenu);
            //registerForContextMenu(context1);
            registerForContextMenu(scheduleListView);
            openContextMenu(scheduleListView);
            unregisterForContextMenu(scheduleListView);

        }
        return true;
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Settings");
        MenuInflater contextMenuInflater = getMenuInflater();
        contextMenuInflater.inflate(R.menu.floating_contextual_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.womens) {
            // to be implemented later
        }

        else if (item_id == R.id.mens) {
            // Snackbar with Try Again action
        }

        else if (item_id == R.id.onCampus) {
            // Floating Contextual Menu with options
        }

        else if (item_id == R.id.offCampus) {
            // Floating Contextual Menu with options
        }
        return true;
    }
}

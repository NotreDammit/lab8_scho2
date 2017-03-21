package com.cs60333.scho2.lab2_scho2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * Created by samcholo on 2/11/17.
 */

public class ScheduleAdapter extends ArrayAdapter<Team> {
    private Context context;

    public ScheduleAdapter(Context context, ArrayList<Team> teams) { //String[] teams, String[] dates, Integer[] puppers) {
        super(context, R.layout.schedule_item, teams);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        TextView teamName = (TextView) scheduleView.findViewById(R.id.nameOfSchool);
        ImageView pupperView = (ImageView) scheduleView.findViewById(R.id.imageOfPuppers);
        TextView gameDate = (TextView) scheduleView.findViewById(R.id.date);

        Team matchTeam = getItem(position);
        teamName.setText(matchTeam.getTeamName());
        gameDate.setText(matchTeam.getDate());

        int resID = context.getResources().getIdentifier(matchTeam.getTeamLogo(), "drawable", context.getPackageName());
        pupperView.setImageResource(resID);

        return scheduleView;
    }
}

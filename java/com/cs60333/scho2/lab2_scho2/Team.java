package com.cs60333.scho2.lab2_scho2;

import java.io.Serializable;

/**
 * Created by samcholo on 3/1/17.
 */

public class Team implements Serializable {
    private String teamName;
    private String teamLogo;
    private String teamMascot;
    private String teamRecord;
    private String ndRecord;
    private String score;
    private String longDate;
    private String date;

    public Team (String[] teams) {
        setTeamName(teams[0]);
        setTeamLogo(teams[1]);
        setTeamMascot(teams[2]);
        setTeamRecord(teams[3]);
        setNdRecord(teams[4]);
        setScore(teams[5]);
        setLongDate(teams[6]);
        setDate(teams[7]);
    }

    public void setTeamName(String teamNames) {this.teamName = teamNames;}

    public String getTeamName() {return this.teamName;}

    public void setTeamLogo(String teamLogos) {this.teamLogo = teamLogos;}

    public String getTeamLogo() { return this.teamLogo; }

    public void setTeamMascot(String teamMascots) {this.teamMascot = teamMascots;}

    public String getTeamMascot() {
        return this.teamMascot;
    }

    public void setTeamRecord(String teamRecords) {
        this.teamRecord = teamRecords;
    }

    public String getTeamRecord() {
        return this.teamRecord;
    }

    public void setNdRecord(String ndRecords) {
        this.ndRecord = ndRecords;
    }

    public String getNdRecord() {
        return this.ndRecord;
    }

    public void setScore(String scores) {
        this.score = scores;
    }

    public String getScore() {
        return this.score;
    }

    public void setLongDate(String longDates) {
        this.longDate = longDates;
    }

    public String getLongDate() {
        return this.longDate;
    }

    public void setDate(String dates) {
        this.date = dates;
    }

    public String getDate() {
        return this.date;
    }
}

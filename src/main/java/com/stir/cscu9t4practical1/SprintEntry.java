package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry{

    int NumberofLaps;
    int recovery;

     SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,int NumberofLaps, int recovery) {
        super(n, d, m, y, h, min, s, dist);
        this.NumberofLaps = NumberofLaps;
        this.recovery = recovery;

    }


    public int getRepetitions(){
         return NumberofLaps;
     }

     public int getRecovery(){
         return recovery;
     }

    public String getEntry () {
        String result = getName()+" sprinted " + getRepetitions() + "x" + (int) getDistance() +  "m in "
                +getHour()+":"+getMin()+":"+ getSec() + " with " + getRecovery()+ " minutes recovery on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }





}

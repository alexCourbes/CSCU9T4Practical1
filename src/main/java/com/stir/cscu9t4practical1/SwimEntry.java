package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {
    String Location;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist,String Location) {
        super(n, d, m, y, h, min, s, dist);
        this.Location=Location;
    }

    public String getWhere(){
        return Location;
    }


    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " in an:  " + getWhere() + " on the: "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }
}

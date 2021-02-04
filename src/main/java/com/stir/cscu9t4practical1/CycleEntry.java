package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry  {

    private String terrain;
    private String tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    public String getTerrain(){
        return terrain;
    }

    public String getTempo(){
        return tempo;
    }

     public String getEntry () {
        String result = getName()+" cycled " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " in a terrain of:  " + getTerrain() + " with a tempo of: " + getTempo() + " on the:  "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }
}

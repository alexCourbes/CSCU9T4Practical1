// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    } // addClass


    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                result = current.getEntry();
        }
        return result;
    } // lookupEntry


    public String FindAllByDate(int d, int m, int y) {

        ListIterator<Entry> iter = tr.listIterator();

        StringBuilder SB = new StringBuilder();
        String result = "";

        int i = 0;
        for (Entry entry : tr) {
            if (iter.hasNext()) {
                Entry current = iter.next();
                if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                    result = current.getEntry();
                    SB.append(result);
                } else {
                    i++;
                }

            }
        }
        if (i == tr.size()) {
            return "no entries found";
        } else {

            return SB.toString();
        }


    }

    public String removeEntry(String n, int d, int m, int y) {
        tr.removeIf(e -> e.getName().equals(n) && e.getDay() == d && e.getMonth() == m && e.getYear() == y);
        return n +  "has been removed from the record";
    }


    public String FindAllByName(String Name) {

        StringBuilder SB = new StringBuilder();

        List<Entry> result = tr.stream().filter(item -> item.getName().equals(Name)).collect(Collectors.toList());

        for (Entry entry : result) {
            SB.append(result.listIterator(result.indexOf(entry)).next().getEntry());
        }

        //does the same as the code below
//        for (int i =0; i<result.size(); i++) {
//           String FinalResult = result.get(i).getEntry();
//            SB.append(FinalResult);
//        }


        return SB.toString();
    }
} // TrainingRecord
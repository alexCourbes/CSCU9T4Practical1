// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

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


    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

} // TrainingRecord
// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import org.w3c.dom.events.Event;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    String choice[] = {"Sprint", "Cycle", "Swim"};
    private JComboBox<String> dropDown = new JComboBox<String>(choice);


    //for the three options:

    //Sprint
    private JTextField NumberofLaps = new JTextField(4);
    private JLabel NumberofLapsLabel = new JLabel(" Number of Laps:");


    private JTextField recovery = new JTextField(4);
    private JLabel recoveryLabel = new JLabel(" Recovery:");


    //Cycle

    private JTextField getTerrain = new JTextField(4);
    private JLabel getTerrainLabel = new JLabel(" Terrain:");
    private JTextField getTempo = new JTextField(4);
    private JLabel getTempoLabel = new JLabel(" Tempo:");


    //Swim
    private JTextField Location = new JTextField(4);
    private JLabel LocationLabel = new JLabel("Location: ");


    //Button to find by Name;

    private JButton FindByNameButton = new JButton("Find by name");

    //Delete Button
    private JButton removeEntry = new JButton("remove entry(n,d,m,y)");

    //Rest of fields and labels
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find all By Date");


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main


    // set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());


        add(dropDown);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);


        //DropDown: functionality
        add(NumberofLapsLabel);
        add(NumberofLaps);
        add(recoveryLabel);
        add(recovery);

        add(getTerrainLabel);
        add(getTerrain);
        add(getTempoLabel);
        add(getTempo);

        add(LocationLabel);
        add(Location);


        getTerrainLabel.setVisible(false);
        getTerrain.setVisible(false);
        getTempoLabel.setVisible(false);
        getTempo.setVisible(false);
        Location.setVisible(false);
        LocationLabel.setVisible(false);

        NumberofLapsLabel.setVisible(true);
        NumberofLaps.setVisible(true);
        recoveryLabel.setVisible(true);
        recovery.setVisible(true);

        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Option = (String) dropDown.getSelectedItem();

                switch (Option) {

                    case "Sprint":



                        getTerrainLabel.setVisible(false);
                        getTerrain.setVisible(false);
                        getTempoLabel.setVisible(false);
                        getTempo.setVisible(false);
                        Location.setVisible(false);
                        LocationLabel.setVisible(false);

                        NumberofLapsLabel.setVisible(true);
                        NumberofLaps.setVisible(true);
                        recoveryLabel.setVisible(true);
                        recovery.setVisible(true);
                        revalidate();
                        break;


                    case "Cycle":


                        NumberofLaps.setVisible(false);
                        NumberofLapsLabel.setVisible(false);
                        recovery.setVisible(false);
                        recoveryLabel.setVisible(false);
                        LocationLabel.setVisible(false);
                        Location.setVisible(false);


                        getTerrainLabel.setVisible(true);
                        getTerrain.setVisible(true);
                        getTempoLabel.setVisible(true);
                        getTempo.setVisible(true);
                        revalidate();
                        break;

                    case "Swim":


                        NumberofLapsLabel.setVisible(false);
                        NumberofLaps.setVisible(false);
                        recoveryLabel.setVisible(false);
                        recovery.setVisible(false);
                        getTerrain.setVisible(false);
                        getTerrainLabel.setVisible(false);
                        getTempoLabel.setVisible(false);
                        getTempo.setVisible(false);



                        Location.setVisible(true);
                        LocationLabel.setVisible(true);
                        revalidate();
                        break;


                }

            }
        });

        add(outputArea);
        outputArea.setEditable(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        add(FindByNameButton);
        FindByNameButton.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);



        setSize(1330, 300);
        setVisible(true);
        setResizable(false);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    }
    public String removeEntry(){
        String n = name.getText();
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());

        outputArea.setText("removing Entry...");
        String message= myAthletes.removeEntry(n,d,m,y);
        return message;
    }


    public String FindAllByName() {
        String n = name.getText();
        outputArea.setText("looking up record ...");

        String message = myAthletes.FindAllByName(n);

        return message;
    }


    // listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {


        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = findAllByDate();
        }

        if(event.getSource()==FindByNameButton){
            message = FindAllByName();
        }
        if (event.getSource()==removeEntry){
            message= removeEntry();
        }


        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed


    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        String n = name.getText();
        if (name.getText().isEmpty()) {
            return message = "inpute a valid name";
        }


        int m, d, y;
        try {
            m = Integer.parseInt(month.getText());
            d = Integer.parseInt(day.getText());
            y = Integer.parseInt(year.getText());

        } catch (Exception NumberFormatException) {
            return message = "input a valid date ";
        }


        float km;
        int h, mm, s;

        try {
            km = java.lang.Float.parseFloat(dist.getText());
            h = Integer.parseInt(hours.getText());
            mm = Integer.parseInt(mins.getText());
            s = Integer.parseInt(secs.getText());

        } catch (Exception NumberFormatException) {
            return message = "The distance of time inputs are wrong!";
        }


        switch (dropDown.getSelectedItem().toString()) {
            case "Sprint":
                int recover = Integer.parseInt(recovery.getText());
                int laps = Integer.parseInt(NumberofLaps.getText());
                Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, laps, recover);
                myAthletes.addEntry(e);
                return message;

            case "Swim":
                String locat = Location.getText();
                Entry Se = new SwimEntry(n, d, m, y, h, mm, s, km, locat);
                myAthletes.addEntry(Se);
                return message;
            case "Cycle":
                String tempo = getTempo.getText();
                String terrain = getTerrain.getText();
                Entry Ce = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
                myAthletes.addEntry(Ce);
                return message;
        }


        return message;
    }




    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");

        String message = myAthletes.lookupEntry(d, m, y);

        return message;
    }


    public String findAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");

        String message = myAthletes.FindAllByDate(d, m, y);

        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        NumberofLaps.setText("");
        recovery.setText("");
        Location.setText("");
        getTempo.setText("");
        getTerrain.setText("");

    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI


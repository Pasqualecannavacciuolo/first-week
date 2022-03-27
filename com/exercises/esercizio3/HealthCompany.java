package com.exercises.esercizio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HealthCompany {
    private ArrayList<Medic> medics = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();

    /**
     * Method added by me to add a medic object to the arraylist of medics
     * @param m - medic object
     */
    public void addMedic(Medic m) {
        medics.add(m);
    }

    /**
     * This method let you add a patient with the respective medic if the name of the medic
     * given in input is in the medics arraylist
     * @param p - patient object
     * @param m - medic name
     */
    public void addPatient(Patient p, String m) {
        for(Medic md: medics) {
            if(m.equals(md.getName())) {
                p.setDoctor(md);
                patients.add(p);
            }
        }
    }

    /**
     * This method create an arraylist of the patients of a given medic
     * @param m - get a medic object as a parameter
     * @return - the arraylist that contains the patients of the medic given as a parameter
     */
    public ArrayList<Patient> getPatientList(Medic m) {
        ArrayList<Patient> tmpPatients = new ArrayList<>();
        for(Patient p: patients) {
            if(p.getDoctor() == m) {
                tmpPatients.add(p);
            }
        }
        return tmpPatients;
    }

    /**
     * This method prints the medic that have the most number of patients
     * in the array list of medics, if we have multiple medics that have the
     * same number of patients that is the most of the arraylist we print them all
     */
    public void medicWithMorePatients() {
        // This array list contains the maximum number of patients per doctor
        ArrayList<Integer> maxPatient = new ArrayList<>(this.medics.size());

        // Remove the duplicates from medics list
        Set<Medic> set = new HashSet<>(medics);
        // This arraylist contains the doctor
        ArrayList<Medic> medicsTmp = new ArrayList<>();
        medicsTmp.addAll(set);

        /**
         * For every medic we calculate the number of patients
         * We have to look the 2 ArrayList - maxPatient & medicsTmp as parallel list
         * the data between them is connected by the same index
         * Example
         * maxPatient = [3,2]
         * medicsTmp = ["Franco","Luigi"]
         * Franco is at maxPatient.INDEX(0) and have medicsTmp.INDEX(0) patients
         * Franco = 3 patients
         * Luigi = 2 patients
         */
        for(int i=0; i<medicsTmp.size(); i++) { // Looping into the medics list
            Medic m = medicsTmp.get(i);
            int counter = 0;
            /**
             * With the medic locked in we count (looping into the patients list)
             * how many patients have him as a doctor
             */
            for(int j=0; j<this.patients.size(); j++) {
                Patient p = this.patients.get(j);
                if(p.getDoctor()==m) { // The patient have the LOCKED in doctor as the doctor
                    counter += 1;
                }
            }
            maxPatient.add(i, counter);
        }

        // Getting the highest number of patients per medic
        int maximum = Collections.max(maxPatient);

        /**
         * Printing the medic with the maximum number of patients,
         * if we have multiple medic with the highest number of patients
         * we print them
         */
        for(int i=0; i<medicsTmp.size(); i++) {
            if(maxPatient.get(i)==maximum) {
                System.out.println("\n" + medicsTmp.get(i).getName() + " - " + maxPatient.get(i));
            }
        }

    }

}


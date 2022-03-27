package com.exercises.esercizio3;

public class Tester {
    public static void main(String[] args) {

        // Creating the objects
        Medic medic = new Medic("Luigi");
        Medic medic2 = new Medic("Franco");
        Patient patient = new Patient(111, medic);
        Patient patient2 = new Patient(112, medic);
        Patient patient3 = new Patient(222, medic2);
        Patient patient4 = new Patient(223, medic2);
        Patient patient5 = new Patient(113, medic);

        /**
         * HEALT COMPANY OPERATIONS
         */
        HealthCompany hC = new HealthCompany();
        // Adding the medics to the ArrayList contained in HealthCompany
        hC.addMedic(medic);
        hC.addMedic(medic2);
        // Adding the patients to the ArrayList contained in HealthCompany
        hC.addPatient(patient, "Luigi");
        hC.addPatient(patient2, "Luigi");
        hC.addPatient(patient3, "Franco");
        hC.addPatient(patient4, "Franco");
        hC.addPatient(patient5, "Luigi");

        /**
         * Printing the list of patient for a given medic
         * In this case we choose MEDIC = "Luigi" that have 3 patients [111, 112, 113]
         */
        System.out.println("\nPrinting the list of patients for the medic named " + medic.getName());
        for(Patient pTmp: hC.getPatientList(medic)) {
            System.out.println(pTmp.getHealthCardNumber());
        }

        // Printing the medic that have the highest number of patients
        System.out.print("\nMedic with the highest number of patients");
        hC.medicWithMorePatients();
    }
}

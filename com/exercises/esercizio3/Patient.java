package com.exercises.esercizio3;

public class Patient {
    private int healthCardNumber;
    private Medic doctor;

    public Patient() {}

    public Patient(int healthCardNumber, Medic doctor) {
        this.healthCardNumber = healthCardNumber;
        this.doctor = doctor;
    }

    // Methods Getter&Setter
    public int getHealthCardNumber() {
        return healthCardNumber;
    }
    public void setHealthCardNumber(int healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    public Medic getDoctor() {
        return doctor;
    }
    public void setDoctor(Medic doctor) {
        this.doctor = doctor;
    }
}

package com.exercises.esercizio2;

import java.util.Date;

public class Square extends ArtWork{
    private double width;
    private double height;
    private int creationDate;

    public Square(String artistName, String artworkName, double width, double height, int creationDate) {
        super(artistName, artworkName);
        this.width = width;
        this.height = height;
        this.creationDate = creationDate;
    }

    public Square(double width, double height, int creationDate) {
        this.width = width;
        this.height = height;
        this.creationDate = creationDate;
    }

    // Methods Getter&Setter
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public int getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * This method returns the calculated Encumbrance
     * @return - prints the Encumbrance of the SQUARE
     */
    @Override
    double printEncumbrance() {
        return width * height;
    }

    /**
     * This method calculates the age of a square
     */
    @Override
    int getAge() {
        Date dt=new Date();
        int year= dt.getYear()+1900;
        //System.out.println(this.getArtworkName() + " ha " + this.toString(year-this.getCreationDate()) + " anni");
        return year-this.getCreationDate();
    }

}

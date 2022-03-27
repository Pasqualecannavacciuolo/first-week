package com.exercises.esercizio2;

import java.util.Objects;

public abstract class ArtWork {
    protected String artistName;
    protected String artworkName;

    // Methods Getter&Setter
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtworkName() {
        return artworkName;
    }
    public void setArtworkName(String artworkName) {
        this.artworkName = artworkName;
    }

    public ArtWork(){}

    public ArtWork(String artistName, String artworkName) {
        this.artistName = artistName;
        this.artworkName = artworkName;
    }

    /**
     *  This method calculate and return the encumbrance of the object
     * @return - the value of the encumbrance of the object
     */
    abstract double printEncumbrance();

    /**
     * This method confronts 2 objects and result true if they are the same
     * @param o - takes an object as a parameter
     * @return - true if the objects have the same type
     */
    public boolean equals(Object o) {
        if(o instanceof ArtWork) {
            if(((ArtWork) o).getArtworkName().equals(this.getArtworkName()) && ((ArtWork) o).getArtistName().equals(this.getArtistName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is a method added by me to calculate how many years an artwork have
     */
    abstract int getAge();

    /**
     * This method return an Integer value as a String
     * @param i - takes the age of an artwork as an Integer and converts it in a String
     * @return - the calculated year as a String
     */
    public String toString(int i) {
        return String.valueOf(i);
    }
}

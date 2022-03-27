package com.exercises.esercizio2;

import java.util.ArrayList;
import java.util.Objects;

public class Collection {
    private String name;
    private String location;
    private ArrayList<ArtWork> artWorks = new ArrayList<>();

    // Methods Getter&Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<ArtWork> getArtWorks() {
        return artWorks;
    }


    // Custom methods
    /**
     * This method simply add an artwork to the arraylist of artworks
     * @param aW - takes an artwork as parameter
     */
    public void addArtWork(ArtWork aW) {
        artWorks.add(aW);
    }

    /**
     * This method print the arraylist of artworks
     */
    public void printArtWork() {
        for(ArtWork a: artWorks) {
            System.out.println(a.artworkName + " - " + a.artistName);
        }
    }

    /**
     * This method print the encumbrance of a given(aW) artwork
     * @param aW - takes an artwork as parameter
     */
    public void printArtWorkEncumbrance(ArtWork aW) {
        for(ArtWork a: artWorks) {
            if (Objects.equals(a.getArtworkName(), aW.getArtworkName())) {
                System.out.println("\nL'opera " + aW.getArtworkName() + " è presente" +
                        " nell'ArrayList il suo ingombro: " + aW.printEncumbrance());
            }
        }
    }

}

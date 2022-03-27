package com.exercises.esercizio2;

import java.util.Objects;
import java.util.Scanner;

public class Tester {
    public static Scanner input = new Scanner(System.in);

    // This method added by me check if an artwork given as INPUT is present in the collection
    public static ArtWork presentInList(Collection c, String artWorkName) {
        ArtWork a1 = null;
        int flag = 0;

        // Search if the first artwork is in the arraylist
        for (ArtWork a : c.getArtWorks()) {
            if (Objects.equals(a.getArtworkName(), artWorkName)) {
                a1 = a;
            }
        }

        // If the ArtWork is present then put this PRINT FLAG = 1
        if (a1 != null) {
            flag = 1;
        }
        if(flag == 1) {
            return a1;
        }
        return null;
    }

    /**
     * This method  added by me let the user choose via INPUT which ArtWork to search in the Collection
     * if we have a match for botch ArtWork then we can proceed to compare them
     * @param c - collection object given as a parameter
     * @param artWorkName - first artwork to search in the collection
     * @param artWorkName2 - second artwork to search in the collection
     */
    public static void checkTwoObjects(Collection c, String artWorkName, String artWorkName2) {
        ArtWork a1 = null;
        ArtWork a2 = null;
        int flag = 0;

        // Search if the first artwork is in the arraylist
        for(ArtWork a: c.getArtWorks()) {
            if (Objects.equals(a.getArtworkName(), artWorkName)) {
                a1 = a;
            }
        }
        // Search if the second artwork is in the arraylist
        for(ArtWork aIt: c.getArtWorks()) {
            if (Objects.equals(aIt.getArtworkName(), artWorkName2)) {
                a2 = aIt;
            }
        }

        // If both ArtWork are present then put this PRINT FLAG = 1
        if(a1 != null && a2 != null) {
            flag = 1;
        } else {
            flag = 0;
        }
        // FLAG = 1 we have a match, and we can print if the ArtWork are equals
        if(flag == 1) {
            System.out.println("Le due opere inserite sono uguali?: " + a1.equals(a2));
        } else { // We don't have a match for both or just one
            System.out.println("Una delle 2 opere non è presente nell'ArrayList");
        }
    }

    /**
     * This method added by me check whick artwork is the oldest
     * @param c
     * @param artWorkName
     * @param artWorkName2
     */
    public static void checkOlder(Collection c, String artWorkName, String artWorkName2) {
        ArtWork a1 = presentInList(c, artWorkName);
        ArtWork a2 = presentInList(c, artWorkName2);
        // If both ArtWorks are present in the ArrayList
        if(a1 != null && a2 != null) {
            if (a1.getAge() > a2.getAge()) {
                System.out.println(a1.getArtworkName() + " è più vecchia di " + a2.getArtworkName());
            } else if (a2.getAge() > a1.getAge()){
                System.out.println(a2.getArtworkName() + " è più vecchia di " + a1.getArtworkName());
            } else {
                System.out.println("Le opere hanno uguale età");
            }
        } else {
            System.out.println("Impossibile calcolare l'opera più vecchia, una delle due non è presente in collezione");
        }
    }

    public static void main(String[] args) {

        ArtWork square = new Square(10, 5, 1506);
        ArtWork square2 = new Square(2, 2, 1506);
        ArtWork sculture = new Sculture(2, 15, 1.5, 1504);
        Collection collection = new Collection();
        // This is an object to test the methods with an object different from ArtWork/Square/Sculture
        Object obj = new Object();

        square.setArtistName("Leonardo");
        square.setArtworkName("Gioconda");

        square2.setArtistName("Leonardo2");
        square2.setArtworkName("Gioconda2");

        sculture.setArtistName("Michelangelo");
        sculture.setArtworkName("David");

        // Print Square and Sculture Encumbrance
        System.out.println("Square Encumbrance: " + square.printEncumbrance() + " m³");
        System.out.println("Sculture Encumbrance: " + sculture.printEncumbrance() + " m³\n");

        // Check if 2 objects are the same type
        System.out.println(square.getArtworkName() + " è uguale a " + square.getArtworkName() + "?: " + square.equals(square2));


        /**
         * COLLECTION OBJECT OPERATION
         */
        // Adding data to collection object
        collection.setName("Omaggio a Leonardo");
        collection.setLocation("Napoli");
        System.out.println("\nStampo le opere della collezione " + collection.getName());

        // Adding 2 artwork to the arraylist of artworks
        collection.addArtWork(square);
        collection.addArtWork(square2);
        collection.addArtWork(sculture);

        // Prints the artworks contained in the arraylist
        collection.printArtWork();

        // If the artwork given as parameter is contained in the artworks arraylist print the encumbrance
        collection.printArtWorkEncumbrance(square);

        /**
         * PERSONAL METHOD TO CHECK IF 2 OBJECT GIVEN AS A PARAMETER
         * ARE EQUALS IF THEY ARE IN THE COLLECTION
         */
        System.out.println("Inserire le due opere da confrontare");
        System.out.print("Prima opera da ricercare: ");
        String firstArtWork = input.next();
        System.out.print("Seconda opera da ricercare: ");
        String secondArtwork = input.next();
        // Calling the personal method
        checkTwoObjects(collection,firstArtWork, secondArtwork);

        /**
         * PERSONAL METHOD TO GET THE AGE OF AN ARTWORK
         */
        String s;
        System.out.print("Di quale opera vuoi sapere l'età?: ");
        s = input.next();
        for(ArtWork at: collection.getArtWorks()) {
            if(s.equals(at.getArtworkName())) {
                System.out.println(at.getArtworkName() + " ha " + at.getAge() + " anni");
            }
        }

        /**
         * PERSONAL METHOD TO CHECK WHICH ARTWORK IS THE OLDEST
         */
        System.out.println("Inserire 2 opere e vedere quale delle 2 è più antica");
        System.out.print("Prima opera da ricercare: ");
        String firstArtWork2 = input.next();
        System.out.print("Seconda opera da ricercare: ");
        String secondArtwork2 = input.next();
        checkOlder(collection, firstArtWork2, secondArtwork2);
    }
}

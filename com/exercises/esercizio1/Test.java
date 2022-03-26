package com.exercises.esercizio1;

class A {
    public String f(A x, A[] arr) {
        return "A1";
    }

    public String f(Object x, Object y) {
        return "A2";
    }
}

class B extends A {
    public String f(B x, Object[] y) {
        return "B1";
    }
}

class C extends B {
    public String f(A x, A[] arr) {
        return "C1";
    }

    public String f(B x, Object y) {
        return "C2";
    }

    public String f(C x, B y) {
        return "C3";
    }
}

public class Test {
    public static void main(String[] args) {
        A[] arr = new B[10];
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;

        // L'istruzione commentata era quella sbagliata
        //System.out.println(beta.f(gamma, arr));

        /**
         * Le istruzioni che seguono sono quelle che abbiamo corretto effettuando dei casting
         * Nel 1° caso: si entra in com.exercises.esercizio1.B si ricerca un metodo con i parametri indicati che non c'è;
         *              dunque dato che com.exercises.esercizio1.B extends com.exercises.esercizio1.A, si ricerca in com.exercises.esercizio1.A un metodo con i parametri
         *              del tipo indicato e lo si trova stampando A2.
         *
         * Nel 2° caso: si entra in com.exercises.esercizio1.B si ricerca un metodo con i parametri indicati, lo troviamo
         *              perchè il metodo che com.exercises.esercizio1.B ha contiene i parametri indicati da noi nella 2° stampa,
         *              quindi stampa B1.
         */
        System.out.println(beta.f(gamma, (Object) arr)); // A2
        System.out.println(beta.f((B) gamma, (Object[]) arr)); // B1

        /**
         * In questo caso si entra nella classe com.exercises.esercizio1.C che non ha nessun metodo con i parametri
         * da noi indicati nella stampa, com.exercises.esercizio1.C extends com.exercises.esercizio1.B e lo ricerchiamo in com.exercises.esercizio1.B senza successo
         * infine dato ceh com.exercises.esercizio1.B extends com.exercises.esercizio1.A troviamo in com.exercises.esercizio1.A un metodo che accetta come parametri
         * 2 oggetti (Object) quindi stampa A2.
         */
        System.out.println(gamma.f(arr, alfa)); // A2

        /**
         * In questo caso si entra nella classe com.exercises.esercizio1.C e si ricerca un metodo con i parametri qui indicati
         * lo ritroviamo nel secondo metodo che accetta un parametro di tipo com.exercises.esercizio1.B e un Object; dato che
         * abbiamo un riscontro stampiamo C2.
         */
        System.out.println(gamma.f(beta, alfa)); // C2

        /**
         * Somma BITWISE
         * È la somma in bit dei 2 numeri qui indicati
         * 5 = 101
         * 7 = 111
         * risultato = 111(binario) = 7(decimale)
         */
        System.out.println(5 | 7);
    }
}

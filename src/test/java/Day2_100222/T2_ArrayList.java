package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {

    public static void main(String[] args) {
        //choose java.util library from the suggestion when you type ArrayList

        //declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();

        //now add the values for countries array
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        //print USA from the countries list
        System.out.println("Countries value: " + countries.get(0));

        //get me all the count of the countries list
        System.out.println("Countries count: " + countries.size());

        //call an integer array list for streetNumber
        ArrayList<Integer> streetNumber;
        streetNumber = new ArrayList<>();

        streetNumber.add(222);
        streetNumber.add(333);
        streetNumber.add(444);
        System.out.println("First Street Number: " + streetNumber.get(0));

    }//end of main
}//end of java class

package Action_Items;

import java.util.ArrayList;

public class Automation_AI01_ForLoop_ArrayList {
    public static void main(String[] args) {

        //declare the ArrayLists
        ArrayList<String> country;
        ArrayList<Integer> countryCode;

        //define the ArrayList
        country = new ArrayList<>();

        //add the values for country array
        country.add("USA");
        country.add("Canada");
        country.add("Bangladesh");
        country.add("Pakistan");
        country.add("India");
        country.add("UAE");

        //define the ArrayList
        countryCode = new ArrayList<>();

        //add the values for countryCode array
        countryCode.add(1);
        countryCode.add(2);
        countryCode.add(880);
        countryCode.add(92);
        countryCode.add(91);
        countryCode.add(971);

        //call for loop to print out the countries and their country codes
        //initial index is 0, end point is 3, all indexes are to be printed
        for(int i = 0; i < countryCode.size() ; i++){

            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i) + ".");

        }//end of loop
    }//end of main
}//end of class

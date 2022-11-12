package Day1_100122;

import java.util.ArrayList;

public class DataTypes_Concat {

    public static void main(String[] args) {

        //declare and define a string variable
        String myString = "Welcome to Automation Class";
        String[] myStringArray = new String[]{"Welcome to Automation Class", "With Triage", };

        ArrayList<String> hello = new ArrayList<>();
        hello.add("hi");
        hello.add("bye");
        hello.add("okay");

        //declare and define an int variable
        int myNumber = 101;
        int[] myIntArray = new int[]{768, 456, 89};

        ArrayList<Integer> goodbye = new ArrayList<>();
        goodbye.add(56);
        goodbye.add(564);
        goodbye.add(566);

        //print both variables into one print statement
        System.out.println("My message is " + myString + " " + myNumber);

    }//end of main

}//end of java class

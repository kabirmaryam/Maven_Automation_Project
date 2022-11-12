package Practice;

import java.util.ArrayList;

public class Exercise2_phoneNumbers {
    public static void main(String[] args) {
        //declare and define array
        ArrayList<String> phoneNumbers = new ArrayList<>();

        //add values to array
        phoneNumbers.add("123456789");
        phoneNumbers.add("987654321");
        phoneNumbers.add("234567890");
        phoneNumbers.add("345678901");
        phoneNumbers.add("456789012");

        //for loop
        for (int i = 0; i < phoneNumbers.size(); i++) {

            //print
            System.out.println(phoneNumbers.get(i));
        }//end of for loop
    }//end of main
}//end of java class

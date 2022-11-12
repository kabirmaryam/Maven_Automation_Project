package Day2_100222;

public class T1_LinearArray {

    public static void main(String[] args) {

        //declare a String array variable. Array always starts from 0 index
        String[] zipCode, streetNumber;

        //defining zipcode values for the String array
        zipCode = new String[]{"11218", "11222", "10001", "11377"};

        //define street number values for linear array
        streetNumber = new String[]{"222", "333", "444", "555"};

        //print a value from zipcode. Array always starts from 0 index
        System.out.println("Zip Code: " + zipCode[3] + " " + zipCode[2]);
        System.out.println("Street Number: " + streetNumber[0]);
        System.out.println(zipCode.length);

    }//end of main

}//end of java class

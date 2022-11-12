package Practice;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        ArrayList<String> country;
        ArrayList<Integer> countryCode;

        country = new ArrayList<>();

        country.add("USA");
        country.add("Canada");
        country.add("Bangladesh");
        country.add("Pakistan");

        countryCode = new ArrayList<>();

        countryCode.add(1);
        countryCode.add(2);
        countryCode.add(880);
        countryCode.add(92);

        for(int i = 0; i < 4 ; i++){

            System.out.println("The country code of " + country.get(i) + " is " + countryCode.get(i) + ".");

        }


    }
}

package Action_Items;

public class Automation_AI01_WhileLoop_LinearArray {
    public static void main(String[] args) {

        //declare and define region array
        String[] region = new String[]{"Manhattan", "Buffalo", "Rochester", "Albany", "Binghamton"};

        //declare and define areaCode array
        int[] areaCode = new int[]{212, 716, 585, 518, 607};

        //set initializer
        int i = 0;

        //set condition for while loop
        while (i < areaCode.length) {

            //print regions and their area codes
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i] + ".");

            //incrementation
            i = i + 1;

        }//end of while loop
    }//end of main
}//end of class


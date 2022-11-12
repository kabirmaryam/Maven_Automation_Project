package Day3_100822;

public class T5_ReturnMethodExample {
    public static void main(String[] args) {

        int value = ReusableClass.returnTwoAddNumbers(5, 2);
        //now you can set additional calculation to the value since you stored it as a variable
        System.out.println("New value is " + (value + 3));
    }//end of main
}//end of java class

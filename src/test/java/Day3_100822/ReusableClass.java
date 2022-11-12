package Day3_100822;

public class ReusableClass {
    //create a void method that will add two numbers and execute the print statmenet
    public static void addTwoNumbers(int a , int b){
        int result = a + b;
        System.out.println("The result is " + result);
    }//end of method addTwoNumbers

    //create a return method that will add two numbers and return the result from the print statement
    public static int returnTwoAddNumbers(int a, int b){
        int result = a + b;
        System.out.println("The return result is " + result);
        return result;
    }//end of returnTwoAddNumbers

    public static int returnSubtractTwoNumbers(int a, int b, int c){
        int result_2 = (b - a) + c;
        System.out.println("The return result is " + result_2);
        return result_2;
    }//end of returnSubtractTwoNumbers

    public static void multiplyTwoNumbers(int a, int b){
        int result_3 = a * b;
        System.out.println("The answer is: " + (result_3 - 2));
    }//end of multiplyTwoNumbers

}//end of class

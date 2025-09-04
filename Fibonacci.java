public class Fibonacci {
    public static void main(String[] args) {
        // if the current length is less than n, then it will print out the text below 
        if (args.length < 1) {
            System.out.println("Please enter n.");
            return;
        }
        /*
         * this takes the first thing to user types 
         * and changes it from text to a number and saves as n 
         */
        int n = Integer.parseInt(args[0]);

        // creating a new array for the fibonacci numbers
        int[] fibonacci = new int[n];
        // this is the breaking condition because java returns it by default
        /*
         * so basically line 26  is telling the computer to figure out the fibonacci numbers 
         * this also prepares the list so i can print the numbers later
         */
        fibonacci(n-1, fibonacci, "");

        // as long as the number is less than n, it will print out the fibonacci numbers
        for (int i = 0; i < n; i++) {
            // printing out the array of numbers 
            System.out.print(fibonacci[i] + " ");
        }
        
    }
    // call stack is what recursion uses 
    public static int fibonacci(int i,int[] arr, String level){ 
        if (i < 2)
            // returning the array and making it if its 0 or 1
            return arr[i] = i;
        // if its not 0 or 1 then it will keep going down the stack until it hits the base case which is n-1
        return arr[i] = fibonacci(i - 1, arr, level + " ") + fibonacci(i - 2, arr, level + " ");
    }
}
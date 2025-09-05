
public class Eratosthenes {
    public static void main(String[] args) {
        if(args.length <1) {
            System.out.println("Please provide n.");
            return;
        }

        //converts string to integer
        int n = Integer.parseInt(args[0]);
        boolean[] places = new boolean[n];

        double startTime = System.nanoTime() ;
        eratosthenes(places);
        double duration = System.nanoTime() - startTime;
        duration = duration / Math.pow(10 , 9);
        System.out.printf("Eratosthenes took %.3f seconds\n", duration);


        // printing out the last 5 prime numbers
        System.out.println(" ");
        System.out.println("The last 5 prime numbers are: ");
        int count2 = 0;
        for (int i = places.length - 1; i >= 0 && count2 < 5; i--) {
            if (!places[i]) {
                System.out.printf("%d ", i);
                count2++;
            }
        }

    }

    public static void eratosthenes (boolean[] places) {
        
        // listing out all the prime numbers
        // only need to go up to the square root of n
        // starting at 2 because 0 and 1 arent prime so it would continue to go on and on
        for(int i = 2; i < Math.sqrt(places.length); i++) {
            // dont square root every time or itll be slower and less efficient
            // doing i + i because we want to start at the first multiple not the actual number so it's faster and doesnt mark it 
            for (int j = i + i; j < places.length; j+= i) {
                //i goes through the numbers and j is what starts 
                // marking 0 and 1 as not prime
                    places[j] = true;
            }
        }

    }
}

/*links i used for research 
 * 
 * https://www.tutorialspoint.com/java/java_arrays.htm
 * https://docs.oracle.com/javase/tutorial/
 * 
 */
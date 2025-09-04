import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Primes {
    public static void main(String[] args) {

        double startTime = System.nanoTime() ;
        double duration = System.nanoTime() - startTime;
        duration = duration / Math.pow(10 , 9);
        System.out.printf("Primes took %.3f seconds\n", duration);

        // step 1: getting the bytes
        byte[] bytes = getFileBytes("C:\\Users\\jajoh\\Downloads\\half_gaps.bin");

        // the numbers get too big so to prevent overflow we change to long
        long[] gaps = new long[bytes.length]; 

        // step 2: this code is finding the unsigned byte
         for (int i = 0; i < bytes.length; i++) 
            gaps[i] = Byte.toUnsignedInt(bytes[i]); 
        
        // calling the cumulative sum of gaps
        gaps = cumulativesum(gaps);

       for (int i = 0; i < gaps.length; i++) {
        //multiplying each individual number by 2 and adding 3
            gaps[i] = gaps[i] * 2 + 3;
       }
       
        //this is a for loop for printing out the first 15 change cumulative sums 
        System.out.println("The first 15 prime numbers are: ");
        System.out.println("2 ");
        System.out.println("3 ");
        // multiplying each individual number by 2 and adding 3
        for (int i = 0; i < 15; i++) {
            System.out.println(gaps[i]);
        }

        // Print the last 5 largest prime numbers
        System.out.println("The last 5 prime numbers are: ");
        for (int i = gaps.length - 5; i < gaps.length; i++) {
            System.out.println(gaps[i]);
        }
    }
    

    // getting the cumulative sum
    public static long[] cumulativesum(long[] gaps) {
        // starting at one 
        for (int i = 1; i < gaps.length; i++) {
            // adding the previous gap to the new gap which is i-1
            gaps[i] = gaps[i] + gaps[i-1];
        }
        return gaps;
    }

    // this is a method for finding the path for half gaps 
    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}

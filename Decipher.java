import java . io . IOException ;
import java . nio . file . Files ;
import java . nio . file . Paths ;

public class Decipher {
    public static void main (String[] args) {
        //
        int m = ( int )Math.pow (2 , 7) ;
        //making an array
        char [] cipher = new char [ m ];
        // this loop is reassigning the values and reading the file
        for (int i = 0; i < m ; i ++)
            cipher [ i ] = ( char ) mod (55 * (i - 3) , m );
            String plain = read ("Week 1\\cipher.txt");
            // printing out the cipher text aka printing it character by character
        for (int i = 0; i < plain.length () ; i ++)
            //
            System.out.print(cipher[plain.charAt(i)]);
        }
    // a method for reading the file path
    public static String read ( String path ) {
        String ret = null;
        try {
            ret = new String ( Files.readAllBytes (Paths.get(path)));
        } catch(IOException e) {
            e.printStackTrace() ;
        }
        return ret ;
    }
    // making a mod operations but making sure you get positive values
    public static int mod ( int x , int n ) {
        return (( x % n ) + n ) % n ;
    }
}

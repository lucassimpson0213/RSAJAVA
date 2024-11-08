
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class KeyManager {
    private int[] listPrimes;

    public KeyManager() {
        this.listPrimes = Constants.LIST_PRIMES;
    }

    public boolean verifyPrime(int p, int q) {
        return false;
    }

    public String readKeysFromFile() {
        String s = null;

        try {
            File file = new File("keys.txt");
            Scanner scan = new Scanner(file);
            scan.useDelimiter(" ");

            while (scan.hasNextLine()) {
                s = scan.nextLine();
            }

            scan.close(); // It's good practice to close the scanner

        } catch (IOException e) {
            System.out.println(e);
        }
        return s;
    }

    public void writeKeysToFile(int[] keyPairs) {
        FileWriter fw = null;
        try {
            File file = new File("keys.txt");
            fw = new FileWriter(file);

            for (int key : keyPairs) {
                fw.write(Integer.toString(key));
                fw.write(" ");
            }

        } catch (IOException e) {
            System.out.println("There was an error: " + e);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Could not close filestream");
            }
        }
    }

    public int[] generateKeyPairs(int p, int q) {
        //pq Arr is the array where we store the final keys
        int finalKeys [] = null;

        int eulertotient = (p - 1) * (q - 1);

        int r = p * q;


        for (int k = 1; k < 70; k++) {
            int S = k * eulertotient;
            int Splus1 = S + 1;

            for (int prime : this.listPrimes) {

                int factorMod = Splus1 % prime;

                int factor = Splus1 / prime;

                boolean meetsEulerCondtions = prime != 1 && factor != 1 && factorMod == 0 && factor != p && factor != q && prime != p
                        && prime != q && prime != factor;

                /**
                 * the prime cannot equal one, The factor cannot be 1, 
                 *  and the number must have mod zero, and the factor can't 
                 * equal p or q, as for the prime, and the prime cannot equal the factor.
                 * 
                */
                
                if (meetsEulerCondtions) {

                    finalKeys = new int[] { factor, prime, r };
                    break;
                }

                if (finalKeys != null) {
                    break;
                }
            }

            if (finalKeys != null) {
                break;
            }
        }
        return finalKeys;
    }

    public int makeChange(int base, int exponent, int mod) {
        int[] powerOfTwo = { 
            1, 2, 4, 8, 16, 32, 64, 128, 256, 
            512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 
        };
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int result = 1;

        // Step 1: Decompose exponent into powers of two
        for (int i = powerOfTwo.length - 1; i >= 0; i--) {
            if (sum + powerOfTwo[i] <= exponent) {
                sum += powerOfTwo[i];
                list.add(powerOfTwo[i]);
            }
        }

        // Step 2: Calculate base^power % mod for each power in list
        for (Integer powOfTwo : list) {
            int product = base % mod;

            
            int k = Integer.numberOfTrailingZeros(powOfTwo);

            // Square 'product' k times
            for (int j = 0; j < k; j++) {
                product = (product * product) % mod;
            }

            // Multiply into result
            result = (result * product) % mod;
        }

        // Optional: Print the powers for clarity
      

        return result;
    }
}

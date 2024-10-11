import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
public class KeyManager {
    private int n;
    private int s;
    private int[] listPrimes;

    public KeyManager() {
        this.listPrimes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                79, 83, 89, 97, 101, 103, 107, 109, 113, 127,
                131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
                241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
                307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
                433, 439, 443, 449, 457, 461, 463, 467, 479, 487,
                491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619,
                631, 641, 643, 647, 653, 659, 661, 673, 677, 683,
                691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829,
                839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911,
                919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };
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
            

            while(scan.hasNextLine()) {
                s = scan.nextLine();
                
            }


            


        }
        catch(IOException e) {
            System.out.println(e);
        }
        return s;
    }

    public void writeKeysToFile(int [] keyPairs) {
        FileWriter fw = null;
        try {
            File file = new File("keys.txt");
             fw = new FileWriter(file);

            for(int key: keyPairs) {
                fw.write(Integer.toString(key));
                fw.write(" ");
            } 
          
        }
        catch(IOException e) {
            System.out.println("There was an error" + e);
        }
        finally {
            try {
                fw.close();
            }
            catch(IOException e) {
                System.out.println("could not close filestream");
            }
           
          
        }
    }
    public void writeEncryptedText(ArrayList <Character> text) {
        FileWriter fw = null;
        try {
            File file = new File("encrypted.txt");
             fw = new FileWriter(file);

             for(Character c: text) {
                fw.append(c);
             }
          
        }
        catch(IOException e) {
            System.out.println("There was an error with writing the Encrypted text" + e);
        }
        finally {
            try {
                fw.close();
            }
            catch(IOException e) {
                System.out.println("could not close filestream");
            }
           
          
        }
    }

    public int[] generateKeyPairs(int p, int q) {
        int pqArr[] = null;
        int totient = (p - 1) * (q - 1);
        int r = p * q;
        for (int k = 1; k < 50; k++) {
            int S = k * totient;
            int Splus1 = S + 1;

            for (int prime : this.listPrimes) {
                int factorMod = Splus1 % prime;
                int factor = Splus1 / prime;
                if (prime != 1 && factor != 1 && factorMod == 0 && factor != p && factor != q && prime != p && prime != q) {

                    pqArr = new int[] { factor, prime, r };
                    break;

                }
                if (pqArr != null) {
                    break;
                }
            }

        }
        return pqArr;
    }

    public int makeChange(int base, int exponent, int mod) {
        int [] powerOfTwo = {1,2,4,8,16,32,64,128, 256, 512, 1024, 2048,4096, 8192, 16384, 32768, 65536};
        int sum = 0;
        int result = 1;


        for(int i = powerOfTwo.length - 1;i >= 0 && sum < exponent; i--) {
          
            if (sum + powerOfTwo[i] <= exponent) {
                int count = powerOfTwo[i];  
                
                
                for (int j = 0; j < count; j++) {
                    result *= base;
                    
                    
                }
                result = result % mod;
               
                sum += powerOfTwo[i];
                
            }
            
        }

        return result;

       
    }

    


 }

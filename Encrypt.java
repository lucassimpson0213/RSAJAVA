import java.util.ArrayList;
import java.util.Scanner;



public class Encrypt {
    public static void main(String [] args) {
       final KeyManager kg = new KeyManager();
       final int p, q;
       Scanner scan = new Scanner(System.in);

        //take user input
        System.out.println("Please Enter Two Prime Numbers:");

        //take two prime numbers
        p = 7;
        q = 13;

        
        //key generation
        int arr [] = kg.generateKeyPairs(p, q);

        //writing keys to keys.txt file
        kg.writeKeysToFile(arr);

        //getting the keys as a string from the file
        String s = kg.readKeysFromFile();


        //key array with 29 5 91 
        String [] keys = s.split(" ");

        //asserts make change 
        makeChangeTest(kg, 2, 29, 5, 91);
        makeChangeTest(kg, 115, 29, 5, 91);
        

       

        
        //gets input block from user
        System.out.println("Please enter your text: ");
        String inputBlock = scan.nextLine();


        ArrayList<Character> encryptText = new ArrayList<>();

        for(int i = 0; i < inputBlock.length(); i++) {
            int character = (int) inputBlock.charAt(i);
            System.out.println("character: " + character);
            char result = (char) kg.makeChange(character, Integer.parseInt(keys[0]),Integer.parseInt(keys[2]) );
            
            
            encryptText.add(result);

        }

 
        for(Character cha: encryptText) {
            System.out.println(cha);
        }









        



        

        

        


     

        

       

        scan.close();

    }


    public static void makeChangeTest(KeyManager kg, int base, int exponent, int exponent2, int mod) {
        int result = kg.makeChange(base, exponent, mod);
        int newResult = kg.makeChange(result, exponent2, mod);

        if(newResult != base) {
            System.out.println("result does not equal newResult: " + "( Recieved:" + newResult + "," +  "Expected: " + base + ")");
            return;
        }
        else {
            System.out.println("make change test passed with value: " + newResult);
        }

    }

  
}

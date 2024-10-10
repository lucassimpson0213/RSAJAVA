import java.util.ArrayList;
import java.util.Scanner;


public class Encrypt {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
       final int p, q;

        System.out.println("Please Enter Two Prime Numbers:");
        p = 7;
        q = 13;

        KeyManager kg = new KeyManager();
        int arr [] = kg.generateKeyPairs(p, q);
        kg.writeKeysToFile(arr);
        String s = kg.readKeysFromFile();

        System.out.println("Please enter your text: ");
        String inputBlock = scan.nextLine();

        ArrayList<Character> unicodeArrayList;

        for(int i = 0; i < inputBlock.length() - 1; i++) {
           char c =  unicodeArrayList.add(unicodeArrayList.charAt(i));

        }











      
      

      
        
       
        int finalInt = kg.makeChange(6, 8, 11) ;
        int testInt = (int)( Math.pow(6, 2) * Math.pow(6, 2) * Math.pow(6, 2) * Math.pow(6, 2)) % 11;
        System.out.println(finalInt);
        System.out.println(testInt);
        

        
       

        




       






        





        scan.close();

    }

  
}
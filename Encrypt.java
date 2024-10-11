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

        String [] keys = s.split(" ");

        System.out.println("Please enter your text: ");
        String inputBlock = scan.nextLine();

        ArrayList<Character> encryptedText = new ArrayList<>();

        for(int i = 0; i < inputBlock.length() - 1; i++) {
           char c =  inputBlock.charAt(i);
           int asciiCode =  76;
           System.out.println(c);
           int result = kg.makeChange(asciiCode, Integer.parseInt(keys[0]), Integer.parseInt(keys[2]));
           char resultedEncrypted = (char) result;
           System.out.println(result);
            
           char newResult = (char) result;

            encryptedText.add(newResult);

           

           

        }

        

        kg.writeEncryptedText(encryptedText);






        

















      
      

      
        
       
        int finalInt = kg.makeChange(6, 8, 11) ;
        int testInt = (int)( Math.pow(6, 2) * Math.pow(6, 2) * Math.pow(6, 2) * Math.pow(6, 2)) % 11;
        System.out.println(finalInt);
        System.out.println(testInt);
        

        
       

        




       






        





        scan.close();

    }

  
}
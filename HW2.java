//Ashley Barton
//Homework 2 - Problem 4
//April, 20th 2014
import java.io.*;
import java.util.Scanner;

public class HW2 {

    public static void main(String [] args) {    
        String ciphertext;
        String decrypted;
        String plaintext = getText("plaintext.txt");
        Crypto aes = new Crypto(plaintext);

        //Encrypt the message
        aes.genKey();
        aes.setCipher();
        ciphertext = aes.encrypt();
        
        //store the ciphertext into a file
        writeToFile(ciphertext, "ciphertext.txt");
        
        //read the contents of ciphertext
        String ciphertextFromFile = getText("ciphertext.txt");
        System.out.println("Cipher text from file: " + ciphertextFromFile + "\n\n"); 
        
        decrypted = aes.decrypt(ciphertextFromFile);

        //Write Decrypted message to decryptedtext.txt
        writeToFile(decrypted, "decryptedtext.txt");
        System.out.println("Decrypted Message: " + decrypted + "\n\n");
    }

    public static String getText(String filename) {
        String text = null;
        File file = new File(filename);
        //Read the message from given file
        try {
                Scanner scan = new Scanner(file);
                text = scan.nextLine();
                scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void writeToFile(String str, String filename) {
        File f = new File(filename);

        if(f.isFile() == false) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
                PrintWriter outFile = new PrintWriter(filename);
                outFile.println(str);
                outFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}

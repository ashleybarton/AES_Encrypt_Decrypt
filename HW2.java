//Ashley Barton
//Homework 2 - Problem 4
//April, 20th 2014
import java.io.*;
import java.util.Scanner;

public class HW2 {

    public static void main(String [] args) {    

        String plaintext = getText("plaintext.txt");
        System.out.println(plaintext);

        Crypto aes = new Crypto(plaintext);

        aes.genKey();
        aes.setCipher();
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

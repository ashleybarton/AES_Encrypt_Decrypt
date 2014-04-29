//Ashley Barton
//Homework 2 - Problem 4
//April, 20th 2014
import java.io.*;
import java.util.Scanner;

public class JCE {

    public static void main(String [] args) {    
        File file = new File("plaintext.txt");
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

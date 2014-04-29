//Ashley Barton
//Homework 2 - #4

import java.security.*;
import javax.crypto.*;

public class Crypto {
    private String plaintext;
    private KeyGenerator kg;
    private SecretKey sk;
    private Cipher c;

    public Crypto(String msg) {
        plaintext = msg;
        System.out.println("Plaintext message: " + plaintext);
    }

    //generate the key
    public void genKey(){
        try{
            kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            sk = kg.generateKey();
            System.out.println("Generating the key.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //sets the cipher type to AES
    public void setCipher() {
        System.out.println("Setting AES as the encryption type."); 
        try{     
            c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, sk);
        }   catch (NoSuchAlgorithmException noSuchAlgo) {
            System.out.println(" No Such Algorithm exists " + noSuchAlgo);
            }
            catch (NoSuchPaddingException noSuchPad) {
                System.out.println(" No Such Padding exists " + noSuchPad);
            }
            catch (InvalidKeyException invalidKey){
                System.out.println(" Invalid Key " + invalidKey);
            }
    }
/*
            catch (NoSuchPaddingException noSuchPad) {
                System.out.println(" No Such Padding exists " + noSuchPad);
            }
            catch (InvalidKeyException invalidKey){
                System.out.println(" Invalid Key " + invalidKey);
            }
            catch (BadPaddingException badPadding){
                System.out.println(" Bad Padding " + badPadding);
            }
            catch (IllegalBlockSizeException illegalBlockSize) {
                System.out.println(" Illegal Block Size " + illegalBlockSize);
            }
            catch (InvalidAlgorithmParameterException invalidParam) {
                System.out.println(" Invalid Parameter " + invalidParam);
            }

//*/
}

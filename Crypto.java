//Ashley Barton
//Homework 2 - #4

import java.security.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Base64;

public class Crypto {
    private String plaintext;
    private String ciphertext;
    private String decryptedText;
    private KeyGenerator kg;
    private SecretKey sk;
    private Cipher c;

    public Crypto(String msg) {
        plaintext = msg;
        System.out.println("\nPlaintext: " + plaintext + "\n");
    }

    //generate the key
    public void genKey(){
        try{
            kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            sk = kg.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //sets the cipher type to AES
    public void setCipher() {
        try{     
            c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, sk);
        }   catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
            }
            catch (NoSuchPaddingException e) {
                System.out.println("No Such Padding Exists");
            }
            catch (InvalidKeyException invalidKey){
                System.out.println("Invalid Key");
            }
    }
    
    public String encrypt() {
        try{
            byte [] bytesOfPlaintext = plaintext.getBytes();
            byte [] bytesOfCiphertext = c.doFinal(bytesOfPlaintext);
            ciphertext = new String(Base64.encodeBase64(bytesOfCiphertext));
            
            System.out.println("ciphertext: " + ciphertext + "\n\n");
        } 
            catch (BadPaddingException e){
                System.out.println("Bad padding");
            }
            catch (IllegalBlockSizeException illegalblocksize) {
                System.out.println("Illegal block size");
            }
        return ciphertext;    
    }

    public String decrypt(String ct) {
        try{
              byte [] bytesOfCiphertext = Base64.decodeBase64(ct.getBytes());
                
                c.init(Cipher.DECRYPT_MODE, sk, c.getParameters());
                byte [] bytesDecrypted = c.doFinal(bytesOfCiphertext);
                decryptedText = new String(bytesDecrypted);
        }
            catch (BadPaddingException e){
                System.out.println("Padding issue");
            }
            catch (IllegalBlockSizeException e) {
                System.out.println("Illegal Block Size");
            }
            catch (InvalidKeyException e){
                System.out.println("Invalid Key");
            }
            catch (InvalidAlgorithmParameterException e) {
                System.out.println("Invalid parameter");
            }
        return decryptedText;
    }
}

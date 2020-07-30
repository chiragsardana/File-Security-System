package com.ncu.processors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
public class Decryption
{
	public static byte[] decrypt(String key, byte[] encryptedPayload)
    {
        try 
        {
            byte[] iv = new byte[16];//for iv 
            byte[] encrypted = new byte[encryptedPayload.length - iv.length];//for cipher functioning..
            System.arraycopy(encryptedPayload, 0, iv, 0, 16);
            System.arraycopy(encryptedPayload, iv.length, encrypted, 0, encrypted.length);

            //here we have to put wrong key exception...
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
     
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,new IvParameterSpec(iv));
            byte[] original = cipher.doFinal((encrypted));
     
            return original;// return original byte array..
        } 
        catch (Exception ex) 
        {
            System.out.println("Oops... You have entered Wrong Key...Please Try Again");
        }
        return null;
    }

}
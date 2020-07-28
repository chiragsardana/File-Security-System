package com.ncu.processors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
public class Encryption
{
	public static byte[] encrypt(String key, byte[] content)throws Exception//here we are taking 128 bit key as string...
    {
        try 
        {
            Cipher cipher;//reference of cipher
            byte[] encrypted = null;

            int ivSize = 16;//16 Byte 
            byte[] iv = new byte[ivSize];
            SecureRandom random = new SecureRandom();//for every encryption we are generating different arbitrary constant..
            random.nextBytes(iv);

            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");//UTF-8 unicode transformation format 8 bit.

            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec,new IvParameterSpec(iv));

            encrypted = cipher.doFinal(content);//encrypted byte array contains file data in encrypted form...

            byte[] combinedPayload = new byte[iv.length + encrypted.length];//for storing iv with encrypted data

            System.arraycopy(iv, 0, combinedPayload, 0, iv.length);//as iv is not secret we can store it in public 

            System.arraycopy(encrypted, 0, combinedPayload, iv.length, encrypted.length);

            return combinedPayload;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

}
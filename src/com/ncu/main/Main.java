package com.ncu.main;
import com.ncu.processors.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception 
    {
    	Scanner input=new Scanner(System.in);

    	String key = "aesEncryptionKey";

        String originalString = input.nextLine();

        System.out.println("Original String to encrypt - " + originalString);

        EncryptionText encrypt=new EncryptionText();
        String encryptedString = encrypt.encryptText(originalString,key);

        System.out.println("Encrypted String - " + encryptedString);

        DecryptionText decrypt=new DecryptionText();
        String decryptedString = decrypt.deryptText(encryptedString,key);

        System.out.println("After decryption - " + decryptedString);
    }
}
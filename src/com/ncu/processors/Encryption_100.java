package com.ncu.processors;
import java.util.*;
import java.io.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;
public class Encryption_100
{
	public static void encrypt(String key,String extension,String fileName ) 
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+"."+extension));
			FileOutputStream fos = new FileOutputStream("..\\File Security System\\encrypted file\\"+fileName+"."+"bin");
   			int read;

   			int ivSize = 16;//16 Byte 
            byte[] iv = new byte[ivSize];
            SecureRandom random = new SecureRandom();//for every encryption we are generating different arbitrary constant..
            random.nextBytes(iv);

   			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES"); 
			Cipher encipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  

   			encipher.init(Cipher.ENCRYPT_MODE, skeySpec,new IvParameterSpec(iv));

			CipherInputStream cis = new CipherInputStream(fis, encipher); 
			//we have to write iv in the file
			for(int i=0;i<16;i++)
			{
				fos.write(iv[i]);
			}
			while((read = cis.read())!=-1)
			{
				fos.write((char)read);
         		fos.flush();
			}
			fos.close();
			fis.close();
		}
		catch(Exception fe)
		{
			System.out.println(fe);
		}
	}
}
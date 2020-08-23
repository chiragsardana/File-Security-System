package com.ncu.processors;
import com.ncu.processors.*;
import java.util.*;
import java.io.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
public class Decryption_100
{
	public static byte[] decrypt(String key,String extension,String fileName) 
	{
		byte[] content=null;	
		try
		{
			FileInputStream fis = new FileInputStream(new File("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+".bin"));
			FileOutputStream fos = new FileOutputStream("..\\File Security System\\decrypted file\\"+fileName+"."+extension);
   			int read;

   			int ivSize = 16;//16 Byte 
            byte[] iv = new byte[ivSize];

   			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES"); 
			Cipher encipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  

   			encipher.init(Cipher.DECRYPT_MODE, skeySpec,new IvParameterSpec(iv));

			CipherInputStream cis = new CipherInputStream(fis, encipher); 
			//we have to write iv in the file
				
			

			int i=0;
			while(((read = cis.read())!=-1) && i<15 )
			{
				iv[i]=(byte)read;
				i++;
			}
			while((read = cis.read())!=-1)
			{
				
				fos.write((char)read);
         		fos.flush();
			}
			fos.close();
			fis.close();
			cis.close();
			
			content=GetFileConverted.getFileConverted(fileName,"bin","decrypted file\\");

		}
		catch(Exception fe)
		{
			System.out.println(fe);
		}
		return content;
	}
}
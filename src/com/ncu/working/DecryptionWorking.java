package com.ncu.working;
import com.ncu.processors.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
public class DecryptionWorking
{
	public static boolean decryptionWorking(String key,String fileName,String req)
	{
		String[] words=fileName.split("[.]");
		String extension=words[1];
		fileName=words[0];
		String depends="encrypted file\\";
		byte[] content=GetFileConverted.getFileConverted(fileName,extension,depends);

		if(req.equals("Text"))
		{
			extension="txt";
		}
		else if(req.equals("Image"))
		{
			extension="jpg";
		}
		else if(req.equals("Video"))
		{
			extension="mp4";
		}
		else if(req.equals("Audio"))
		{
			extension="mp3";
		}
		else if(req.equals("Document"))
		{
			extension="pdf";
		}
		else
		{
			extension="bin";
		}

		saveTempFile(content);//Now i have to check here that file size is less than or greater than 1,000,000 Bytes
		long size_of_file=fileSize();
		depends="decrypted file\\";
		if(size_of_file>1000000)//100 mb
		{
			//key and extension and fileName should be passed
			byte[] file=Decryption_100.decrypt(key,extension,fileName);// here i have to implement new conditions
			if(file==null)
			{
				try
				{
				File directory=new File("..\\File Security System\\decrypted file\\"+fileName+"."+extension);
				FileUtils.forceDelete(directory);
				}
				catch(Exception e)
				{
					System.out.println("\n"+e);
				}
				return false;
			}
			
			return true;
		}
		else
		{
			byte[] file=Decryption.decrypt(key,content);
			if(file==null)//here it is checking whether the security key is correct or not...
			{
				return false;
			}

			SaveFile.saveFile(file,fileName,extension,depends);
			return true;
		}
	}
	public static void saveTempFile(byte[] bytes)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+".bin");
            fos.write(bytes);
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
    public static long fileSize()
    {
    	File f = new File("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+".bin");
       	long fileSize = f.length();
        return fileSize;
    }
}
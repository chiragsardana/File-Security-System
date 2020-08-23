package com.ncu.working;
import com.ncu.processors.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class EncryptionWorking
{
	public static void encryptionWorking(String key,String fileName)
	{
		String[] words=fileName.split("[.]");
		String extension=words[1];
		fileName=words[0];
		String depends="file\\";
		byte[] content=GetFileConverted.getFileConverted(fileName,extension,depends);
		saveTempFile(content,extension);//Now i have to check here that file size is less than or greater than 1,000,000 Bytes
		long size_of_file=fileSize(extension);
		if(size_of_file>1000000)//100 mb
		{
			//key and extension and fileName should be passed
			Encryption_100.encrypt(key,extension,fileName);
			File remove=new File("..\\File Security System\\src\\com\\ncu\\temp\\temporary."+extension);
			remove.delete();
		}
		else
		{
			byte[] file=Encryption.encrypt(key,content);
			extension="bin";
			depends="encrypted file\\";
			SaveFile.saveFile(file,fileName,extension,depends);
		}
	}
	public static void saveTempFile(byte[] bytes,String extension)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+"."+extension);
            fos.write(bytes);
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
    public static long fileSize(String extension)
    {
    	File f = new File("..\\File Security System\\src\\com\\ncu\\temp\\temporary"+"."+extension);
       	long fileSize = f.length();
        return fileSize;
    }
}
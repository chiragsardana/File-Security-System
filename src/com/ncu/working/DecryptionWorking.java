package com.ncu.working;
import com.ncu.processors.*;
public class DecryptionWorking
{
	public static boolean decryptionWorking(String key,String fileName,String req)
	{
		String[] words=fileName.split("[.]");
		String extension=words[1];
		fileName=words[0];
		String depends="encrypted file\\";
		byte[] content=GetFileConverted.getFileConverted(fileName,extension,depends);
		byte[] file=Decryption.decrypt(key,content);
		
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
		depends="decrypted file\\";
		if(file==null)
		{
			return false;
		}
		SaveFile.saveFile(file,fileName,extension,depends);
		return true;
	}
}
package com.ncu.working;
import com.ncu.processors.*;
public class EncryptionWorking
{
	public static void encryptionWorking(String key,String fileName)throws Exception
	{
		String[] words=fileName.split("[.]");
		String extension=words[1];
		fileName=words[0];
		String depends="file\\";
		byte[] content=GetFileConverted.getFileConverted(fileName,extension,depends);
		byte[] file=Encryption.encrypt(key,content);
		extension="bin";
		depends="encrypted file\\";
		SaveFile.saveFile(file,fileName,extension,depends);
	}
}
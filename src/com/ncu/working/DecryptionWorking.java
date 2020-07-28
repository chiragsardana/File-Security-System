package com.ncu.working;
import com.ncu.processors.*;
public class DecryptionWorking
{
	public static void decryptionWorking(String key,String fileName)throws Exception
	{
		String[] words=fileName.split("[.]");
		String extension=words[1];
		fileName=words[0];
		String depends="encrypted file\\";
		byte[] content=GetFileConverted.getFileConverted(fileName,extension,depends);
		byte[] file=Decryption.decrypt(key,content);
		extension="txt";//switch case has to be applied depends on the file type...
		depends="decrypted file\\";
		SaveFile.saveFile(file,fileName,extension,depends);
	}
}
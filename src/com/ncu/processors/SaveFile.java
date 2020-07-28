package com.ncu.processors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class SaveFile
{
	public static void saveFile(byte[] bytes,String fileName,String extension,String depends) throws Exception 
    {
        FileOutputStream fos = new FileOutputStream("..\\File Security System\\"+depends+fileName+"."+extension);
        fos.write(bytes);
        fos.close();
    }
}
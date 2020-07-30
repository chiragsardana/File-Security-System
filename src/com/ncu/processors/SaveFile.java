package com.ncu.processors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class SaveFile
{
	public static void saveFile(byte[] bytes,String fileName,String extension,String depends)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("..\\File Security System\\"+depends+fileName+"."+extension);
            fos.write(bytes);
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
}
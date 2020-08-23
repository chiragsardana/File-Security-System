package com.ncu.processors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class TempFile
{
	public static void saveFile()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("..\\File Security System\\src\\com\\ncu\\temp");
            fos.write(bytes);
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
}
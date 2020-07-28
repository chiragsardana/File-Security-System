package com.ncu.main;
import com.ncu.processors.*;
import com.ncu.working.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception 
    {
    	MainInterface.clearScreen();//for clear screen
    	MainInterface.mainInterface();

    	
    	String key = "aesEncryptionKey";
    	String fileName="sardana.txt";
    	EncryptionWorking.encryptionWorking(key,fileName);
    }
}
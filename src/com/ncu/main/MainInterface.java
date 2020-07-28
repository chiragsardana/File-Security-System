package com.ncu.main;
import java.io.*;
import com.ncu.working.*;
import java.util.Scanner;
public class MainInterface
{
	static Scanner input=new Scanner(System.in);
	public static void mainInterface()
	{
		System.out.println("\n=======================  WELCOME TO INTERFACE  =======================\n ");
		System.out.println(" \n                      \t1. To Encrypt File ");
		System.out.println(" \n                      \t2. To Decrypt File ");
		System.out.println(" \n                      \t3. To Exit Program ");
		System.out.print("\n\nEnter Your Option : ");
		int select=input.nextInt();
		switch(select)
		{
			case 1 : 
			clearScreen();
			encryptInterface();
			break;
			case 2 :
			clearScreen(); 
			decryptInterface();
			break;
			case 3 :
			System.exit(1);
			break;
			default :
			clearScreen(); 
			System.out.println("\n======================= You Entered Invalid Choice, Please Try Again =======================\n");
			mainInterface();
			break;
		}
	}
	public static void encryptInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT INTERFACE  =======================\n ");
		System.out.println(" \n                      \t1. To Encrypt Text File ");
		System.out.println(" \n                      \t2. To Encrypt Image File ");
		System.out.println(" \n                      \t3. To Encrypt Video File ");
		System.out.println(" \n                      \t4. To Encrypt Document File ");
		System.out.println(" \n                      \t5. To Exit Program ");
		System.out.print("\n\nEnter Your Option : ");
		int select=input.nextInt();
		switch(select)
		{
			case 1 :
			clearScreen(); 
			encryptTextFileInterface();
			break;
			case 2 :
			clearScreen();
			encryptImageFileInterface();
			break;
			case 3 :
			clearScreen();
			encryptVideoFileInterface();
			break;
			case 4 :
			clearScreen();
			encryptDocumentFileInterface();
			break;
			case 5 :
			System.exit(1);
			break;
			default :
			clearScreen(); 
			System.out.println("\n======================= You Entered Invalid Choice, Please Try Again =======================\n");
			encryptInterface();
			break;
		}
	}
	public static void decryptInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT INTERFACE  =======================\n ");
		System.out.println(" \n                      \t1. To Decrypt Text File ");
		System.out.println(" \n                      \t2. To Decrypt Image File ");
		System.out.println(" \n                      \t3. To Decrypt Video File ");
		System.out.println(" \n                      \t4. To Decrypt Document File ");
		System.out.println(" \n                      \t5. To Exit Program ");
		System.out.print("\n\nEnter Your Option : ");
		int select=input.nextInt();
		switch(select)
		{
			case 1 :
			clearScreen(); 
			decryptTextFileInterface();
			break;
			case 2 :
			clearScreen();
			decryptImageFileInterface();
			break;
			case 3 :
			clearScreen();
			decryptVideoFileInterface();
			break;
			case 4 :
			clearScreen();
			decryptDocumentFileInterface();
			break;
			case 5 :
			System.exit(1);
			break;
			default :
			clearScreen(); 
			System.out.println("\n======================= You Entered Invalid Choice, Please Try Again =======================\n");
			decryptInterface();
			break;
		}
	}
	public static void encryptTextFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT TEXT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Text File Name : ");
		// String fileName=input.nextLine();//to take file name from user...
		//now we have to check the file name type and all other things using validtors...
		//after that u have to enter key 16 byte key i.e., 128 bit
	}
	public static void encryptImageFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT IMAGE FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Image File Name : ");
	}
	public static void encryptVideoFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT VIDEO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Video File Name : ");
	}
	public static void encryptDocumentFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT DOCUMENT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Document File Name : ");
	}
	public static void decryptTextFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT TEXT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Text File Name : ");
	}
	public static void decryptImageFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT IMAGE FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Image File Name : ");
	}
	public static void decryptVideoFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT VIDEO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Video File Name : ");
	}
	public static void decryptDocumentFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT DOCUMENT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Document File Name : ");
	}
	static void clearScreen()//for clear screen
	{
		try 
		{
        	if (System.getProperty("os.name").contains("Windows"))
        	{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        	}
        	else
        	{
            Runtime.getRuntime().exec("clear");
        	}
    	} 
    	catch (IOException | InterruptedException ex) 
    	{

    	}
	}
}
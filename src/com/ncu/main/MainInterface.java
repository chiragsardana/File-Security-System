package com.ncu.main;
import java.io.*;
import com.ncu.working.*;
import com.ncu.validators.*;
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
		System.out.println(" \n                      \t4. To Encrypt Audio File ");
		System.out.println(" \n                      \t5. To Encrypt Document File ");
		System.out.println(" \n                      \t6. To Exit Program ");
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
			encryptAudioFileInterface();
			break;
			case 5 :
			clearScreen();
			encryptDocumentFileInterface();
			break;
			case 6 :
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
		System.out.println(" \n                      \t4. To Decrypt Audio File ");
		System.out.println(" \n                      \t5. To Decrypt Document File ");
		System.out.println(" \n                      \t6. To Exit Program ");
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
			decryptAudioFileInterface();
			break;
			case 5 :
			clearScreen();
			decryptDocumentFileInterface();
			break;
			case 6 :
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
		//input.nextLine();//so that scanner goes to next line...
		String fileName=getFileName();
		System.out.print(fileName);
		// String fileName=input.nextLine();//to take file name from user...
		//now we have to check the file name type and all other things using validtors...
		//after that u have to enter key 16 byte key i.e., 128 bit
	}
	public static void encryptImageFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT IMAGE FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Image File Name : ");
		getFileName();
	}
	public static void encryptVideoFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT VIDEO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Video File Name : ");
		getFileName();
	}
	public static void encryptAudioFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT AUDIO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Audio File Name : ");
		getFileName();
	}
	public static void encryptDocumentFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO ENCRYPT DOCUMENT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Document File Name : ");
		getFileName();
	}
	public static void decryptTextFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT TEXT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Text File Name : ");
		getFileName();
	}
	public static void decryptImageFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT IMAGE FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Image File Name : ");
		getFileName();
	}
	public static void decryptVideoFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT VIDEO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Video File Name : ");
		getFileName();
	}
	public static void decryptAudioFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT AUDIO FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Audio File Name : ");
		getFileName();
	}
	public static void decryptDocumentFileInterface()
	{
		System.out.println("\n=======================  WELCOME TO DECRYPT DOCUMENT FILE INTERFACE  =======================\n ");
		System.out.print("\nEnter Document File Name : ");
		getFileName();
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
	public static String getFileName()//for file name and check the name using FileNameValidator...
	{
		input.nextLine();//so that scanner goes to next line...
		String fileName=input.nextLine();
		Boolean checker;
		checker=FileNameValidator.fileNameValidator(fileName);
		if(checker==false)
		{
			
			System.out.println("\n==================== You Entered Invalid File Name, Please Try Again ====================\n");
			System.out.println(" \n                       \t\t1. To Exit Program");
			System.out.println(" \n                  \t    Any Number Key To Go Main Menu ");
			System.out.print("\n\nEnter Your Option : ");
			int select=input.nextInt();
			switch(select)
			{
				case 1 : 
				System.exit(1);
				break;
				default :
				clearScreen(); 
				//=============
				//System.out.println("\n============= You Entered Invalid Choice, Please Try Again =============\n");
				mainInterface();
				break;
			}
		}
		return fileName;
	}
}
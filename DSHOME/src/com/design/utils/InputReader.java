package com.design.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class InputReader {
	
	Scanner sc;

	public InputReader(File file)
	{
		try {
			sc=new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public InputReader(InputStream in)
	{
		sc=new Scanner(in);
	}
	
	public int readInt()
	{
		
		int input=sc.nextInt();
		
		return input;
	}
	public String readLine()
	{
		
		String input=sc.nextLine();
		return input;
	}
	public void advanceLine()
	{
		sc.nextLine();
	}
	public void close()
	{
		sc.close();
	}


}

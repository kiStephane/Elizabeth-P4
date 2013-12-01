/**
 * 
 */
package model;

import java.lang.System;

/**
 * @author Stéphane
 *
 */
public class PortablePixelMapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String USAGE_MESSAGE = "Usage: \n"
+"java PortablePixelMapper <inFile> <width> <height> <outFile> \n"
 
+"<inFile> is the name of an input file with svg shape information \n"
+"<width> is the result image width in pixels \n"
+"<height> is the result image height in pixels \n"
+"<outFile> is the name of the ppm file to create \n \n"

+"Example: \n"
+"java PortablePixelMapper sample01.txt 100 100 image01.ppm \n ";
				
		if (verifyArguments(args))
		{
			
		}
		else
		{
			System.out.println(USAGE_MESSAGE);
		}

	}
	

	/**
	 * 
	 * @param arguments
	 * @return
	 */
	public static boolean verifyArguments(String[] arguments)
	{
		boolean valid = false;			
		
		if (arguments.length == 4) 
		{
			valid=(arguments[0].endsWith(".txt")) && isNumeric(arguments[1])&&isNumeric(arguments[2])&& (arguments[3].endsWith(".ppm"));
		}
		
		return valid;
		
	}
	
	/**
	 * This method verify that a string is Numeric 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}

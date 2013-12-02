/**
 * 
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.awt.Color;

/**
 * @author Stéphane
 *
 */
public class SVG {
	
	private ArrayList<Shape> shapes;
	private String fileName;
	
	public SVG(String fileName)
	{
		this.fileName=fileName;	
		shapes= new ArrayList<Shape>();
		try
		{
			readFile();	
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	public SVG()
	{
		this.fileName=null;	
		shapes= new ArrayList<Shape>();
	}
	
	public ArrayList<Shape> getShapes()
	{
		return this.shapes;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void readFile () throws FileNotFoundException
	{
		BufferedReader br ;	
		try {
				FileReader fr= new FileReader(this.fileName);
				br = new BufferedReader(fr);
					
				try{
					String line = br.readLine();
					
					while (line != null) {
					addShape(line);
					line = br.readLine();
					}
					br.close();					
					}
					catch (IOException ioEx)
					{
					
					}

			} 
			catch (FileNotFoundException ex) {
				throw ex;				
			}
		
	}
	
	/**
	 * 
	 * @param data
	 */
	public void addShape(String data)
	{
		String arr[] = data.split(" ");
		
		if (arr.length>1)
		{		
			switch (arr[0]) 
			{
	        case "rectangle": 
	        	if (verifyArguments(arr))
	        	{
	        		String r= arr[1];
	        		String g= arr[2];
	        		String b= arr[3];
	        		
	        		Color color= new Color(Integer.parseInt(r),Integer.parseInt(g),Integer.parseInt(b));        		
	        		Rectangle rec = new Rectangle(color,Double.parseDouble(arr[4]),Double.parseDouble(arr[5]),Double.parseDouble(arr[6]),Double.parseDouble(arr[7]));
	        		
	        		this.shapes.add(rec);
	        	}
	            break;
	        case "square": 
	        	if (verifyArguments(arr))
	        	{
	        		String r= arr[1];
	        		String g= arr[2];
	        		String b= arr[3];
	        		
	        		Color color= new Color(Integer.parseInt(r),Integer.parseInt(g),Integer.parseInt(b));        		
	        		Square sq = new Square (color,Double.parseDouble(arr[4]),Double.parseDouble(arr[5]),Double.parseDouble(arr[6]));
	        		
	        		this.shapes.add(sq);
	        	}
	            break;
	        case "circle": 
	        	if (verifyArguments(arr))
	        	{
	        		String r= arr[1];
	        		String g= arr[2];
	        		String b= arr[3];
	        		
	        		Color color= new Color(Integer.parseInt(r),Integer.parseInt(g),Integer.parseInt(b));        		
	        		Circle circle = new Circle (color,Double.parseDouble(arr[4]),Double.parseDouble(arr[5]),Double.parseDouble(arr[6]));
	        		
	        		this.shapes.add(circle);
	        	}
	            break;
	            
	        case "ring": 
	        	if (verifyArguments(arr))
	        	{
	        		String r= arr[1];
	        		String g= arr[2];
	        		String b= arr[3];
	        		
	        		Color color= new Color(Integer.parseInt(r),Integer.parseInt(g),Integer.parseInt(b));        		
	        		Ring ring = new Ring (color,Double.parseDouble(arr[4]),Double.parseDouble(arr[5]),Double.parseDouble(arr[6]),Double.parseDouble(arr[7]));
	        		
	        		this.shapes.add(ring);
	        	}
	            break;   
			}
		}
	}
	
	/**
	 * 
	 * @param args
	 * @return
	 */
	private boolean verifyArguments(String [] args)
	{
		boolean valid=false;
		if(args.length>1)
		{
			switch (args[0])
			{
	        case "rectangle": 
	        	valid=rangeAndNumeric(args,8);       		        	
	            break;
	        case "square": 
	        	valid=rangeAndNumeric(args,6);
	            break;
	        case "circle": 
	        	valid=rangeAndNumeric(args,6);
	            break;
	            
	        case "ring": 
	        	valid=rangeAndNumeric(args,7);
	            break;   
			}
		}
		
		return valid;
	}

	
	/**
	 * 
	 * @param args
	 * @param numArgs
	 * @return
	 */
	private boolean rangeAndNumeric(String [] args, int numArgs)
	{
		if(args.length==numArgs)
    	{
    		// Verify if all the arguments are numerics
    		//****************************************
    		boolean num= true;
    		int i=1;
    		while(num && i<numArgs)
    		{
    			num = num && isNumeric(args[i]);
    			i++;
    		}
    		//*****************************************
    		
    		// Verify if the arguments are in the good range
    		//*****************************************
    		boolean range1=false;
    		if (num)
    		{
    			range1=(Integer.parseInt(args[1])<=255 && Integer.parseInt(args[1])>=0);
    			range1=range1 && Integer.parseInt(args[2])<=255 && Integer.parseInt(args[2])>=0;
    			range1=range1 &&Integer.parseInt(args[3])<=255 && Integer.parseInt(args[3])>=0;
    		}
    		
    		if (range1)
    		{
    			for (int k=4;k<numArgs;k++)
    			{
    				range1 = range1 && Double.parseDouble(args[k])<=1 && Double.parseDouble(args[k])>=0;
    			}
    			
    		}        		
    		//*****************************************
    		
    		return (num && range1);
    		
    	}
		else
		{
			return false;
		}				
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNumeric(String str)  
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
	
	

	/**
	 * 
	 * @param ppm
	 */
	public void drawToPixMap(PPM ppm)
	{
		for(Shape s:shapes)
		{
			s.drawTo(ppm);
		}
	}
}

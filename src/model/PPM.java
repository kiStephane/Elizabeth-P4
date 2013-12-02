package model;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
/**
 * 
 * @author Stéphane
 *
 */


public class PPM {
	
	public int HEIGHT;
	public int WIDTH;
	
	final static int MAX_INTENSITY=255;
	
	private ArrayList<ArrayList<Color>> pixels;
	private FileWriter out;
	
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public PPM(int width, int height)
	{
		HEIGHT=height;
		WIDTH= width;
		pixels= new ArrayList<ArrayList<Color>>();
		
		Color c= java.awt.Color.WHITE;
		for (int i=0;i<(height);i++)
		{
			ArrayList<Color> row= new ArrayList<Color>();
			for(int j=0;j<width;j++)
			{
				row.add(c);
			}		
			pixels.add(row);
		}
		
		out= null;
	}
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void writeToFile(String fileName) throws IOException
	{
		try
		{
			out = new FileWriter(fileName); 
		    out.write("P3 \n");
		    out.write(this.WIDTH+" "+this.HEIGHT +" \n"); 
		    out.write(MAX_INTENSITY +" \n"); 
		    
			for (int i=0;i<(HEIGHT);i++)
			{
				ArrayList<Color> row= pixels.get(i);
				for(int j=0;j<WIDTH;j++)
				{
					out.write(String.valueOf(row.get(j).getRed()) +" "+ String.valueOf(row.get(j).getGreen())+" "+String.valueOf(row.get(j).getBlue())+"\n");
				}		
				
			}
		    
		}
		catch (IOException ex)
		{
			throw ex;
		}
		finally
		{
			out.close();
		}
		
		
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @param color
	 */
	public void setPixel(int r, int c,Color color)
	{		
		ArrayList<Color> row= this.pixels.get(r);	
		row.set(c, color);		
	}


}

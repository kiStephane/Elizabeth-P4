/**
 * 
 */
package model;

import java.awt.Color;

/**
 * @author Stéphane
 *
 */
public class Pixel {
	
	private int r;
	
	private int c;
	
	private Color color;
	
	public Pixel (int r, int c, Color color) 
	{
		this.r=r;
		this.c=c;
		this.color= color;
	}
	
	public void setRow(int newRow)
	{
		this.r= newRow;
	}
	
	public void setColumn(int newCol)
	{
		this.c= newCol;
	}
	
	public void setColor(Color color)
	{
		this.color=color;
	}


}

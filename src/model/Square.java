package model;

import java.awt.Color;

public class Square extends Shape{

	
	protected double side;
	
	public Square(Color color, double xPerc, double yPerc ,double side)
	{		
		super(color, xPerc,yPerc);
		this.side=side;
	}
	
	public void drawTo(PPM ppm) 
	{ 
		
	}
	
}

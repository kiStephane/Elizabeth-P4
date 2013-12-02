package model;

import java.awt.Color;

public class Circle extends Shape{

	protected double radius;
	
	public Circle(Color color, double xPerc, double yPerc ,double radius)
	{		
		super(color, xPerc,yPerc);
		this.radius=radius;
	}
	
	public void drawTo(PPM ppm) 
	{ 
		
	}
}

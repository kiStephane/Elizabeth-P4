package model;

import java.awt.Color;

public class Ring extends Shape{
	
	
	protected double innerRadius;
	
	protected double outerRadius;
	
	public Ring(Color color, double xPerc, double yPerc ,double outerRadius,double innerRadius) {
		
		super(color, xPerc,yPerc);
		this.innerRadius=innerRadius;
		this.outerRadius=outerRadius;
	}

	public void drawTo(PPM ppm) 
	{ 
		
	}
}

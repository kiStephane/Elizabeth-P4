package model;

import java.awt.Color;


/**
 * 
 * @author Stéphane
 *
 */
public class Rectangle extends Shape {

	protected double width;
	
	protected double height;
	
	public Rectangle(Color color, double xPerc, double yPerc ,double width,double height) {
		
		super(color, xPerc,yPerc);
		this.width=width;
		this.height=height;
	}


	public void drawTo(PPM ppm) 
	{ 
		int c = (int)(xRatio*ppm.WIDTH); // get x-coord
		int r = (int)(xRatio*ppm.HEIGHT); // get y-coord
	      ppm.setPixel(r, c, color);
	}
	
}

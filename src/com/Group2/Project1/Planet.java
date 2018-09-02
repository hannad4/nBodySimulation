package com.Group2.Project1;
import static java.lang.Math.sqrt;

public class Planet {				// use only for PLANETS
	private double xPos = 0.0; 
	private double yPos = 0.0; 
	private double xVel = 0.0; 
	private double yVel = 0.0; 
	private double mass = 0.0; 
	private String ImgFileName = ""; 

//.......................................................................................................//	
	public void setxPos(double setxPos) {
		xPos = setxPos; 
	}
	
	public double getxPos() {
		return xPos; 
	}
	
//.........................................................................................................//
	public void setyPos(double setyPos) {
		yPos = setyPos; 
	}
	
	public double getyPos() {
		return yPos; 
	}

//..........................................................................................................//
	public void setxVel(double setxVel) {
		xVel = setxVel; 
	}
	
	public double getxVel() {
		return xVel;  
	}

//.................................................................................................................//
	public void setyVel(double setyVel) {
		yVel = setyVel; 
	}
	
	public double getyVel() {
		return yVel; 
	}
	
//.................................................................................................................//
	public void setMass(double setMass) {
		mass = setMass; 
	}
	
	public double getMass() {
		return mass; 
	}

//.................................................................................................................//
	public void setImgFileName(String setImgFileName) {
		ImgFileName = "deathstar"; 
	}
	
	
	public String getImgFileName() {
		return ImgFileName; 
	}
//.................................................................................................................//
	
	public Planet (double xPos, double yPos, double xVel, double yVel, double mass, String ImgFileName) {
		this.xPos = xPos ; 
		this.yPos = yPos ;
		this.xVel = xVel ;
		this.yVel = yVel ; 
		this.mass = mass ; 
		this.ImgFileName = ImgFileName ;
	}
//....................................................................................................................//
	
	public double calcDistance (Planet p1) {
		double xPos = p1.getxPos() ;
		double yPos = p1.getyPos() ;
		
		double xPosition = (this.getxPos() - xPos) * (this.getxPos() - xPos) ; 
		double yPosition = (this.getyPos() - yPos) * (this.getyPos() - yPos); 
		double distance = sqrt((xPosition + yPosition)); 
		return distance; 
	}
//...........................................................................................................................................//	
	
	public double calcForceExertedBy (Planet p2) {
		// You should be calling the calcDistance method in this method
		final double G = 6.67e-11;
		double mass1 = this.mass; 
		double mass2 = p2.getMass(); 
		double dist = calcDistance(p2); 
		
		double forceExertedBy = (G * mass1 * mass2) / (dist * dist) ; 
		return forceExertedBy; 
		
	}
	
//............................................................................................................................................//
	
	public double calcForceExertedByX (Planet p3) {
		double xPos = p3.getxPos(); 
		double dx = xPos - this.xPos; 
		double Force = calcForceExertedBy(p3); 
		double r = calcDistance(p3); 
		
		double forceExertedX = (Force * dx) / r; 
		return forceExertedX; 
	}
	
	
	public double calcForceExertedByY (Planet p3) {
		double yPos = p3.getyPos(); 
		double dy = yPos - this.yPos; 
		double Force = calcForceExertedBy(p3); 
		double r = calcDistance(p3); 
		
		double forceExertedY = (Force * dy) / r; 
		return forceExertedY;
	
	}
//...........................................................................................................................................//	
	public double calcNetForceExertedByX (Planet[] arrayOfPlanets) {
	   double netForceExertedByX = 0.0; 
	   int i = 0; 
	   while (i < arrayOfPlanets.length) {
		   if (!(arrayOfPlanets[i].equals(this))) {
		   netForceExertedByX = netForceExertedByX + this.calcForceExertedByX(arrayOfPlanets[i]); 
		   }
		   i++;
	   }
	   return netForceExertedByX; 
	}
	
	
	public double calcNetForceExertedByY (Planet[] arrayOfPlanets) {
		   double netForceExertedByY = 0.0; 
		   int i = 0; 
		   while (i < arrayOfPlanets.length) {
			   if (!(arrayOfPlanets[i].equals(this))) {
			   netForceExertedByY = netForceExertedByY + this.calcForceExertedByY(arrayOfPlanets[i]); 
			   }
			   i++;
		   }
		   return netForceExertedByY; 
		}
	
//...........................................................................................................................................//	
	public void update (double dt, double xForce, double yForce) {  
	//	Planet p1 = null; 
		double accelForX = xForce / mass; 
		double accelForY = yForce / mass;

		xVel = (xVel + (accelForX * dt)); 
		yVel = (yVel + (accelForY * dt));  
		xPos = (xPos + (xVel * dt)); 
		yPos = (yPos + (yVel * dt)); 
	}
	
	
//...........................................................................................................................................//
	public void draw() {		// main
		StdDraw.picture(getxPos(), getyPos(), "./images/" + getImgFileName()); 
	}


}
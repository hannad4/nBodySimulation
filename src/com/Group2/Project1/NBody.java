package com.Group2.Project1;

public class NBody {
	
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]) ;
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	In in = new In(filename) ;
    	int numPlanets = in.readInt() ;
    	Planet[] planets = new Planet[numPlanets];
    	double uniRad = readRadius(filename);
    	planets = readPlanets(filename);
    	
    	StdDraw.setScale(-uniRad, uniRad);
    	StdDraw.picture(0, 0, "./images/starfield.jpg");
    	Planet[] bodies = NBody.readPlanets(args[2]);
        	
    	for(int i = 0; i < T; i+= dt) {							
    		StdDraw.picture(0, 0, "./images/starfield.jpg");		 
    		for(Planet StdDraw : planets) {
    			double xForce = StdDraw.calcNetForceExertedByX(planets);
    			double yForce = StdDraw.calcNetForceExertedByY(planets);
    			StdDraw.update(dt, xForce, yForce);
    			//StdDraw.draw();
    			
    			
    		}
    		//StdDraw.show(15);
    	}
    	StdOut.printf ("%d\n", bodies.length);
        StdOut.printf ("%.2e\n",uniRad);
         for (int i = 0; i < bodies.length; i++) {
        	StdOut . printf ("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n" 
        			,bodies[i].getxPos() 
        			,bodies[i].getyPos() 
        			,bodies[i].getxVel() 
        			,bodies[i].getyVel() 
        			,bodies[i].getMass() 
        			,bodies[i].getImgFileName() ) ;
        	}
	}
 //.......................................................................................................................................//
	
	public static double readRadius (String pathway) {
		double radius = 0.0; 
		In in = new In(pathway);
		in.readInt();
		radius = in.readDouble(); 
		return radius; 
	}
//........................................................................................................................................//

	public static Planet[] readPlanets (String nameOfFile) {
		In in = new In(nameOfFile); 
		int numPlanets = in.readInt();
		Planet[] planets = new Planet[numPlanets];
		in.readDouble(); 
		
		for (int i = 0; i < numPlanets; i++) {
			planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString()); 
		}
		return planets; 
	}
	  
}
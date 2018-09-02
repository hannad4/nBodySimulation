package com.Group2.Project1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests the Planet constructor.
 */
public class TestPlanetConstructor {

    @Test
    public void checkConstructor() {
      System.out.println("JUnit testing completed.");

      double xPos = 1.0, yPos = 2.0, xVel = 3.0, yVel = 4.0, mass = 5.0;

      String ImgFileName = "jupiter.gif";

      Planet p = new Planet(xPos, yPos, xVel, yVel, mass, ImgFileName);

      assertEquals("xPos = 1.0", xPos, p.getxPos(),0.001);
      assertEquals("yPos = 2.0", yPos, p.getyPos(),0.001);
      assertEquals("xVel = 3.0", xVel, p.getxVel(),0.001);
      assertEquals("yVel = 4.0", yVel, p.getyVel(),0.001);
      assertEquals("mass = 5.0", mass, p.getMass(),0.001);
      assertEquals(ImgFileName, ImgFileName, p.getImgFileName());
  }
}
package org.openscience.cdk.modeling.forcefield;

import java.io.*;
import java.lang.*;
import java.util.*;
import javax.vecmath.*;
import org.openscience.cdk.*;

/**
 *  Steepest Descents Method for optimisation
 *
 *@author     Labarta
 *@created    2004-12-03
 */
public class SteepestDescentsMethod {
	double arbitraryStepSize = 2;
	double stepSize = 2;
	GVector newCoordinates = new GVector(3);
	GVector sk = new GVector(3);


	public SteepestDescentsMethod() {}


	/**
	 *  Constructor for the SteepestDescentsMethod object
	 *
	 *@param  point  Description of the Parameter
	 */
	public SteepestDescentsMethod(GVector point) {
		newCoordinates.setSize(point.getSize());
		sk.setSize(point.getSize());
	}


	/**
	 *  sk=-gK/|gk|
	 *
	 *@param  gK  Description of the Parameter
	 */
	public void setSk(GVector gk) {

		System.out.println("Start sk calculation with gK = " + gk);
		sk.set(gk);
		sk.normalize();
		sk.scale(-1);
		System.out.println("vectorSk : " + sk);
		return;
	}


	/**
	 *  Method useful for Arbitrary Step approach: Compare f(Xk) with f(Xk+1) for
	 *  decide the next step size.
	 *
	 *@param  kPoint              Coordinates of step k
	 *@param  kplus1point         Coordinates of step k+1
	 *@param  forceFieldFunction  Force field function
	 */
	public void setArbitraryStepSize(GVector kPoint, GVector kplus1Point, PotentialFunction forceFieldFunction) {

		System.out.println("f(Xk-1) : " + forceFieldFunction.functionInPoint(kPoint));
		System.out.println("f(Xk) : " + forceFieldFunction.functionInPoint(kplus1Point));
		if (forceFieldFunction.functionInPoint(kplus1Point) < forceFieldFunction.functionInPoint(kPoint)) {
			System.out.println("The energy drops and the arbitrary step size will be increase by 20% to");
			System.out.println("accelerate the convergence");
			arbitraryStepSize = arbitraryStepSize + (arbitraryStepSize * 0.2);
		} else {
			System.out.println("the energy was risen, the minimum was overshot, then the arbitrary step size is halved");
			arbitraryStepSize = arbitraryStepSize / 2;
		}
		System.out.println("Arbitrary step size : " + arbitraryStepSize);
		return;
	}


	/**
	 *  Gets the arbitraryStepSize attribute of the SteepestDescentsMethod object
	 *
	 *@return    The arbitraryStepSize value
	 */
	public double getArbitraryStepSize() {
		return arbitraryStepSize;
	}


	/**
	 *  xk+1= Xk + Lambdak Sk
	 *
	 *@param  oldPoint   Old coordinates of the atoms, k step
	 *@param  stepSizeK  Description of the Parameter
	 *@return            New coordinates of the atoms, k+1 step
	 */
	public GVector newCoordinatesCalculation(GVector oldCoordinates, double stepSizeK) {
		newCoordinates.set(sk);
		newCoordinates.scale(stepSizeK);
		newCoordinates.add(oldCoordinates);
		System.out.println("New coordinates : " + newCoordinates);
		return newCoordinates;
	}


	/**
	 *  Search line approach: Obtain line of search (Interception xk and slope like
	 *  Sk) *** Waiting to be completed completed
	 *
	 *@param  interception          xk
	 *@param  interceptionGradient  Sk
	 *@return                       Description of the Return Value
	 */
	public String searchLine(GVector interception, GVector interceptionGradient) {
		String lineEquation = "";
		// System.out.println("Slope of the line in the direction of the gradient in " + interception + " : " + forceFieldFunction.slopeInPoint(kCoordinates));
		return lineEquation;
	}


	/**
	 *  Search line approach: Look for 3 points along the line where the energy of
	 *  the middle point is lower than the energy of the two outer points ***
	 *  Waiting to be completed
	 *
	 *@param  line  Description of the Parameter
	 *@return       Description of the Return Value
	 */
	public String linePointsSeeking(String line) {

		String lineSegment = "";
		return lineSegment;
	}


	/**
	 *  Search line approach: Minimize The fitted function on the line *** Waiting
	 *  to be completed
	 *
	 *@param  function  Description of the Parameter
	 *@param  segment   Description of the Parameter
	 *@return           Description of the Return Value
	 */
	public Vector minimizeFitFunction(String function, String segment) {

		Vector fitFunctionMinimum = new Vector();
		return fitFunctionMinimum;
	}


	/**
	 *  Search line approach: Fit a function of order p with the three point of the
	 *  line // To check comment *** Waiting to be completed
	 *
	 *@param  point1  Description of the Parameter
	 *@param  point2  Description of the Parameter
	 *@param  point3  Description of the Parameter
	 *@param  order   Description of the Parameter
	 *@return         Description of the Return Value
	 */
	public String fitFunction(Vector point1, Vector point2, Vector point3, byte order) {

		String fitFunctionShape = "";
		return fitFunctionShape;
	}


	/**
	 *  Sets the stepSize attribute of the SteepestDescentsMethod object
	 *
	 *@param  newStepSize  The new stepSize value
	 */
	public void setStepSize(double newStepSize) {
		stepSize = newStepSize;
	}


	/**
	 *  Gets the stepSize attribute of the SteepestDescentsMethod object
	 *
	 *@return    The stepSize value
	 */
	public double getStepSize() {
		return stepSize;
	}


}


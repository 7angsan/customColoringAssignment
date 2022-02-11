package com.example.customcoloringassignment;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * <!-- class CustomElement -->
 * 
 * This class defines an element of a drawing. All such elements must have
 * certain methods and variables to work with this app.
 * 
 * @author Andrew Nuxoll
 * @version Spring 2015
 * 
 */
public abstract class CustomElement {

	public int redValue;
	public int greenValue;
	public int blueValue;

	/**
	 * this is the "fudge factor" for determining whether a tap falls within a
	 * given shape. The value is specified in display pixels (dp)
	 */
	public static final int TAP_MARGIN = 10;

	/** This defines the main color that the element will be drawn with */
	protected Paint myPaint = new Paint();

	/** this color is used to draw outlines around a shape */
	protected Paint outlinePaint = new Paint();

	/** this paint is used to draw highlights */
	protected Paint highlightPaint = new Paint();

	/** a random number generator for changing to a random color */
	protected Random myRand = new Random();

	/**
	 * This gives the element a name for identification. This need not be unique
	 * but it's helpful
	 */
	protected String myName = "$NO NAME$";

	/** the ctor requires that you give the object a name and a color */
	public CustomElement(String name, int color) {
		// init instance variables
		setColor(color);
		this.myName = name;

		// black is an obvious choice for outlines
		this.outlinePaint.setColor(Color.BLACK);
		this.outlinePaint.setStyle(Paint.Style.STROKE);

		// yellow is a good choice for highlighting but, in case the shape is
		// already yellow add a shadow
		this.highlightPaint.setColor(Color.YELLOW);
		this.highlightPaint.setStyle(Paint.Style.STROKE);
		this.highlightPaint.setStrokeWidth(5); // nice wide, visible line
		this.highlightPaint.setShadowLayer(5, 1, 1, Color.MAGENTA);

		// set the color values to the current color
		this.redValue = Color.red(color);
		this.greenValue = Color.green(color);
		this.blueValue = Color.blue(color);
	}

	/** get the element's given name */
	public String getName() {
		return this.myName;
	}

	/** change the color */
	public void setColor(int color) {

		// ignore request if it's not a new color (this keeps the undo queue
		// clean)
		if (color == myPaint.getColor())
			return;

		// make the change
		this.myPaint.setColor(color);
	}

	/**
	 External Citation
	 Date: 9 February 2022
	 Problem: I didn't know how to set color in RGB values instead of Hex.
	 Resource: Classmate: Vincent Robinson
	 Solution: Made setColor functions that set the current color element to the
	 new value and the remaining to the old one.
	 */

	public void setRed(int value) {
		int old = this.myPaint.getColor();
		storeRed(value);
		this.myPaint.setColor(Color.rgb(
				value,
				Color.green(old),
				Color.blue(old)
		));
	}

	public void setGreen(int value) {
		int old = this.myPaint.getColor();
		storeGreen(value);
		this.myPaint.setColor(Color.rgb(
				Color.red(old),
				value,
				Color.blue(old)
		));
	}

	public void setBlue(int value) {
		int old = this.myPaint.getColor();
		storeBlue(value);
		this.myPaint.setColor(Color.rgb(
				Color.red(old),
				Color.green(old),
				value
		));
	}

	public void storeRed(int value) {
		redValue = value;
	}

	public void storeGreen(int value) {
		greenValue = value;
	}

	public void storeBlue(int value) {
		blueValue = value;
	}


	/** get the color */
	public int getColor() {
		return this.myPaint.getColor();
	}

	/** switch to a random color */
	public void setRandomColor() {
		int randColor = Color.rgb(myRand.nextInt(256), myRand.nextInt(256),
				myRand.nextInt(256));
		setColor(randColor);
	}

	/*
	 * ===================================================================
	 * Abstract Methods
	 * -------------------------------------------------------------------
	 */

	/** an element must be able to paint itself */
	public abstract void drawMe(Canvas canvas);

	/**
	 * an element must be able to tell whether a given x,y coordinate falls
	 * within the bounds of its shape. This is used for tap purposes so a tap
	 * that is close to being inside should still count. Use the TAP_MARGIN
	 * constant as a guide for fudge factor. When implementing this method, you
	 * may find the android.graphics.Rect.contains method handy.
	 */
	public abstract boolean containsPoint(int x, int y);

	/** an element must be able to determine its approximate area */
	public abstract int getSize();

	/**
	 * an element can become highlighted. In this case, the element is
	 * responsible for adding a highlight. An easy way to do this is to draw a
	 * bright colored border using {@link #highlightPaint} but you can do what
	 * you like.
	 */
	public abstract void drawHighlight(Canvas canvas);

}// class CustomElement

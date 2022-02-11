package com.example.customcoloringassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * <!-- class BoardView -->
 *
 * This class creates and draws the elements on the SurfaceView.
 * Makes a pizza with toppings along with a napkin.
 * Drawn objects are put inside an ArrayList for ease of drawing and access.
 *
 * @author Steven Lee
 * @version Spring 2022
 *
 */

public class BoardView extends SurfaceView {

    // make an ArrayList of CustomElement objects so they can be draw at once
    private static ArrayList<CustomElement> elements = new ArrayList<CustomElement>();

    private static int currentElement;


    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        // put drawn elements into the ArrayList
        elements.add(new CustomRect("Napkin", 0xFFFFFFFF, 250,300, 450, 600));
        elements.add(new CustomCircle("Crust", 0xFFF7E4C4, 1000, 450, 400));
        elements.add(new CustomCircle("Sauce", 0xFFB21807, 1000, 450, 350));
        elements.add(new CustomCircle("Cheese", 0xFFFFD867, 1000, 450, 320));
        elements.add(new CustomCircle("Pepperoni", 0xFFAA4400, 1200, 500, 80));
        elements.add(new CustomRect("Pineapple", 0xFFFFD964, 800, 580, 900,680));
        elements.add(new CustomCircle("Olive", 0xFF31352E, 1000, 300, 50));
        elements.add(new CustomRect("Green Pepper", 0xFF007D60, 800, 450, 1000, 500));
        currentElement = 0;
    }

    @Override
    public void onDraw(Canvas c) {
        /**
         External Citation
         Date: 8 February 2022
         Problem: Could not draw or access the elements efficiently.
         Resource: Stolen from Dr. Nuxoll's whiteboard.
         Solution: I made an ArrayList of CustomElement and added each
         CustomElement drawing into the ArrayList. I used a for-each loop
         to iterate through every element in the ArrayList.
         */
      for(CustomElement ce: elements) {
          ce.drawMe(c);
      }
        // highlight the pineapple ~~ difficult to see
        elements.get(5).drawHighlight(c);
    }

    // helper methods
    public static ArrayList<CustomElement> getArrayList() {
        return elements;
    }

    public static void setCurrentElement(int index) {
        currentElement = index;
    }

    public static int getCurrentElement() {
        return currentElement;
    }
}

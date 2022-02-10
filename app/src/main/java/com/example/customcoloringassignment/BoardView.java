package com.example.customcoloringassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

public class BoardView extends SurfaceView {

    // make an ArrayList of CustomElement objects so they can be draw at once
    private static ArrayList<CustomElement> elements = new ArrayList<CustomElement>();

    private static int currentElement;


    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        elements.add(new CustomRect("napkin", 0xFFFFFFFF, 250,300, 450, 600));
        elements.add(new CustomCircle("crust", 0xFFF7E4C4, 1000, 450, 400));
        elements.add(new CustomCircle("sauce", 0xFFCC5500, 1000, 450, 350));
        elements.add(new CustomCircle("pepperoni", 0xFFAA4400, 1200, 500, 80));
        elements.add(new CustomRect("pineapple", 0xFFFFD964, 800, 600, 900,700));
        elements.add(new CustomCircle("olive", 0xFF31352E, 1000, 300, 50));
        elements.add(new CustomRect("greenPepper", 0xFF007D60, 800, 450, 1000, 500));
        currentElement = 0;
    }

    @Override
    public void onDraw(Canvas c) {
      for(CustomElement ce: elements) {
          ce.drawMe(c);
          //ce.drawHighlight(c);
      }
    }

    public static ArrayList<CustomElement> getArrayList() {
        return elements;
    }

    public static void setCurrentElement(int index) {
        currentElement = index;
    }
}

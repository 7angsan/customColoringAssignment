package com.example.customcoloringassignment;

import android.graphics.Color;
import android.view.View;

public class BoardModel {
    public int redValue;
    public int greenValue;
    public int blueValue;
    public Color elementColor;
    public CustomElement customElement;

    // get the color of the object
    public void getColors(View element) {
        // how do i use the getColor() method from the CustomElement class on a View?
        //elementColor = (CustomElement)element.getColor();
    }



}

package com.example.customcoloringassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

public class BoardView extends SurfaceView {

    private BoardModel boardModel;
    public CustomElement customEle;
    public CustomElement customEleTwo;
    // make an ArrayList of CustomElement objects so they can be draw at once
    ArrayList<CustomElement> elements;


    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        // draws a pink rectangle
        customEle = new CustomRect("rectOne", 0xFFFFC0CB, 250,250, 800, 800);
        customEle = new CustomCircle("circleOne", 0xFF00FF00, 500, 800, 100);
        elements.add(customEle);
        elements.add(customEleTwo);
    }

    @Override
    public void onDraw(Canvas c) {
        for(CustomElement ce: elements) {
            ce.drawMe(c);
        }
    }

    public BoardModel getBoardModel() { return boardModel; }
}

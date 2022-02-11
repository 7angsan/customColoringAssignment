package com.example.customcoloringassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class MainActivity -->
 *
 * This class creates objects and links them to their appropriate ID.
 * Additionally, these objects use their appropriate listener functions to test for changes of their current state.
 * The most notable functions being: setting the progress of the seekbar according to the color displayed on the object,
 * And changing the color of the object by sliding the seekbar.
 *
 * @author Steven Lee
 * @version Spring 2022
 *
 */

public class MainActivity extends AppCompatActivity {

    BoardView boardView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);

        /**
         External Citation
         Date: 9 February 2022
         Problem: I couldn't figure out how to set the progress of each of the seekbars.
         Resource: https://stackoverflow.com/questions/32354069/how-to-give-number-of-seekbar-on-android
         Solution: I used the example code from this post.
         */

        SeekBar changeRed = findViewById(R.id.redBar);
        TextView redNum = findViewById(R.id.redValue);
        // listener for red seek bar
        changeRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                boardView.getArrayList().get(boardView.getCurrentElement()).setRed(progressValue);
                // crashes if I don't add a string for some reason
                redNum.setText(progressValue + "");
                boardView.invalidate();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar changeGreen = findViewById(R.id.greenBar);
        TextView greenNum = findViewById(R.id.greenValue);
        // listener for green seek bar
        changeGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                // Get the element at currentElement and use CustomElement.setGreen(progressValue)
                boardView.getArrayList().get(boardView.getCurrentElement()).setGreen(progressValue);
                greenNum.setText(progressValue + "");
                boardView.invalidate();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar changeBlue = findViewById(R.id.blueBar);
        TextView blueNum = findViewById(R.id.blueValue);
        // listener for blue seekbar
        changeBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                boardView.getArrayList().get(boardView.getCurrentElement()).setBlue(progressValue);
                blueNum.setText(progressValue + "");
                boardView.invalidate();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        TextView element = findViewById(R.id.element);
        // anonymous class onTouchListener
        boardView.setOnTouchListener(
                new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        // Search through the ArrayList and use CustomElement.containsPoint()
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();

                        int count = 0;
                        // If element doesn't contain point, increment by 1
                        // Once you find it, set that index to currentElement in BoardView
                        for (CustomElement ce: boardView.getArrayList()) {
                            if (ce.containsPoint(x,y)) {
                                boardView.setCurrentElement(count);
                                element.setText(ce.getName());
                                changeRed.setProgress(ce.redValue);
                                changeGreen.setProgress(ce.greenValue);
                                changeBlue.setProgress(ce.blueValue);
                            }
                            count++;
                        }
                        boardView.invalidate();
                        return false;
                    }
                } );
    }
}
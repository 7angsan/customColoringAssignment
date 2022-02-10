package com.example.customcoloringassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BoardView boardView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);
        SeekBar changeRed = findViewById(R.id.redBar);
        TextView redNum = findViewById(R.id.redValue);
        changeRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                // crashes if I don't add a string
                redNum.setText(progressValue + "");
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
        changeGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                // Get the element at currentElement and use CustomElement.setGreen(progressValue)

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
        changeBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                blueNum.setText(progressValue + "");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // anonymous class with listener
        boardView.setOnTouchListener(
                new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        // Search through the ArrayList and use CustomElement.containsPoint
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();

                        int count = 0;
                        // if element doesn't contain point, increment by 1
                        for (CustomElement ce: boardView.getArrayList()) {
                            if (ce.containsPoint(x,y)) {
                                boardView.setCurrentElement(count);
                            }
                            count++;
                        }

                        // Once you find it, set that index to currentElement in BoardView

                        return false;
                    }
                } );
    }

}
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
    int redProgressValue;
    int greenProgressValue;
    int blueProgressValue;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);
        SeekBar changeRed = findViewById(R.id.redBar);
        TextView redNum = findViewById(R.id.redValue);
        changeRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            MainActivity mainActivity;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                // crashes if I don't add a string
                boardView.getArrayList().get(boardView.getCurrentElement()).setRed(progressValue);
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
        changeGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            MainActivity mainActivity;
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
        changeBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            MainActivity mainActivity;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                boardView.getArrayList().get(boardView.getCurrentElement()).setGreen(progressValue);
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
                                element.setText(ce.getName());
                                changeRed.setProgress(ce.redValue);
                                changeGreen.setProgress(ce.greenValue);
                                changeBlue.setProgress(ce.blueValue);
                            }
                            count++;
                        }
                        boardView.invalidate();
                        // Once you find it, set that index to currentElement in BoardView
                        return false;
                    }
                } );
    }

}
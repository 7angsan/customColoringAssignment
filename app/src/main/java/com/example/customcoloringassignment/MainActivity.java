package com.example.customcoloringassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BoardView boardView;
    BoardController boardController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);
        boardController = new BoardController(boardView);
        //boardView.setOnTouchListener(boardController);
        SeekBar changeRed = findViewById(R.id.redBar);
        TextView redNum = findViewById(R.id.redValue);
        changeRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                redNum.setText(progress + "/" + seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                redNum.setText(progress + "/" + seekBar.getMax());
            }
        });
        SeekBar changeGreen = findViewById(R.id.greenBar);
        TextView greenNum = findViewById(R.id.greenValue);
        changeGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                greenNum.setText(progress + "/" + seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                greenNum.setText(progress + "/" + seekBar.getMax());
            }
        });
        changeGreen.setOnSeekBarChangeListener(boardController);
        SeekBar changeBlue = findViewById(R.id.blueBar);
        TextView blueNum = findViewById(R.id.greenValue);
        changeBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                blueNum.setText(progress + "/" + seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blueNum.setText(progress + "/" + seekBar.getMax());
            }
        });
        changeBlue.setOnSeekBarChangeListener(boardController);

        // anonymous class with listener
        boardView.setOnTouchListener(
                new View.OnTouchListener() {
                    int color = 0;
                    int red = 0;
                    int green = 0;
                    int blue = 0;

                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();

                        return false;
                    }
                } );
    }

}
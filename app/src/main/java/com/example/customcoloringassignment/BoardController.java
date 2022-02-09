package com.example.customcoloringassignment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class BoardController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private BoardView boardView;
    private BoardModel boardModel;

    public BoardController(BoardView ref) {
        boardView = ref;
        boardModel = boardView.getBoardModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boardModel.getColors(view);
        boardView.invalidate();
        return true;
    }
}

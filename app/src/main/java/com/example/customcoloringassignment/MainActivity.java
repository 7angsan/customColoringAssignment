package com.example.customcoloringassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BoardView boardView;
    BoardController boardController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);
        boardController = new BoardController(boardView);

    }


}
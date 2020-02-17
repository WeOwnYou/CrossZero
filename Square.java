package com.example.client;

import android.widget.ImageView;

public class Square {
    private boolean isPressed;
    private ImageView imageView;
    private int numberOfSquare;

    Square(ImageView imageView, int numberOfSquare){
        this.imageView=imageView;
        isPressed=false;
        this.numberOfSquare = numberOfSquare;
    }

    boolean isPressed() {
        return isPressed;
    }

    void setPressed() {
        isPressed = true;
    }

    ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getNumberOfSquare() {
        return numberOfSquare;
    }
}

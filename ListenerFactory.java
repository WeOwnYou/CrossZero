package com.example.client;

import android.view.View;
import android.widget.ImageView;

class ListenerFactory {

    public static class ClickListener implements View.OnClickListener{

        private ImageView imageView;
        private boolean howChanging;
        private CrossZero game;
        private Square square;

        private ClickListener(Square square, CrossZero game){
            this.imageView = square.getImageView();
            this.game = game;
            this.square = square;
        }

        @Override
        public void onClick(View v) {
            if(game.isMyTurn() && !square.isPressed()){
                if(game.isFirst())
                    square.getImageView().setImageResource(R.drawable.cross);
                else
                    square.getImageView().setImageResource(R.drawable.cross);
                square.setPressed();
//                game.setMyTurn(false);
                game.setWichSquareIsPressed(square.getNumberOfSquare());
//                v.getId();
            }else
                System.out.println("Pressed already");

        }
    }
        static ClickListener ListenerMaker(Square square, CrossZero game){
            ClickListener result = null;
            result = new ClickListener(square, game);
            return result;
    }
}

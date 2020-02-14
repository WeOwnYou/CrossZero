package com.example.client;

import android.view.View;
import android.widget.ImageView;

class ListenerFactory {

    public static class ClickListener implements View.OnClickListener{

        private ImageView imageView;
        private boolean howChanging;
        private CrossZero game;

        private ClickListener(ImageView imageView, CrossZero game){
            this.imageView = imageView;
            this.game = game;
        }

        @Override
        public void onClick(View v) {
            if(game.isMyTurn())
                if(game.isFirst())
                    imageView.setImageResource(R.drawable.cross);
                else
                    imageView.setImageResource(R.drawable.zero);
        }
    }
        static ClickListener ListenerMaker(ImageView imageView, CrossZero game){
            ClickListener result = null;
            result = new ClickListener(imageView, game);
            return result;
    }
}

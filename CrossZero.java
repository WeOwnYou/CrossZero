package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class CrossZero extends AppCompatActivity {
    private final ArrayList<Square> holes = new ArrayList<>();
    private boolean isMyTurn = false;
    private boolean isFirst = false;
    private boolean isFilled = false;
    private int wichSquareIsPressed = 0;

    public ImageView imageView(){
        return (ImageView) findViewById(R.id.imageView9);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_zero);

        MultiThreadFactory.ClientThread ct = new MultiThreadFactory.ClientThread(this);
        ct.start();
        MultiThreadFactory.ServerThread st = new MultiThreadFactory.ServerThread(this);
        st.start();

        setTable();
        setListenerOnTable();
    }



    protected void setTable(){
//        Script manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("js");
//        Object result = engine.eval("4*5");

        holes.add(new Square((ImageView) findViewById(R.id.imageView1),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView2),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView3),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView4),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView5),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView6),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView7),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView8),holes.size()+1));
        holes.add(new Square((ImageView) findViewById(R.id.imageView9),holes.size()+1));

    }

    protected void setListenerOnTable(){
        for(int i=0;i < holes.size();i++) {
            holes.get(i).getImageView().setOnClickListener(ListenerFactory.ListenerMaker(holes.get(i),this));
        }
    }

    public boolean isMyTurn() {
        return isMyTurn;
    }

    public void setMyTurn(boolean myTurn) {
        isMyTurn = myTurn;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
        isMyTurn = first;
    }
    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public int getWichSquareIsPressed() {
        return wichSquareIsPressed;
    }

    public void setWichSquareIsPressed(int wichSquareIsPressed) {
        this.wichSquareIsPressed = wichSquareIsPressed;
    }
}
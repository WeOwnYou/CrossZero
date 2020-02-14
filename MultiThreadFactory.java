package com.example.client;

import java.io.IOException;

class MultiThreadFactory {

    public static class ClientThread extends Thread{
        CrossZero game;
        ClientThread(CrossZero game){
            this.game=game;
        }
        public void run(){
            super.run();
            try {
                Client client = new Client(game);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class ServerThread extends Thread{
        CrossZero game;
        ServerThread(CrossZero game){
            this.game = game;
        }
        public void run(){
            super.run();
            try {
                Server server = new Server(game);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

package com.example.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

class Client {

    private DatagramSocket ds = null;
    private String address = "192.168.43.";
    private CrossZero game;

    Client(CrossZero game) throws IOException, InterruptedException {
        this.game = game;
        searchingClient();
    }

    private void searchingClient() throws IOException, InterruptedException {
        int timeout = 100;
            int port = 8000;
            for(int i = 0;i<255;i++){
                if(InetAddress.getByName(address+i).isReachable(timeout) && address + i!=InetAddress.getLocalHost().toString()){// && i!=138 178 ){
                    address += i;
                    System.out.println(InetAddress.getLoopbackAddress());
                    break;

                }
            }
            InetAddress ipAddress = InetAddress.getByName(address); //+ i);
//            Thread.sleep(10);
            Socket socket = new Socket(ipAddress, port);
            mainClient(socket);
    }

    private void mainClient(Socket socket) throws IOException {
        boolean running = true;
        System.out.println(socket.getLocalAddress() + "  Opa  " + socket.getInetAddress());
        OutputStream os = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(os);
        while(running) {
//            if(game.isTurnCompleted())
            if(game.getWichSquareIsPressed()!=0 && game.isMyTurn()) {
                out.writeUTF(""+game.getWichSquareIsPressed());
                game.setWichSquareIsPressed(0);
                game.setMyTurn(false);
                System.out.println("Otpr");
            }
        }
    }
}
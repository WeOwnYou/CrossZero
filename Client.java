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
//        while (true) {
//            InetAddress ipAddress = InetAddress.getByName("192.168.43.229"); //+ i);
            int port = 8000;
            for(int i = 0;i<255;i++){
                if(InetAddress.getByName(address+i).isReachable(timeout)){// && i!=138  ){
                    address += i;
                    break;
//                    System.out.println(i + " Reached");

                }
                else
                    System.out.print(i + " ");
            }
            InetAddress ipAddress = InetAddress.getByName(address); //+ i);
            Thread.sleep(500);
            Socket socket = new Socket(ipAddress, port);
            mainClient(socket);
//            OutputStream os = socket.getOutputStream();
//            DataOutputStream out = new DataOutputStream(os);
//            out.writeUTF("Pizda 123");
//        }
    }

    private void mainClient(Socket socket) throws IOException {
        boolean running = true;
        System.out.println("Opa");
        OutputStream os = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(os);
        while(running) {
            if(game.isTurnCompleted())
            out.writeUTF("Pizda 123");
        }
    }

}

package com.example.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    private CrossZero game;
    Server(CrossZero game) throws IOException {
        this.game = game;
        searchingServer();
    }

    private void searchingServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Ожидающий сокет");
        Socket socket = serverSocket.accept();
        System.out.println("Конект. Готов считать");
//        InputStream is = socket.getInputStream();
//        DataInputStream in = new DataInputStream(is);
//        String line = null;
//        line = in.readUTF();
//        System.out.println(line);
        mainServer(socket);
    }

    private void mainServer(Socket socket) throws IOException {
        System.out.println("Ops");
        boolean running = true;
        InputStream is = socket.getInputStream();
        DataInputStream in = new DataInputStream(is);
        String line = null;
//        while (running) {
        System.out.println(socket.getLocalAddress() + "!!");
        System.out.println(socket.getInetAddress() + "??");
        if (socket.getLocalAddress().toString().compareTo(socket.getInetAddress().toString()) < 0){
            System.out.println("Yes");
            game.setFirst(true);
        }else {
            game.setFirst(false);
            System.out.println("Ne");
        }
//            line = in.readUTF();
//            System.out.println(line);
    }
}
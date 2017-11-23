package com.klymenko;

import java.net.*;


public class ServerApp {

    public static void main(String[] args) throws SocketException {
        if(args.length != 1) throw new IllegalArgumentException("You need to specify file name as a program argument!");
        new Thread(new Server(args[0])).start();
    }
}
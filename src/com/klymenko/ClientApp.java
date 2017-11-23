package com.klymenko;

import java.net.*;

public class ClientApp {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        if(args.length != 1) throw new IllegalArgumentException("You need to specify file name as a program argument!");
        new Thread(new Client(args[0])).start();
    }
}
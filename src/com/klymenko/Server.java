package com.klymenko;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server implements Runnable {

    private static final int DATAGRAM_PORT = 10000;

    private static final int PCKG_SIZE = 1024;

    private final String FILE_NAME;

    public Server(String fileName) {
        FILE_NAME = fileName;
    }

    public void run() {
        try(FileOutputStream os = new FileOutputStream(new File(FILE_NAME))) {
            DatagramSocket serverSocket = new DatagramSocket(DATAGRAM_PORT);
            while(true) {
                byte[] in = new byte[PCKG_SIZE];
                DatagramPacket receivedPacket = new DatagramPacket(in, in.length);
                serverSocket.receive(receivedPacket);
                os.write(receivedPacket.getData());
                os.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
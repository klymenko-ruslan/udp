package com.klymenko;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client implements Runnable{

    private static final int DATAGRAM_PORT = 10000;

    private static final int PCKG_SIZE = 1024;

    private final String FILE_NAME;

    public Client(String fileName) {
        FILE_NAME = fileName;
    }

    public void run() {
        try(FileInputStream fr = new FileInputStream(new File(FILE_NAME))) {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] outData = new byte[PCKG_SIZE];
            while (fr.read(outData) != -1) {
                DatagramPacket out = new DatagramPacket(outData, outData.length, IPAddress, DATAGRAM_PORT);
                clientSocket.send(out);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
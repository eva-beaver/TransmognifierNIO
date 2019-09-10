package com.nio.blocking;

import javax.management.PersistentMBean;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NastyChump {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");

        Socket[] socket = new Socket[3000];

        for (int i = 0; i < socket.length; i++) {
            try {
                socket[i] = new Socket("localhost", 8080);
                System.out.println("New socket connection on port 8080 ...." + i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(100_000);
    }

}

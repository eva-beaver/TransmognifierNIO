package com.nio.blocking.server;

import com.nio.blocking.handler.TransmogrifyHandler;
import com.nio.blocking.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiiThreededBlockingSever {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept();

            handle(s);

            //in.transferTo(op);
        }
    }

    private static void handle(Socket s) throws IOException {

        new Thread(() -> {
            System.out.println("Connected to " + s);

            try {
                new TransmogrifyHandler().handle(s);
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            } finally {
                System.out.println("Disonnected from " + s);
            }
        }).start();
    }

}

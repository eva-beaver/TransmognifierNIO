package com.nio.blocking.server;

import com.nio.blocking.handler.PrintingHandler;
import com.nio.blocking.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreededBlockingSever {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept();

            handle(s);

            //in.transferTo(op);
        }
    }

    private static void handle(Socket s) throws IOException {

        new PrintingHandler<>(
                new TransmogrifyHandler()
        ).handle(s);

    }

}

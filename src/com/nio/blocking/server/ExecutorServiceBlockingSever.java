package com.nio.blocking.server;

import com.nio.blocking.handler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorServiceBlockingSever {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);

        Handler<Socket> handler =
             new ExecutorServiceHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                ),
                     Executors.newFixedThreadPool(10),
                     (t, e) -> System.out.println("uncaught: " + t + " error " + e)
        );

        while (true) {
            Socket s = ss.accept();

            handler.handle(s);

        }
    }

}

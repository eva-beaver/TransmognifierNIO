package com.nio.blocking.server;

import com.nio.blocking.handler.*;
import com.nio.blocking.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingSever {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);

        Handler<Socket> handler =
             new ThreadedHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                )
        );

        while (true) {
            Socket s = ss.accept();

            handler.handle(s);

        }
    }

}

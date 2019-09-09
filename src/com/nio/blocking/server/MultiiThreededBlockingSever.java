package com.nio.blocking.server;

import com.nio.blocking.handler.Handler;
import com.nio.blocking.handler.PrintingHandler;
import com.nio.blocking.handler.TransmogrifyHandler;
import com.nio.blocking.handler.UncheckedIOExceptionConverterHandler;
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

        UncheckedIOExceptionConverterHandler<Socket> handler =
             new UncheckedIOExceptionConverterHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                )
        );

        while (true) {
            Socket s = ss.accept();

            new Thread(() -> handler.handle(s)).start();

        }
    }

}

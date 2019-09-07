package com.nio.blocking.server;

import util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        System.out.println("Connected to " + s);

        try (
                s;
                InputStream in = s.getInputStream();
                OutputStream op =s.getOutputStream()
        ) {
       int data;
        while ((data = in.read()) != -1) {
            op.write(Util.transmogrify(data));
        }
        } finally {
            System.out.println("Disonnected from " + s);
        }
   }

}

package com.nio.blocking.handler;

import com.nio.blocking.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TransmogrifyHandler implements Handler<Socket> {

    @Override
    public void handle(Socket s) throws IOException {

        try (
            s;
            InputStream in = s.getInputStream();
            OutputStream op = s.getOutputStream()
        ) {
            int data;
            while ((data = in.read()) != -1) {
                if (data == '%') throw new IOException(("oppsie"));
                op.write(Util.transmogrify(data));
            }
        }

    }
}

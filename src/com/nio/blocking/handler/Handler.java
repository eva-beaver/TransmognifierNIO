package com.nio.blocking.handler;

import java.io.IOException;

// Decorator
public interface Handler<S> {

    void handle(S s) throws IOException;

}

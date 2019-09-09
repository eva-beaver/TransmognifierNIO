package com.nio.blocking.handler;

public class ThreadedHandler<S> extends UncheckedIOExceptionConverterHandler<S> {

    public ThreadedHandler(Handler<S> other) {
        super(other);
    }

    public void handle(S s) {
        new Thread(() -> super.handle(s)).start();
    }

}

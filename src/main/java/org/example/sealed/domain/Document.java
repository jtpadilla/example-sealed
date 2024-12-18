package org.example.sealed.domain;

import java.util.concurrent.atomic.AtomicInteger;

public abstract sealed class Document permits Albaran, Factura, Recibo, InvalidDocument {

    final static private AtomicInteger counter = new AtomicInteger();

    final int id;

    public Document() {
        this.id = counter.incrementAndGet();
    }

    public int getId() {
        return id;
    }

}

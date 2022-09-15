package misiniciosenjava;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter implements Counter {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public int increaseAndGet() {
        return counter.incrementAndGet();
    }

    @Override
    public int peekCounter() {
        return counter.get();
    }
}

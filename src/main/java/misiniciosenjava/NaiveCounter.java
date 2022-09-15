package misiniciosenjava;

public class NaiveCounter implements Counter {
    private int counter;

    @Override
    public int increaseAndGet() {
        return ++counter;
    }

    @Override
    public int peekCounter() {
        return counter;
    }
}

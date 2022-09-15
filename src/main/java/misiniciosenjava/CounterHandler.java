package misiniciosenjava;

import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
public class CounterHandler implements Callable<Integer>{

    private final Counter counter;
    public CounterHandler(Counter counter) {
        this.counter = counter;
    }
    @Override
    public Integer call() {
        return counter.increaseAndGet();        
    }

}

package misiniciosenjava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreadSafeCounterTest {

    private final ThreadSafeCounter concurrentCounter = new ThreadSafeCounter();

    @Test(threadPoolSize = 4, invocationCount = 2000)
    public void shouldIncreaseCounter() {
        Thread.yield();

        CounterHandler handler = new CounterHandler(concurrentCounter);
        Integer result = handler.call();
        Assert.assertTrue(result > 0);
    }

    @Test(dependsOnMethods = {"shouldIncreaseCounter"})
    public void shouldBe2000() {
        Assert.assertEquals(concurrentCounter.peekCounter(), 2000);
    }
}

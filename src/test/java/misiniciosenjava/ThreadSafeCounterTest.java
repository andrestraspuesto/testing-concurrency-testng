package misiniciosenjava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreadSafeCounterTest {

    private final ThreadSafeCounter concurrentCounter = new ThreadSafeCounter();

    @Test(threadPoolSize = 10, invocationCount = 100)
    public void shouldIncreaseCounter()
    {
        CounterHandler handler = new CounterHandler(concurrentCounter);
        Integer result = handler.call();
        Assert.assertTrue(result > 0);
    }

    @Test(dependsOnMethods = {"shouldIncreaseCounter"})
    public void shouldBe100() {
        Assert.assertEquals(concurrentCounter.peekCounter(), 100);
    }
}

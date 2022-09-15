package misiniciosenjava;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NaiveCounterTest 
{
    private final NaiveCounter naiveCounter = new NaiveCounter();

    @Test(threadPoolSize = 4, invocationCount = 2000)
    public void shouldIncreaseCounter() {
        Thread.yield();
        
        CounterHandler handler = new CounterHandler(naiveCounter);
        Integer result = handler.call();
        Assert.assertTrue(result > 0);
    }

    @Test(dependsOnMethods = {"shouldIncreaseCounter"})
    public void shouldBe100() {
        Assert.assertEquals(naiveCounter.peekCounter(), 2000);
    }
}

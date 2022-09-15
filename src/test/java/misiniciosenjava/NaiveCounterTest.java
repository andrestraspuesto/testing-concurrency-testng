package misiniciosenjava;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NaiveCounterTest 
{
    private final NaiveCounter naiveCounter = new NaiveCounter();

    @Test(threadPoolSize = 10, invocationCount = 100)
    public void shouldIncreaseCounter()
    {
        CounterHandler handler = new CounterHandler(naiveCounter);
        Integer result = handler.call();
        Assert.assertTrue(result > 0);
    }

    @Test(dependsOnMethods = {"shouldIncreaseCounter"})
    public void shouldBe100() {
        Assert.assertEquals(naiveCounter.peekCounter(), 100);
    }
}

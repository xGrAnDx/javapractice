package ru.grand.lesson4t12;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Producer {
    public static void payload(PrinterWrapper wrapper) throws InterruptedException {
        while (true)        {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextLong(6) + 2);
            wrapper.print();
        }
    }

}

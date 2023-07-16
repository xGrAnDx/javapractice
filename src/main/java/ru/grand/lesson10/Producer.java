package ru.grand.lesson10;

import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    public static boolean shouldRun = true;
    public static int generated = 0;

    private Object mutex;

    public Producer(Object mutex)
    {
        this.mutex = mutex;
    }
    @SneakyThrows
    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            sleep(10000);
            generated = ThreadLocalRandom.current().nextInt(1000);
            synchronized (mutex) {
                mutex.notifyAll();
            }
        }

        shouldRun = false;
    }
}

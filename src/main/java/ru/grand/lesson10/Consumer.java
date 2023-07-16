package ru.grand.lesson10;

import lombok.SneakyThrows;

public class Consumer implements Runnable {
    private Object mutex;

    public Consumer(Object mutex)
    {
        this.mutex = mutex;
    }
    @SneakyThrows
    @Override
    public void run() {
        synchronized (mutex) {
            while (Producer.shouldRun) {
                mutex.wait();
                System.out.println(Thread.currentThread().getName() + " " + Producer.generated);
            }
        }
    }
}

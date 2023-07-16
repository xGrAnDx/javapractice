package ru.grand.lesson10;

import lombok.SneakyThrows;

public class AlphabetThread implements Runnable {

    public static Object mutex = new Object();
    private static int counter = 0;
    private int letterCounter = 0;
    private final int threadId;

    static synchronized void increment(){
        counter = (counter + 1) % AlphabetPrinter.alphaSize;
    }

    public AlphabetThread(int threadId)
    {
        this.threadId = threadId;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(true)
        {
            synchronized (mutex) {
                if (counter != threadId) {
                    mutex.wait();
                } else {
                    System.out.print((char)('a' + threadId));
                    letterCounter++;
                    increment();
                    mutex.notifyAll();
                    if (letterCounter == AlphabetPrinter.letterCount) {
                        break;
                    }
                }
            }
        }
    }
}

package ru.grand.lesson4t12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Emulator {

    private static int threadCount = 10;
    public static void main(String[] args) {
        var printer = new Printer();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0; i<threadCount; i++)
        {
            var wrapper = new PrinterWrapper(printer);
            executorService.execute(() -> {
                try {
                    Producer.payload(wrapper);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}

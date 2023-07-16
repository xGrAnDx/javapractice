package ru.grand.lesson10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AlphabetPrinter {
    public static final int alphaSize = 5;
    public static final int letterCount = 8;

    private ExecutorService execService;

    public void run()
    {
        this.execService = Executors.newFixedThreadPool(AlphabetPrinter.alphaSize);

        for(int i=0;i<AlphabetPrinter.alphaSize; i++)
        {
            this.execService.execute(new AlphabetThread(i));
        }

        this.execService.shutdown();
    }

}

package ru.grand.lesson10;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.min;

public class ParallerSummator {
    private static final int arraySize = 100000;
    private static final int threadCount = 5;

    private int[] intArray;

    public void init(){
        this.intArray = new int[arraySize];
        for (int i=0;i<arraySize;i++)
        {
            this.intArray[i] = i%5;
        }
    }

    @SneakyThrows
    public Integer getSum()
    {
        var execService = Executors.newFixedThreadPool(threadCount);
        var completionService =
                new ExecutorCompletionService<Integer>(execService);

        var batchSize = arraySize / threadCount;

        for (int i=0;i<threadCount;i++)
        {
            var start = batchSize * i;
            var end = min(batchSize * (i+1), arraySize);

            var toCalc = Arrays.copyOfRange(this.intArray, start, end);

            completionService.submit(new CalcThread(toCalc));
        }

        var received = 0;
        boolean errors = false;
        var total = 0;

        while(received < threadCount && !errors) {
            Future<Integer> resultFuture = completionService.take(); //blocks if none available
            try {
                var futureResult = resultFuture.get();
                total += futureResult;
                received ++;
            }
            catch(Exception e) {
                //log
                errors = true;
            }
        }

        execService.shutdown();

        return total;
    }
}

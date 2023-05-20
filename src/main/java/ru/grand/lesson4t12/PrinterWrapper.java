package ru.grand.lesson4t12;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ArrayBlockingQueue;

@AllArgsConstructor
public class PrinterWrapper implements IPrinter{

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static ArrayBlockingQueue<LocalDateTime> callQueue = new ArrayBlockingQueue<>(10);
    private Printer inner;

    public void print()
    {
        var head = callQueue.peek();
        var callTime = LocalDateTime.now();

        if (head != null && ChronoUnit.SECONDS.between(head, callTime) > 60) {
            callQueue.remove();
        }

        if (callQueue.offer(callTime))
        {
            inner.print();
        }
        else
            System.out.format("Call was skipped:[%s]\n", dtf.format(LocalDateTime.now()));
    }
}

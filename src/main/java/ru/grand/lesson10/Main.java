package ru.grand.lesson10;

public class Main {


    public static void main(String[] args) {
        //threadSyncDemo();
        //executionServiceDemo();
        consumerProducerDemo();
    }

    public static void threadSyncDemo()
    {
        var printer = new AlphabetPrinter();
        printer.run();
    }

    public static void executionServiceDemo()
    {
        var summator = new ParallerSummator();
        summator.init();
        System.out.println(summator.getSum());
    }

    public static void consumerProducerDemo()
    {
        var mutex = new Object();
        new Thread(new Producer(mutex)).start();

        for(int i=0; i<5;i++)
        {
            new Thread(new Consumer(mutex)).start();
        }
    }
}

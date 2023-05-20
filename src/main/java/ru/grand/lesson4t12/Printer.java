package ru.grand.lesson4t12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Printer implements IPrinter {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    public void print()
    {
        System.out.format("Print method was called: [%s]\n", dtf.format(LocalDateTime.now()));
    }
}

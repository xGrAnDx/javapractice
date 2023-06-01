package ru.grand.lesson6;

public class SizeArrayException extends Exception{
    public SizeArrayException(int size)
    {
        super(String.format("Input arrays has incorrect size: [%s].", size));
    }
}

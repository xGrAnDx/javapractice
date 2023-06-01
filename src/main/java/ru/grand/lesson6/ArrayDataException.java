package ru.grand.lesson6;

public class ArrayDataException extends Exception{
    public ArrayDataException(String data, int row, int column)
    {
        super(String.format("Cell contains incorrect data: [%s]. Coordinates: [%s, %s].", data, row, column));
    }
}

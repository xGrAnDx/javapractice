package ru.grand.lesson10;

import java.util.concurrent.Callable;

public class CalcThread implements Callable<Integer> {
    private int[] toCalc;

    public CalcThread(int[] toCalc)
    {
        this.toCalc = toCalc;
    }

    @Override
    public Integer call()
    {
        var total = 0;
        for(int i=0;i<toCalc.length; i++)
        {
            total += toCalc[i];
        }

        return total;
    }
}

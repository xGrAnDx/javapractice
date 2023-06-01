package ru.grand.lesson5.dumpdemo;

import java.util.ArrayList;

public class MemHeavy {
    private ArrayList<String> KindaBig = new ArrayList<>();

    private ArrayList<Integer> KindaBigToo = new ArrayList<>();

    public MemHeavy()
    {
        for(int i=0;i<300;i++)
        {
            var str = new String("sample");
            this.KindaBig.add(str);

            var refInt = 10;

            this.KindaBigToo.add(refInt);
        }
    }
}

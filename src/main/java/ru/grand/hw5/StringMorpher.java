package ru.grand.hw5;

public class StringMorpher {
    private int maskLength;

    public StringMorpher(int strL)
    {
        if (strL <= 0)
        {
            throw new IllegalArgumentException();
        }

        this.maskLength = strL;
    }

    public String applyMask(int applyTo)
    {
        if (applyTo < 0)
        {
            throw new IllegalArgumentException();
        }

        var numStr = Integer.toString(applyTo);

        if (numStr.length() >= this.maskLength)
        {
            return numStr;
        }

        return String.format("%0" + maskLength + "d", applyTo);
    }
}

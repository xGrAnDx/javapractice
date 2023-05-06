package ru.grand.hw5;

import java.util.Objects;

public class jdkClass {
    private int tempField;

    public jdkClass(int f)
    {
        tempField = f;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        jdkClass jdkClass = (jdkClass) o;
        return tempField == jdkClass.tempField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempField);
    }
}

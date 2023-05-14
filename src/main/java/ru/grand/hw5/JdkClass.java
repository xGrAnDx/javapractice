package ru.grand.hw5;

import java.util.Objects;

public class JdkClass {
    private int tempField;

    public JdkClass(int f)
    {
        tempField = f;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdkClass jdkClass = (JdkClass) o;
        return tempField == jdkClass.tempField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempField);
    }
}

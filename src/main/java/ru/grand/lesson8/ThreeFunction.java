package ru.grand.lesson8;

@FunctionalInterface
public interface ThreeFunction<T1, T2, T3, R> {
    R execute(T1 p1, T2 p2, T3 p3);
}

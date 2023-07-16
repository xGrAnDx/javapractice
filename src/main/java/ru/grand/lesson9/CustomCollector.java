package ru.grand.lesson9;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<String, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sum, element) -> {
            if (element.length() < 10)
            {
                if (sum == null)
                {
                    sum.append(element);
                }
                else if (element.length() > sum.length())
                {
                    sum.setLength(0);
                    sum.append(element);
                }
            }
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (x, y)->null;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (x) -> {
            if (x.isEmpty())
            {
                return "null";
            }
            else
            {
                return x.toString();
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}

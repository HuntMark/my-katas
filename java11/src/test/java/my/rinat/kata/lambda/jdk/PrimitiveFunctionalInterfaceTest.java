package my.rinat.kata.lambda.jdk;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

class PrimitiveFunctionalInterfaceTest {
    @Test
    void IntConsumer() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                adder.add((long) value);
            }
        };
        IntStream.rangeClosed(1, 5).forEach(consumer);
        // fixme:
        // Assert.assertEquals(15, adder.longValue());
    }

    @Test
    void LongConsumer() {
        var adder = new LongAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new LongConsumer() {
            @Override
            public void accept(long value) {
                adder.add(value);
            }
        };
        LongStream.rangeClosed(1, 5).forEach(consumer);
        // fixme:
        // Assert.assertEquals(15, adder.longValue());
    }

    @Test
    void DoubleConsumer() {
        var adder = new DoubleAdder();
        // TODO - Convert the anonymous inner class to a lambda
        var consumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {
                adder.add(value);
            }
        };
        DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).forEach(consumer);
        // fixme:
        // Assert.assertEquals(15.0, adder.doubleValue(), 0.0);
    }

    @Test
    void IntPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        };
        var evens = IntStream.rangeClosed(1, 5).filter(predicate).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(2, 4), evens);
        var odds = IntStream.rangeClosed(1, 5).filter(predicate.negate()).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(1, 3, 5), odds);
//        Assert.assertTrue(IntStream.rangeClosed(1, 5).anyMatch(predicate));
//        Assert.assertFalse(IntStream.rangeClosed(1, 5).allMatch(predicate));
//        Assert.assertFalse(IntStream.rangeClosed(1, 5).noneMatch(predicate));
    }

    @Test
    void LongPredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new LongPredicate() {
            @Override
            public boolean test(long value) {
                return value % 2 == 0;
            }
        };
        var evens = LongStream.rangeClosed(1, 5).filter(predicate).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(2L, 4L), evens);
        var odds = LongStream.rangeClosed(1, 5).filter(predicate.negate()).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(1L, 3L, 5L), odds);
//        Assert.assertTrue(LongStream.rangeClosed(1, 5).anyMatch(predicate));
//        Assert.assertFalse(LongStream.rangeClosed(1, 5).allMatch(predicate));
//        Assert.assertFalse(LongStream.rangeClosed(1, 5).noneMatch(predicate));
    }

    @Test
    void DoublePredicate() {
        // TODO - Convert the anonymous inner class to a lambda
        var predicate = new DoublePredicate() {
            @Override
            public boolean test(double value) {
                return value > 3.0;
            }
        };
        var greaterThan =
                DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).filter(predicate).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(4.0d, 5.0d), greaterThan);
        var lessThanEqualTo =
                DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).filter(predicate.negate()).boxed().collect(Collectors.toList());
        // fixme:
        // Assert.assertEquals(Arrays.asList(1.0d, 2.0d, 3.0d), lessThanEqualTo);
//        Assert.assertTrue(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).anyMatch(predicate));
//        Assert.assertFalse(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).allMatch(predicate));
//        Assert.assertFalse(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).noneMatch(predicate));
    }
}
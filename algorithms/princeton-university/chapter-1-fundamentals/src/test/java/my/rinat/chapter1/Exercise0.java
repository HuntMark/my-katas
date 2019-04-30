package my.rinat.chapter1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class Exercise0 {

    @ParameterizedTest
    @MethodSource("gcdTestCandidates")
    void testGcd(int p, int q, int expectedGcd) {
        assertThat(Math.gcd(p, q)).isEqualTo(expectedGcd);
    }

    private static Stream<Arguments> gcdTestCandidates() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(3, 2, 1),
                Arguments.of(14, 7, 7),
                Arguments.of(125, 25, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("oneDimensionalArrays")
    void testMaxSearching(double[] array) {
        assertThat(Arrays.max(array)).isEqualTo(3.0, within(0.0));
    }

    @ParameterizedTest
    @MethodSource("oneDimensionalArrays")
    void testAvgComputing(double[] array) {
        assertThat(Arrays.avg(array)).isEqualTo(2.0, within(0.0));
    }

    @ParameterizedTest
    @MethodSource("oneDimensionalArrays")
    void testArrayCopying(double[] array) {
        double[] copied = Arrays.copy(array);
        assertThat(array == copied).isFalse();
        assertThat(array).containsExactly(copied);
    }

    @ParameterizedTest
    @MethodSource("oneDimensionalArrays")
    void testArrayReversing(double[] array) {
        double[] origin = new double[array.length];
        System.arraycopy(array, 0, origin, 0, array.length);
        Arrays.reverse(array);
        for (int i = 0; i < array.length; i++) {
            assertThat(origin[i]).isEqualTo(array[array.length - i - 1]);
        }
    }

    private static Stream<double[]> oneDimensionalArrays() {
        return Stream.of(
                new double[] {1.0, 2.0, 3.0},
                new double[] {3.0, 2.0, 1.0},
                new double[] {2.0, 3.0, 1.0},
                new double[] {2.0, 1.0, 3.0}
        );
    }
}

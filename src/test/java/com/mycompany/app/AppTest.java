package com.mycompany.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;

public class AppTest
{
    static Stream<Arguments> equivalence_partitioning_provider() {
        return Stream.of(
                arguments(93, 'A'),
                arguments(83, 'B'),
                arguments(73, 'C'),
                arguments(63, 'D'),
                arguments(33, 'F'),
                arguments(-3, 'X'),
                arguments(103, 'X')
        );
    }

    @ParameterizedTest
    @MethodSource("equivalence_partitioning_provider")
    void test_grade_by_equivalence_partitioning(int score, char expectedGrade) {
        App app = new App();
        char actualGrade = app.letterGrade(score);
        assertEquals(actualGrade, expectedGrade);
    }

    static Stream<Arguments> boundary_value_analysis_provider() {
        return Stream.of(
                arguments(101, 'X'),arguments(100, 'A'),
                arguments(99, 'A'),arguments(91, 'A'),
                arguments(90, 'A'),arguments(89, 'B'),
                arguments(81, 'B'),arguments(80, 'B'),
                arguments(79, 'C'),arguments(71, 'C'),
                arguments(70, 'C'),arguments(69, 'D'),
                arguments(61, 'D'),arguments(60, 'D'),
                arguments(59, 'F'),arguments(1, 'F'),
                arguments(0, 'F'),arguments(-1, 'X')
        );
    }

    @ParameterizedTest
    @MethodSource("boundary_value_analysis_provider")
    void test_grade_by_boundary_value_analysis(int score, char expectedGrade) {
        App app = new App();
        char actualGrade = app.letterGrade(score);
        assertEquals(actualGrade, expectedGrade);
    }
}

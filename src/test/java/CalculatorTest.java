import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.calculator.Calculator;
import pl.calculator.Instruction;
import pl.calculator.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("parametersToCalculate")
    void testCalculatedResultsParameters(List<Instruction> instructions, double applyValue, double expectedResult) {

        assertEquals(Calculator.calculate(instructions, applyValue), expectedResult);
    }

    static Stream<Arguments> parametersToCalculate () {
        List<Instruction> list1 = Arrays.asList(new Instruction(Operation.ADD, 2), new Instruction(Operation.MULTIPLY, 3), new Instruction(Operation.SUBTRACT, 2));
        List<Instruction> list2 = new ArrayList<>();
        List<Instruction> list3 = Arrays.asList(new Instruction(Operation.DIVIDE, 5), new Instruction(Operation.SUBTRACT, 4), new Instruction(Operation.MULTIPLY, 2));
        List<Instruction> list4 = Arrays.asList(new Instruction(Operation.MULTIPLY, 4), new Instruction(Operation.ADD, 3), new Instruction(Operation.SUBTRACT, 2));
        List<Instruction> list5 = Arrays.asList(new Instruction(Operation.SUBTRACT, 15), new Instruction(Operation.DIVIDE, -5), new Instruction(Operation.ADD, 40));
        return Stream.of(
                Arguments.of(list1, 10, 34),
                Arguments.of(list2, 10, 10),
                Arguments.of(list3, 10, -4),
                Arguments.of(list4, 0, 1),
                Arguments.of(list5, -5, 44)
        );
    }

    @Test
    void calculateShouldThrowArithmeticException() {

        List<Instruction> list = Collections.singletonList(new Instruction(Operation.DIVIDE, 0));
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculator.calculate(list, 10);

        });

    }
}
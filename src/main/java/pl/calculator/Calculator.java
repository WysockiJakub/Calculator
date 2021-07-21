package pl.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {

    public double validateAndCalculate(BufferedReader br) throws IOException {

        double applyValue = 0;
        String line;
        List<Instruction> instructions = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            StringTokenizer stringTokenizer = new StringTokenizer(line);
            String operation = stringTokenizer.nextToken();

            //checking if instruction is "apply"
            if (operation.equals(Operation.APPLY.getDescription())) {
                applyValue = Double.parseDouble(stringTokenizer.nextToken());
                break; //stop the loop
            }

            //validating and adding to list next instruction from input file
            Instruction instruction = new Instruction();
            instruction.validateAndSetOperation(operation);
            instruction.validateAndSetOperationValue(stringTokenizer);
            instructions.add(instruction);
        }
        return calculate(instructions, applyValue);
    }

    public static double calculate(List<Instruction> instructions, double result) {
        for (Instruction instruction : instructions) {
            switch (instruction.getOperation()) {
                case ADD:
                    result += instruction.getValue();
                    break;
                case DIVIDE:
                    result = validateDivide(result, instruction);
                    break;
                case MULTIPLY:
                    result *= instruction.getValue();
                    break;
                case SUBTRACT:
                    result -= instruction.getValue();
                    break;
            }
        }
        return result;
    }

    private static double validateDivide(double result, Instruction instruction){
        if (instruction.getValue() != 0) {
            result /= instruction.getValue();
        } else {
            throw new ArithmeticException("Can not divide by zero");
        }
        return result;
    }
}

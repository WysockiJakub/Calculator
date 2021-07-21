package pl.calculator;

import java.util.StringTokenizer;

public class Instruction {

    private Operation operation;
    private double value;

    public Instruction(Operation operation, double value) {
        this.operation = operation;
        this.value = value;
    }

    public Instruction() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void validateAndSetOperation(String operationFromInput) {
        try {
            this.setOperation(Operation.getValueFromString(operationFromInput));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("pl.calculator.Operation \"" + operationFromInput + "\" does not exist");
        }
    }

    public void validateAndSetOperationValue(StringTokenizer stringTokenizer) {
        String value = null;
        try {
            value = stringTokenizer.nextToken();
            this.setValue(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can not match value \"" + value + "\" with operation " + this.getOperation().getDescription());
        }
    }
}

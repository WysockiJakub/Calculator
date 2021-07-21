package pl.calculator;

import java.util.Arrays;

public enum Operation {

    APPLY("apply"),
    ADD("add"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    SUBTRACT("subtract");


    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static Operation getValueFromString(String value) {
        try {
            return valueOf(value);
        } catch (Exception var2) {
            return Arrays.stream(values()).filter((pos) ->
                    pos.getDescription().equalsIgnoreCase(String.valueOf(value)))
                    .findAny().orElseGet(() -> values()[Integer.parseInt(value)]);
        }
    }
}

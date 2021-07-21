package pl.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static final String INPUT_PATH = "input.txt";

    public static void main(String[] args) throws IOException {

        File file = new File(INPUT_PATH);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Calculator calculator = new Calculator();

        System.out.println(calculator.validateAndCalculate(br));
    }


}
package com.example.calculator.servise;

public class CalculatorService {
    public static String calculate(String first, String last, String operator) {
        String res = "";
        if(validateParam(first, last, operator)) {
            int leftMeaning = Integer.parseInt(first);
            int rightMeaning = Integer.parseInt(last);
            int otvet = switch (operator) {
                case ("+") -> leftMeaning + rightMeaning;
                case ("-") -> leftMeaning - rightMeaning;
                case ("*") -> leftMeaning * rightMeaning;
                case ("/") -> leftMeaning / rightMeaning;
                default -> 0;
            };
            res = String.valueOf(otvet);
        }
        return res;
    }

    private static boolean validateParam(String first, String last, String operator) {
        boolean result = false;
        if((operator.equals("+")  || operator.equals("-")  || operator.equals("*")
                || operator.equals("/"))) {
            result = true;
        }
        return result;
    }
}

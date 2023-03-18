package hexlet.code.games;

import hexlet.code.UtilsRandom;
import hexlet.code.Engine;

public class CalcGame {
    static String gameRule = "What is the result of the expression?";
    static String[] operators = {"+", "-", "*"};
    static String[] questions = new String[Engine.turnsCount];
    static String[] rightAnswers = new String[Engine.turnsCount];

    private static void setGameData() {
        for (var i = 0; i < Engine.turnsCount; i += 1) {
            var num1 = UtilsRandom.getRandomNumber(100);
            var num2 = UtilsRandom.getRandomNumber(100);
            var operator = operators[UtilsRandom.getRandomNumber(operators.length)];
            questions[i] = num1 + " " + operator + " " + num2;

            switch (operator) {
                case "+":
                    rightAnswers[i] = Integer.toString(num1 + num2);
                    break;
                case "-":
                    rightAnswers[i] = Integer.toString(num1 - num2);
                    break;
                case "*":
                    rightAnswers[i] = Integer.toString(num1 * num2);
                    break;
                default:
                    return;
            }
        }
    }

    public static void start() {
        setGameData();
        Engine.startGame(gameRule, questions, rightAnswers);
    }

}


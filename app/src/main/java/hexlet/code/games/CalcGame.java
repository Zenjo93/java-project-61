package hexlet.code.games;

import hexlet.code.UtilsRandom;
import hexlet.code.Engine;

public class CalcGame {
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MAX_LIMIT = 100;
    private static String[] questions = new String[Engine.getTurnsCount()];
    private static String[] rightAnswers = new String[Engine.getTurnsCount()];

    public static String getGameRule() {
        return GAME_RULE;
    }

    public static String[] getOperators() {
        return OPERATORS;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static String[] getRightAnswers() {
        return rightAnswers;
    }

    private static void setGameData() {
        for (var i = 0; i < Engine.getTurnsCount(); i += 1) {
            var num1 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            var num2 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            var operator = OPERATORS[UtilsRandom.getRandomNumber(OPERATORS.length)];
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
        Engine.startGame(GAME_RULE, questions, rightAnswers);
    }

}


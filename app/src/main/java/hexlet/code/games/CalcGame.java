package hexlet.code.games;

import hexlet.code.UtilsRandom;
import hexlet.code.Engine;

public class CalcGame {
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MAX_LIMIT = 100;

    private static String[][] getGameData() {
        String[] questions = new String[Engine.TURNS_COUNT];
        String[] rightAnswers = new String[Engine.TURNS_COUNT];

        for (var i = 0; i < Engine.TURNS_COUNT; i += 1) {
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
                    break;
            }
        }
        return new String[][]{questions, rightAnswers};
    }

    public static void start() {
        String[][] gameData = getGameData();
        Engine.startGame(GAME_RULE, gameData);
    }

}


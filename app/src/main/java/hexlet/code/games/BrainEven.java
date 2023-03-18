package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class BrainEven {
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_LIMIT = 100;
    private static String[] questions = new String[Engine.getTurnsCount()];
    private static String[] rightAnswers = new String[Engine.getTurnsCount()];

    public static String getGameRule() {
        return GAME_RULE;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static String[] getRightAnswers() {
        return rightAnswers;
    }

    private static void setGameData() {
        for (var i = 0; i < Engine.getTurnsCount(); i += 1) {
            var question = UtilsRandom.getRandomNumber(MAX_LIMIT);
            questions[i] = Integer.toString(question);
            rightAnswers[i] = isEven(question);
        }
    }

    private static String isEven(int num) {
        return num % 2 == 0 ? "yes" : "no";
    }

    public static void start() {
        setGameData();
        Engine.startGame(getGameRule(), getQuestions(), getRightAnswers());
    }
}


package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class BrainEven {
    static private String gameRule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static private String[] questions = new String[Engine.getTurnsCount()];
    static private String[] rightAnswers = new String[Engine.getTurnsCount()];

    public static String getGameRule() {
        return gameRule;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static String[] getRightAnswers() {
        return rightAnswers;
    }

    private static void setGameData() {
        for (var i = 0; i < Engine.getTurnsCount(); i += 1) {
            var question = UtilsRandom.getRandomNumber(100);
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


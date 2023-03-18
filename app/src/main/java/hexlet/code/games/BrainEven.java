package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class BrainEven {
    static String gameRule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static String[] questions = new String[Engine.turnsCount];
    static String[] rightAnswers = new String[Engine.turnsCount];

    private static void setGameData() {
        for (var i = 0; i < Engine.turnsCount; i += 1) {
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
        Engine.startGame(gameRule, questions, rightAnswers);
    }
}


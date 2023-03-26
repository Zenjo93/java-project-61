package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Even {
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_LIMIT = 100;

    private static String[][] getGameData() {
        String[] questions = new String[Engine.TURNS_COUNT];
        String[] rightAnswers = new String[Engine.TURNS_COUNT];

        for (var i = 0; i < Engine.TURNS_COUNT; i += 1) {
            var question = UtilsRandom.getRandomNumber(MAX_LIMIT);
            questions[i] = Integer.toString(question);
            rightAnswers[i] = isEven(question) ? "yes" : "no";
        }

        return new String[][]{questions, rightAnswers};
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void start() {
        String[][] gameData = getGameData();
        Engine.startGame(GAME_RULE, gameData);

    }
}

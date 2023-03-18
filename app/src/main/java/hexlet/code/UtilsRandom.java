package hexlet.code;

import java.util.Random;

public class UtilsRandom {
    public static int getRandomNumber(int maxLimit) {
        Random random = new Random();
        return random.nextInt(maxLimit);
    }

}
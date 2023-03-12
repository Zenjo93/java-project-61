package hexlet.code;

import hexlet.code.games.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit"
        );

        String option = scanner.next();

        switch(option) {
            case "1":
                Cli.greet();
                break;

            case "2":
                BrainEven brainEvenGame = new BrainEven();
                brainEvenGame.launchGame();
                break;

            case "0":
                scanner.close();
                break;

            default:
                break;

        }

    }

    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        scanner.close();

    }

}

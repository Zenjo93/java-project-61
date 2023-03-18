package hexlet.code;

import hexlet.code.games.BrainEven;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GDC;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Please enter the game number and press Enter.
                        1 - Greet
                        2 - Even
                        3 - Calc
                        4 - GCD
                        0 - Exit"""
        );

        String option = scanner.next();

        switch (option) {
            case "1":
                Cli.greet();
                break;
            case "2":
                BrainEven.start();
                break;
            case "3":
                CalcGame.start();
                break;
            case "4":
                GDC.start();

            case "0":
                break;

            default:
                break;

        }

    }

}

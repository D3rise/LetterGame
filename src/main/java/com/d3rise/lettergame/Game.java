package com.d3rise.lettergame;

import java.util.Scanner;

public class Game {
    private final static Scanner INPUT = new Scanner(System.in);
    private final static char[] LETTERS = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {

        int score = 0;

        if (score == 0) {
            System.out.println("Начать игру? Y/N");
        } else {
            System.out.println("Продолжить игру? Y/N");
        }

        String answer = INPUT.next();

        if(answer.toLowerCase().equals("n")) {
            System.out.println("Игра окончена!" + "\nТвой счет: " + score);
            System.exit(1);
        }

        while(answer.toLowerCase() != "y") {
            if(score > 0) {
                System.out.println("Твой текущий счет: " + score + "\nПродолжить игру? Y/N");

                String answ = INPUT.next();
                if(answ.equals("n")) {
                    System.out.println("Игра окончена!" + "\nТвой счет: " + score);
                    System.exit(1);
                }
            }
            score = lattergame(score);
        }
    }

    private static int lattergame(int scoreInt) {
        int letterNum = 0 + (int) (Math.random() * LETTERS.length);
        System.out.print("Буква загадана. Введите предпологаемый номер буквы: ");
        int letterUserNum = INPUT.nextInt();
        if (letterUserNum == letterNum) {
            System.out.println("Ты выиграл! Этой буквой была: " + LETTERS[letterNum]);
        }

        int attempts = 0;

        while (letterUserNum != letterNum) {
            if (letterUserNum > letterNum) {
                attempts++;
                System.out.println("Слишком много! Текущая попытка: " + attempts);
            } else {
                attempts++;
                System.out.println("Слишком мало! Текущая попытка: " + attempts);
            }

            System.out.println("Введите предпологаемый номер буквы: ");
            letterUserNum = INPUT.nextInt();

            if (letterUserNum == letterNum) {
                System.out.println("Ты выиграл! Этой буквой была: " + LETTERS[letterNum] + "\nТы предпринял " + attempts + " попыток для разгадки буквы\n");
                scoreInt += 1;
            }
        }

        return scoreInt;
    }
}

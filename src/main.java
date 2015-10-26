import java.util.Random;
import java.util.Scanner;

/**
 * Colors:
 * Black - 30
 * Red - 31
 * Green - 32
 * Yellow - 33
 * Blue - 34
 * Purple - 35
 * Blue - 36
 * White - 37
 */
public class main {

    static int[] field = {0, 0, 0, 0, 1, 0, 0, 0, 0};
    static int flagExit = 0;

    public static void main(String args[]) {
        printHeader();
        writeLine(1);
        printMsg("Press ", 37);
        printMsg("[Enter] ", 33);
        printMsgln("to start the game...", 37);
        waitForEnter();
        while (flagExit == 0) {
            gameStart();
            writeLineln(1);
        }

        writeLine(1);
        printMsg("Thanks for playing!", 35);
        writeLine(1);
        printMsg("Copyright (C) 2015  Andrey", 37);
        writeLine(2);
    }

    static void printMsg(String msg, int color) {
        System.out.print((char) 27 + "[" + color + "m" + msg + " " + (char) 27 + "[0m");
    }

    static void printMsgln(String msg, int color) {
        System.out.println((char) 27 + "[" + color + "m" + msg + " " + (char) 27 + "[0m");
    }

    static void printHeader() {
        System.out.println("\n");
        System.out.println("X     X    OOOO");
        System.out.println(" X   X    O    O");
        System.out.println("  X X     O    O");
        System.out.println("   X " + (char) 27 + "[35mGAME " + (char) 27 + "[0m" + "" +
                "O    O");
        System.out.println("  X X     O    O");
        System.out.println(" X   X    O    O");
        System.out.println("X     X    OOOO  " + (char) 27 + "[31mBy Andrey " + (char) 27 + "[0m");
        printMsgln("\n Welcome to XOGame!", 37);
    }

    static void waitForEnter() {
        System.console().readLine();
        //Scanner scannerwte = new Scanner(System.in);
        //scannerwte.next();
    }

    static void writeLine(int iter) {
        for (int i = 0; i < iter; i++) {
            System.out.print("\n");
        }
    }

    static void writeLineln(int iter) {
        for (int i = 0; i < iter; i++) {
            System.out.println("\n");
        }
    }

    static void gameStart() {
        writeLine(2);
        printMsg("---------------------", 30);
        writeLine(2);
        drawView(field);
        int sp = stepPrompt();
        while (field[sp - 1] != 0) {
            printMsg("Sorry, but this cell is already occupied! Check another cell...", 31);
            sp = stepPrompt();
        }
        field[sp - 1] = 2;

        int w = checkWin(field);
        if (w == 2) {
            writeLine(2);
            printMsg("---------------------", 30);
            writeLine(2);
            drawView(field);
            writeLine(2);
            printMsg("Congratulation! You WIN!!!", 32);
            flagExit = 1;
        }

        int r = compStep();
        while (field[r] != 0) {
            r = compStep();
        }
        field[r] = 1;

        w = checkWin(field);
        if (w == 1) {
            writeLine(2);
            printMsg("---------------------", 30);
            writeLine(2);
            drawView(field);
            writeLine(2);
            printMsg("You LOSE, LOSER!!!!!", 31);
            flagExit = 1;
        }
    }

    static void drawView(int[] field) {
        for (int i = 0; i < field.length; i++) {
            if (i == 3 || i == 6) {
                writeLine(1);
            }
            if (field[i] == 0) {
                printMsg((char) 9632 + "", 34);
            } else if (field[i] == 1) {
                printMsg("X", 31);
            } else {
                printMsg("O", 32);
            }
        }
    }

    static int stepPrompt() {
        writeLine(1);
        printMsg("Put 'O' to:", 37);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static int compStep() {
        final Random random = new Random();
        return random.nextInt(9);
    }

    static int checkWin(int[] field) {
        if (field[0] == 1 && field[1] == 1 && field[2] == 1) {
            return 1;
        }
        if (field[3] == 1 && field[4] == 1 && field[5] == 1) {
            return 1;
        }
        if (field[6] == 1 && field[7] == 1 && field[8] == 1) {
            return 1;
        }
        if (field[0] == 1 && field[3] == 1 && field[6] == 1) {
            return 1;
        }
        if (field[1] == 1 && field[4] == 1 && field[8] == 1) {
            return 1;
        }
        if (field[2] == 1 && field[5] == 1 && field[8] == 1) {
            return 1;
        }
        if (field[0] == 1 && field[4] == 1 && field[8] == 1) {
            return 1;
        }
        if (field[2] == 1 && field[4] == 1 && field[6] == 1) {
            return 1;
        }


        if (field[0] == 2 && field[1] == 2 && field[2] == 2) {
            return 2;
        }
        if (field[3] == 2 && field[4] == 2 && field[5] == 2) {
            return 2;
        }
        if (field[6] == 2 && field[7] == 2 && field[8] == 2) {
            return 2;
        }
        if (field[0] == 2 && field[3] == 2 && field[6] == 2) {
            return 2;
        }
        if (field[1] == 2 && field[4] == 2 && field[8] == 2) {
            return 2;
        }
        if (field[2] == 2 && field[5] == 2 && field[8] == 2) {
            return 2;
        }
        if (field[0] == 2 && field[4] == 2 && field[8] == 2) {
            return 2;
        }
        if (field[2] == 2 && field[4] == 2 && field[6] == 2) {
            return 2;
        }

        return 0;
    }
}

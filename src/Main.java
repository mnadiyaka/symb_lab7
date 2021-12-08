import java.util.Scanner;

public class Main {
    static final String[][] auto = {
            {"", "a", "", "", ""},
            {"", "", "c", "", "b"},
            {"", "a", "", "b", ""},
            {"", "a", "c", "", ""},
            {"", "a", "c", "", ""},
    };
    static final int[] end = {0, 0, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row:");
        String row = sc.nextLine();
        while (!row.equals("-")) {
            System.out.println(language(row));
            System.out.print("Enter row:");
            row = sc.nextLine();
        }
    }

    public static int[] stepauto(int[] states, String letter) {
        int[] res = new int[states.length];
        if (letter == "") {
            return states;
        }
        for (int i = 0; i < states.length; i++) {
            if (states[i] == 1) {
                for (int j = 0; j < states.length; j++) {
                    if (Main.auto[i][j].contains(letter)) {
                        res[j] = 1;
                    }
                }
            }
        }
        return res;
    }

    public static int[] stepsauto(int[] states, String row) {
        for (int i = 0; i < row.length(); i++) {
            states = stepauto(states, row.substring(i, i + 1));
        }
        return states;
    }

    public static boolean teststates(int[] mas, int[] end) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 1 && mas[i] == end[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean language(String row) {
        int[] myEnd = stepsauto(new int[]{1, 0, 0, 0, 0}, row);
        return teststates(myEnd, Main.end);
    }
}

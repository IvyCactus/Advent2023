package Main.DailyFiles;

import java.util.ArrayList;

import Main.Runner;

public class Advent8 {
    public static double main() {
        ArrayList<String> inputString = Runner.readFile(8);
        char[] directionArray = inputString.get(0).toCharArray();
        String locationString = "";
        for (int i = 0; i < inputString.size() - 2; i++) {
            locationString += ("S:" + inputString.get(i + 2).substring(0, 3) + "|"
                    + inputString.get(i + 2).substring(7, 10)
                    + "|" + inputString.get(i + 2).substring(12, 15));
        }
        String start[] = new String[6];
        int index = 0;
        int i = 0;
        do {
            index = locationString.indexOf(("S:"), index);
            if (locationString.substring(index + 2, index + 5).endsWith("A")) {
                start[i] = locationString.substring(index + 2, index + 5);
                i++;
            }
            index++;
        } while (index != 0);
        int loop = 0;
        double[] results = new double[start.length];
        for (int k = 0; k < start.length; k++) {
            loop = 0;
            while (true) {
                int j = locationString.indexOf(("S:" + start[k]));
                if (directionArray[loop % directionArray.length] == 'L') {
                    start[k] = locationString.substring(j + 6, j + 9);
                } else {
                    start[k] = locationString.substring(j + 10, j + 13);
                }
                loop++;
                if (start[k].endsWith("Z")) {
                    results[k] = loop;
                    break;
                }
            }
        }
        return (lcm(results));
    }

    private static double gcd(double a, double b) {
        while (b > 0) {
            double temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static double lcm(double a, double b) {
        return a * (b / gcd(a, b));
    }

    private static double lcm(double[] input) {
        double result = input[0];
        for (int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);
        return result;
    }
}
package Main.DailyFiles;

import java.util.ArrayList;
import java.util.Arrays;

import Main.Runner;

public class Advent10 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(10);
        char[][] map = new char[inputString.size()][inputString.get(0).length()];
        char[][] loopMap = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            map[i] = inputString.get(i).toCharArray();
            Arrays.fill(loopMap[i], '0');
        }
        int[] locale = new int[2]; // Y, X
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    locale[0] = i;
                    locale[1] = j+1;
                }
            }
        }
        int[] prevMove = new int[2]; // 0: NA 1:DOWN 2:UP; 0:NA 1: RIGHT 2:LEFT
        prevMove[1] = 1;
        while (map[locale[0]][locale[1]] != 'S') {
            char pipe = map[locale[0]][locale[1]];
            loopMap[locale[0]][locale[1]] = pipe;
            if (pipe == '-') {
                if (prevMove[1] == 1) {
                    locale[1]++;
                } else {
                    locale[1]--;
                }
            } else if (pipe == '|') {
                if (prevMove[0] == 1) {
                    locale[0]++;
                } else {
                    locale[0]--;
                }
            } else if (pipe == 'L') {
                if (prevMove[0] == 1) {
                    locale[1]++;
                    prevMove[1] = 1;
                    prevMove[0] = 0;
                } else {
                    locale[0]--;
                    prevMove[0] = 2;
                    prevMove[1] = 0;
                }
            } else if (pipe == 'J') {
                if (prevMove[0] == 1) {
                    locale[1]--;
                    prevMove[0] = 0;
                    prevMove[1] = 2;
                } else {
                    locale[0]--;
                    prevMove[0] = 2;
                    prevMove[1] = 0;
                }
            } else if (pipe == '7') {
                if (prevMove[1] == 1) {
                    locale[0]++;
                    prevMove[0] = 1;
                    prevMove[1] = 0;
                } else {
                    locale[1]--;
                    prevMove[0] = 0;
                    prevMove[1] = 2;
                }
            } else if (pipe == 'F') {
                if (prevMove[1] == 2) {
                    locale[0]++;
                    prevMove[1] = 0;
                    prevMove[0] = 1;
                } else {
                    locale[1]++;
                    prevMove[0] = 0;
                    prevMove[1] = 1;
                }
            }
        }
        loopMap[locale[0]][locale[1]] = '-';
        int sum = 0;
        boolean inside = false;
        for (int i = 0; i < loopMap.length; i++) {
            inside = false;
            for (int j = 0; j < loopMap[i].length; j++) {
                if (loopMap[i][j] == '0' && inside) {
                    loopMap[i][j] = 'I';
                    sum++;
                }
                if (loopMap[i][j] == '7' || loopMap[i][j] == 'F' || loopMap[i][j] == '|' ) {
                    inside = (!inside);
                }
            }
        }
        return (sum);
    }
}
package Main.DailyFiles;

import Main.Runner;
import java.util.ArrayList;

public class Advent3 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(3);
        int sum = 0;
        for (int i = 0; i < inputString.size(); i++) {
            for (int j = 0; j < inputString.get(i).length(); j++) {
                if (!Character.isLetterOrDigit(inputString.get(i).charAt(j)) && inputString.get(i).charAt(j) != '.') {
                    int count = -1;
                    int[] gears = new int[2];
                    for (int iMovement = -1; iMovement < 2 && count < 3; iMovement++) {
                        for (int jMovement = -1; jMovement < 2 && count < 3; jMovement++) {
                            if (Character.isDigit(inputString.get(i + iMovement).charAt(j + jMovement))) {
                                count++;
                                int start = 0, end = 0;
                                for (int k = j + jMovement; k >= 0
                                        && Character.isDigit(inputString.get(i + iMovement).charAt(k)); k--) {
                                    start = k;
                                }
                                for (int k = j + jMovement; k < inputString.get(i).length()
                                        && Character.isDigit(inputString.get(i + iMovement).charAt(k)); k++) {
                                    end = k + 1;
                                }
                                if (count < 2) {
                                    gears[count] = Integer.valueOf(inputString.get(i + iMovement).substring(start, end));
                                }
                                jMovement = end - j;

                            }
                        }
                    }
                    if (count == 1) {
                        sum += (gears[0] * gears[1]);
                    }
                }
            }
        }
        return sum;
        // Part 1 code, part 2 I had to change my method :/
        // boolean[][] flagField = loopList(inputString, new
        // boolean[inputString.size()][inputString.get(0).length()]);
        // printFlags(flagField);
        // System.out.println(findSum(inputString, flagField));
    }

    /*
     * public static int findSum(ArrayList<String> data, boolean[][]flags){
     * int sum = 0;
     * for(int i = 0; i < data.size(); i++){
     * for(int j = 0; j < data.get(i).length(); j++){
     * if(Character.isDigit(data.get(i).charAt(j)) == true && flags[i][j] == true){
     * int end = 0, start = 0;
     * for(int k = j; k >= 0 && Character.isDigit(data.get(i).charAt(k)); k--){
     * start = k;
     * } 
     * for(int k = j; k < data.get(i).length() &&
     * Character.isDigit(data.get(i).charAt(k)); k++){
     * end = k+1;
     * }
     * sum += Integer.valueOf(data.get(i).substring(start, end));
     * System.out.println(data.get(i).substring(start, end));
     * j = end;
     * }
     * }
     * }
     * return sum;
     * }
     * public static boolean[][] loopList(ArrayList<String> data, boolean[][] flags)
     * {
     * for (int i = 0; i < data.size(); i++) {
     * char[] tempData = data.get(i).toCharArray();
     * for (int j = 0; j < data.get(i).length(); j++) {
     * if (!Character.isLetterOrDigit(tempData[j]) && tempData[j] != '.') {
     * for (int iMovement = -1; iMovement < 2; iMovement++) {
     * for (int jMovement = -1; jMovement < 2; jMovement++) {
     * flags[i + iMovement][j + jMovement] = true;
     * }
     * }
     * }
     * }
     * }
     * return flags;
     * }
     * 
     * public static void printFlags(boolean[][] flags) {
     * for (int i = 0; i < flags.length; i++) {
     * for (int j = 0; j < flags[0].length; j++) {
     * if (flags[i][j]) {
     * System.out.print(1);
     * } else {
     * System.out.print(0);
     * }
     * }
     * System.out.println();
     * }
     * }
     */
}

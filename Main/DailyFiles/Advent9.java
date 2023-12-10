package Main.DailyFiles;

import java.util.ArrayList;
import java.util.StringTokenizer;
import Main.Runner;

public class Advent9 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(9);
        int[][][] triangleArray = new int[inputString.size()][21][22]; // Set, X value, Y Value
        int sum = 0;
        for (int i = 0; i < triangleArray.length; i++) {
            StringTokenizer listTokenizer = new StringTokenizer(inputString.get(i), " ");
            int k = 0;
            while (listTokenizer.hasMoreTokens()) {
                triangleArray[i][k][0] = Integer.parseInt(listTokenizer.nextToken());
                k++;
            }
            for (int j = 1; j < triangleArray[i][0].length; j++) {
                for (int l = 0; l < triangleArray[i].length; l++) {
                    if (l < j) {
                        triangleArray[i][l][j] = 0;
                    } else {
                        triangleArray[i][l][j] = (triangleArray[i][l][j - 1] - triangleArray[i][l - 1][j - 1]);
                    }
                }
            }
            int tempSum = 0;
            for (int j = triangleArray[i][0].length - 2; j >= 0; j--) {
                tempSum = (triangleArray[i][j][j] - tempSum);
            }
            sum += tempSum;
        }
        return sum;
    }
}
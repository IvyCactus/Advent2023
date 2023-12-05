package Main.DailyFiles;

import Main.Runner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Advent4 {
    public static void main() {
        ArrayList<String> inputString = Runner.readFile(4);
        int loops = 0;
        int[] copies = new int[inputString.size()];
        for (int i = 0; i < copies.length; i++) {
            copies[i] = 1;
        }
        int[] counts = new int[copies.length];
        for(int k = 0; k < inputString.size(); k++){
            String x = inputString.get(k).substring(inputString.get(k).indexOf(":") + 1) + " ";
                StringTokenizer seperateSides = new StringTokenizer(x, "|");
                StringTokenizer winningNumTokenizer = new StringTokenizer(seperateSides.nextToken(), " ");
                String[] winningNums = new String[winningNumTokenizer.countTokens()];
                int i = 0;
                while (winningNumTokenizer.hasMoreTokens()) {
                    winningNums[i] = winningNumTokenizer.nextToken();
                    i++;
                }
                String rightNums = seperateSides.nextToken();
                int count = 0;
                for (String num : winningNums) {
                    if (rightNums.contains(" " + num + " ")) {
                        count++;
                    }
                }
                counts[k] = count;
        }
        for (int k = 0; k < inputString.size(); k++) {
            for (int j = copies[k]; j > 0; j--) {
                for(int l = 1; l <= counts[k]; l++){
                    copies[k+l]++;
                }
                loops++;
            }
        }
        System.out.println(loops);
    }
}
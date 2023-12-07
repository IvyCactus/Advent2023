package Main.DailyFiles;

import java.util.ArrayList;
import java.util.StringTokenizer;
import Main.Runner;

public class Advent6 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(6);
        String timeString = inputString.get(0).substring(inputString.get(0).indexOf(":") + 1);
        String distString = inputString.get(1).substring(inputString.get(1).indexOf(":") + 1);
        StringTokenizer timeTokenizer = new StringTokenizer(timeString, " ");
        StringTokenizer distTokenizer = new StringTokenizer(distString, " ");
        String tempTimeString = "", tempDistString = "";
        while (timeTokenizer.hasMoreTokens()) {
            tempTimeString += timeTokenizer.nextToken();
            tempDistString += distTokenizer.nextToken();
        }
        int sum = 0;
        for (int j = 0; j < Double.parseDouble(tempTimeString); j++) {
            double distance = (Double.parseDouble(tempTimeString) - j) * j;
            if (distance > Double.parseDouble(tempDistString)) {
                sum++;
            }
        }
        return sum;
    }
}
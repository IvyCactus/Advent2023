package Main.DailyFiles;

import Main.Runner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Advent2 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(2);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String useString = inputString.get(i).substring((inputString.get(i).indexOf(":")) + 1);
            StringTokenizer st = new StringTokenizer(useString, ",");
            int greenMax = 0, blueMax = 0, redMax = 0;
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                StringTokenizer stSemi = new StringTokenizer(temp, ";");
                while (stSemi.hasMoreTokens()) {
                    String tempSemi = stSemi.nextToken().substring(1);
                    if (tempSemi.contains("red")) {
                        if (Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("red") - 1)) > redMax) {
                            redMax = Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("red") - 1));
                        }
                    }
                    if (tempSemi.contains("blue")) {
                        if (Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("blue") - 1)) > blueMax) {
                            blueMax = Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("blue") - 1));
                        }
                    }
                    if (tempSemi.contains("green")) {
                        if (Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("green") - 1)) > greenMax) {
                            greenMax = Integer.parseInt(tempSemi.substring((0), tempSemi.indexOf("green") - 1));
                        }
                    }
                }
            }
            sum += (greenMax * redMax * blueMax);
        }
        return sum;
    }
}
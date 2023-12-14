package Main.DailyFiles;

import java.util.ArrayList;
import java.util.StringTokenizer;
import Main.Runner;
import java.util.HashMap;

public class Advent12 {
    public static double main() {
        ArrayList<String> inputString = Runner.readFile(12);
        ArrayList<String> leftList = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> rightList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputString.size(); i++) {
            StringTokenizer longTokenizer = new StringTokenizer(inputString.get(i), " ");
            leftList.add(longTokenizer.nextToken());leftList.set(i, (leftList.get(i) + "?" + leftList.get(i) + "?" + leftList.get(i) + "?" + leftList.get(i) + "?" + leftList.get(i)));
            StringTokenizer shortTokenizer = new StringTokenizer(longTokenizer.nextToken(), ",");
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (shortTokenizer.hasMoreTokens()) {
                temp.add(Integer.parseInt(shortTokenizer.nextToken()));
            }
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < temp.size(); k++) {
                    temp2.add(temp.get(k));
                }
            }
            rightList.add(temp2);
        }
        double sum = 0;
        for (int i = 0; i < leftList.size(); i++) {
            sum += recursiveParse("", leftList.get(i), rightList.get(i), new HashMap<>());
        }
        return sum;
    }

    private static Double recursiveParse(String done, String left, ArrayList<Integer> check, HashMap<String, Double> memo) {
        ArrayList<Integer> temp = getSprings(done);
        String keyString = "";
        if(done.length() > 0){
        keyString = (String.valueOf(temp) + ":" + left + ":" + done.substring(done.length()-1, done.length()));
        }
        Double result = 0.0;
        for (int i = 0; i < temp.size() - 1 && temp.size() > 1; i++) {
            if (temp.size() > check.size()) {
                return 0.0;
            } else if (check.get(i) != temp.get(i)) {
                return 0.0;
            }
        }
        if (left == "") {
            if (check.equals(getSprings(done))) {
                System.out.println(done);
                return 1.0;
            } else {
                return 0.0;
            }
        }
        if (done.length() > 0 && memo.containsKey(keyString)) {
            return memo.get(keyString);
            
        }
         else if (!left.substring(0, 1).equals("?")) {
            result = recursiveParse((done + left.substring(0, 1)), left.substring(1), check, memo);
        } else {
            result = (recursiveParse((done + "."), left.substring(1), check, memo)+ recursiveParse((done + "#"), left.substring(1), check, memo));
        }
        if(done.length() > 0){
        memo.put(keyString, result);
        }
        return result;
    }

    private static ArrayList<Integer> getSprings(String springString) {
        int broke = 0;
        ArrayList<Integer> rightMatcher = new ArrayList<Integer>();
        for (int i = 0; i < springString.length(); i++) {
            if (springString.charAt(i) == '#') {
                broke++;
            } else if (broke > 0) {
                rightMatcher.add(broke);
                broke = 0;
            }
        }
        if (broke > 0) {
            rightMatcher.add(broke);
        }
        return rightMatcher;
    }
}
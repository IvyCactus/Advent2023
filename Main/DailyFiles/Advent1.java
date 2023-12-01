package Main.DailyFiles;
import java.util.ArrayList;

import Main.Runner;

public class Advent1 {
    public void main() {
        ArrayList<ArrayList<Integer>> numList = getNums(Runner.readFile(1));
        ArrayList<String> shortList = cutOutMiddle(numList);
        int sum = 0;
        for (String x : shortList) {
            sum += Integer.parseInt(x);
        }
        System.out.println(sum);
    }
    private ArrayList<String> cutOutMiddle(ArrayList<ArrayList<Integer>> longList) {
        ArrayList<String> localShortList = new ArrayList<String>();
        for (int i = 0; i < longList.size(); i++) {
            String temp;
            temp = (String.valueOf(longList.get(i).get(0)) + ""
                    + String.valueOf(longList.get(i).get((longList.get(i).size() - 1))));
            localShortList.add(temp);
        }
        return localShortList;
    }
    private ArrayList<ArrayList<Integer>> getNums(ArrayList<String> stringList) {
        ArrayList<ArrayList<Integer>> numListLocal = new ArrayList<ArrayList<Integer>>();
        for (int j = 0; j < stringList.size(); j++) {
            String x = stringList.get(j);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < x.length(); i++) {
                try {
                    try {
                        if (x.substring(i, i + 3).equals("one")) {
                            temp.add(1);
                        } else if (x.substring(i, i + 3).equals("two")) {
                            temp.add(2);
                        } else if (x.substring(i, i + 3).equals("six")) {
                            temp.add(6);
                        } else if (x.substring(i, i + 4).equals("four")) {
                            temp.add(4);
                        } else if (x.substring(i, i + 4).equals("five")) {
                            temp.add(5);
                        } else if (x.substring(i, i + 4).equals("nine")) {
                            temp.add(9);
                        } else if (x.substring(i, i + 4).equals("zero")) {
                            temp.add(0);
                        } else if (x.substring(i, i + 5).equals("seven")) {
                            temp.add(7);
                        } else if (x.substring(i, i + 5).equals("eight")) {
                            temp.add(8);
                        } else if (x.substring(i, i + 5).equals("three")) {
                            temp.add(3);
                        }
                    } catch (IndexOutOfBoundsException e) {}
                    temp.add(Integer.parseInt(x.substring((i), i + 1)));
                } catch (NumberFormatException e) {}
            }
            numListLocal.add(temp);
        }
        return numListLocal;
    }
}
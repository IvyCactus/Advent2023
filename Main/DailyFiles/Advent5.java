package Main.DailyFiles;

import Main.Runner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Advent5 {
    public static double main() {
        ArrayList<String> inputString = Runner.readFile(5);
        ArrayList<Double[][]> seedMap = new ArrayList<Double[][]>();
        String seeds = inputString.get(0).substring(inputString.get(0).indexOf(":") + 1);
        StringTokenizer seedSeperator = new StringTokenizer(seeds, " ");
        for (int i = 0; i < seedSeperator.countTokens() / 2; i++) {
            seedMap.add(new Double[8][2]);
        }
        int l = 0;
        while (seedSeperator.hasMoreTokens()) {
            double tempStart = Double.parseDouble(seedSeperator.nextToken());
            double tempEnd = Double.parseDouble(seedSeperator.nextToken()) + tempStart;
            Double[] temp = { tempStart, tempEnd };
            seedMap.get(l)[0] = temp;
            l++;
        }
        int source = 0;
        for (int i = 3; i < inputString.size(); i++) {
            StringTokenizer st = new StringTokenizer(inputString.get(i), " ");
            Double destinationStart = Double.parseDouble(st.nextToken());
            Double mappingStart = Double.parseDouble(st.nextToken());
            Double mappingEnd = (Double.parseDouble(st.nextToken()) + mappingStart);
            for (int seed = 0; seed < seedMap.size(); seed++) {
                Double seedStart = seedMap.get(seed)[source][0];
                Double seedEnd = seedMap.get(seed)[source][1];
                if (seedStart < mappingEnd && seedEnd > mappingStart) { // a>d || c>b give up
                    Double[][] tempSeedMap = new Double[8][2];
                    for (int k = 0; k < tempSeedMap.length; k++) {
                        tempSeedMap[k][0] = seedMap.get(seed)[k][0];
                        tempSeedMap[k][1] = seedMap.get(seed)[k][1];
                    }
                    if (mappingStart <= seedStart && seedEnd <= mappingEnd) { // c<a && d>b
                        seedMap.get(seed)[source + 1][0] = (destinationStart + (seedStart - mappingStart));
                        seedMap.get(seed)[source + 1][1] = (destinationStart + (seedEnd - mappingStart));
                    } else if (seedStart > mappingStart && seedEnd > mappingEnd) { // a > c && b > d
                        seedMap.add(tempSeedMap);
                        seedMap.get(seedMap.size() - 1)[source][0] = mappingEnd;
                        seedMap.get(seedMap.size() - 1)[source][1] = seedEnd;
                        seedMap.get(seed)[source][0] = seedStart;
                        seedMap.get(seed)[source][1] = mappingEnd;
                        seedMap.get(seed)[source + 1][0] = (seedStart - mappingStart + destinationStart);
                        seedMap.get(seed)[source + 1][1] = (mappingEnd - mappingStart + destinationStart);
                    } else if (seedStart < mappingStart && seedEnd > mappingStart) { // a < c && b < d
                        seedMap.add(tempSeedMap);
                        seedMap.get(seedMap.size() - 1)[source][0] = seedStart;
                        seedMap.get(seedMap.size() - 1)[source][1] = mappingStart;
                        seedMap.get(seed)[source][0] = mappingStart;
                        seedMap.get(seed)[source][1] = seedEnd;
                        seedMap.get(seed)[source + 1][0] = destinationStart;
                        seedMap.get(seed)[source + 1][1] = (seedEnd - mappingStart + destinationStart);
                    } else if (seedStart < mappingStart && mappingEnd < seedEnd) { // a < c < d < b
                        seedMap.add(tempSeedMap);
                        seedMap.get(seedMap.size() - 1)[source][1] = mappingStart;
                        seedMap.add(tempSeedMap);
                        seedMap.get(seedMap.size() - 1)[source][1] = seedEnd;
                        seedMap.get(seedMap.size() - 1)[source][0] = mappingEnd;
                        seedMap.get(seed)[source][0] = mappingStart;
                        seedMap.get(seed)[source][1] = mappingEnd;
                        seedMap.get(seed)[source + 1][0] = destinationStart;
                        seedMap.get(seed)[source + 1][1] = (mappingEnd - mappingStart + destinationStart);
                    }
                }
            }
            if (i < inputString.size() - 1 && inputString.get(i + 1).equals("")) {
                for (int seed = 0; seed < seedMap.size(); seed++) {
                    if (seedMap.get(seed)[source + 1][0] == null) {
                        seedMap.get(seed)[source + 1][0] = seedMap.get(seed)[source][0];
                        seedMap.get(seed)[source + 1][1] = seedMap.get(seed)[source][1];
                    }
                }
                source++;
                i += 2;
            }
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < seedMap.size(); i++) {
            if (seedMap.get(i)[7][0] < min) {
                min = seedMap.get(i)[7][0];
            }
        }
        return min;
    }
}
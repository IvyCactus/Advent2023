package Main.DailyFiles;

import java.util.ArrayList;

import Main.Runner;

public class Advent11 {
    public static double main() {
        ArrayList<String> inputString = Runner.readFile(11);
        ArrayList<Integer> indexX = new ArrayList<Integer>();
        ArrayList<Integer> indexY = new ArrayList<Integer>();
        ArrayList<Integer> indexXMil = new ArrayList<Integer>();
        ArrayList<Integer> indexYMil = new ArrayList<Integer>();
        ArrayList<Integer[]> galaxies = new ArrayList<Integer[]>();
        for(int i = 0; i < inputString.size(); i++){ 
            int j = 0;
            while(inputString.get(i).indexOf("#", j) != -1){
                Integer[] temp = {inputString.get(i).indexOf("#", j), i};
                galaxies.add(temp);
                j = (inputString.get(i).indexOf("#", j) +1);
                indexX.add(j-1);
                indexY.add(i);
            }
        }
        for(int i = 0; i < inputString.get(0).length(); i++){
            if(!indexX.contains(i)){
                indexXMil.add(i);
            }
        }
        for(int i = 0; i < inputString.size(); i++){
            if(!indexY.contains(i)){
                indexYMil.add(i);
            }
        }
        double sum = 0;
        for(int i = 0; i < galaxies.size(); i++){
            for(int j = i+1; j < galaxies.size(); j++){
                for(int k = 0; k < indexXMil.size(); k++){
                    if((galaxies.get(i)[0] <= indexXMil.get(k) && indexXMil.get(k) <= galaxies.get(j)[0]) || (galaxies.get(i)[0] >= indexXMil.get(k) && indexXMil.get(k) >= galaxies.get(j)[0])){
                        sum+= 999999;
                    }
                }
                for(int k = 0; k < indexYMil.size(); k++){
                    if((galaxies.get(i)[1] <= indexYMil.get(k) && indexYMil.get(k) <= galaxies.get(j)[1]) || (galaxies.get(i)[1] >= indexYMil.get(k) && indexYMil.get(k) >= galaxies.get(j)[1])){
                        sum+= 999999;
                    }
                }
                sum += ((Math.abs(galaxies.get(i)[0] - galaxies.get(j)[0])) + (Math.abs(galaxies.get(i)[1] - galaxies.get(j)[1])));
            }
        }
        return sum;
    }
}
package Main.DailyFiles;

import java.util.ArrayList;
import Main.Runner;
import java.util.Arrays;

public class Advent7 {
    public static int main() {
        ArrayList<String> inputString = Runner.readFile(7);
        int[][] cardArray = new int[inputString.size()][5];
        int[][] valueArray = new int[cardArray.length][5]; // card score, bet, parallelizer, set score, joke
        for (int i = 0; i < inputString.size(); i++) {
            char[] temp = inputString.get(i).substring(0, inputString.get(i).indexOf(" ")).toCharArray();
            valueArray[i][1] = Integer.valueOf(inputString.get(i).substring(inputString.get(i).indexOf(" ") + 1));
            for (int j = 0; j < temp.length; j++) {
                switch (temp[j]) {
                    case 'T':
                        cardArray[i][j] = 10;
                        break;
                    case 'J':
                        cardArray[i][j] = 1;
                        break;
                    case 'Q':
                        cardArray[i][j] = 12;
                        break;
                    case 'K':
                        cardArray[i][j] = 13;
                        break;
                    case 'A':
                        cardArray[i][j] = 14;
                        break;
                    default:
                        cardArray[i][j] = Integer.parseInt(String.valueOf(temp[j]));
                }
            }
        }
        for (int i = 0; i < cardArray.length; i++) {
            int antiJ = 4;
            for (int j = 0; j < cardArray[i].length; j++) {
                if (cardArray[i][j] == 1) {
                    valueArray[i][4] = 1;
                }
                valueArray[i][0] += ((cardArray[i][j]) * Math.pow(10, (antiJ * 2)));
                valueArray[i][2] = i;
                antiJ--;
            }
            valueArray[i][3] = score(cardArray[valueArray[i][2]], valueArray[i][4]);
        }
        Arrays.sort(valueArray, (a, b) -> Double.compare(a[0], b[0]));
        Arrays.sort(valueArray, (a, b) -> Double.compare(a[3], b[3]));
        int sum = 0;
        for (int i = 0; i < valueArray.length; i++) {
            sum += ((i + 1) * valueArray[i][1]);
        }
        return sum;
    }

    public static int score(int[] cards, int joker) {
        if (Arrays.stream(cards).distinct().count() < 5 || joker == 1) {
            int[][] cardCount = new int[4][4];
            int jokeCount = 0;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] != 1) {
                    if (cardCount[0][0] == 0) {
                        cardCount[0][0] = cards[i];
                    } else if (cardCount[1][0] == 0 && cards[i] != cardCount[0][0]) {
                        cardCount[1][0] = cards[i];
                    } else if (cardCount[2][0] == 0 && cards[i] != cardCount[0][0] && cards[i] != cardCount[1][0]) {
                        cardCount[2][0] = cards[i];
                    } else if (cardCount[3][0] == 0 && cards[i] != cardCount[0][0] && cards[i] != cardCount[1][0]
                            && cards[i] != cardCount[2][0]) {
                        cardCount[3][0] = cards[i];
                    }
                    if (cardCount[0][0] == cards[i]) {
                        cardCount[0][1]++;
                    } else if (cardCount[1][0] == cards[i]) {
                        cardCount[1][1]++;
                    } else if (cardCount[2][0] == cards[i]) {
                        cardCount[2][1]++;
                    } else if (cardCount[3][0] == cards[i]) {
                        cardCount[3][1]++;
                    }
                } else {
                    jokeCount++;
                }
            }
            if ((cardCount[0][1] + jokeCount) == 5) {
                return 6;
            } else if ((cardCount[0][1] + jokeCount) == 4 || (cardCount[1][1] + jokeCount) == 4) { // 4 of a kind
                return 5;
            } else if (((cardCount[0][1] + jokeCount) == 3 && cardCount[1][1] == 2)
                    || (cardCount[0][1] == 2 && (cardCount[1][1] + jokeCount) == 3)) { // full house
                return 4;
            } else if ((cardCount[0][1] + jokeCount) == 3 || (cardCount[1][1] + jokeCount) == 3
                    || (cardCount[2][1] + jokeCount) == 3) { // 3 of a kind
                return 3;
            } else if (cardCount[3][1] == 0
                    || (jokeCount > 0 && (cardCount[0][1] == 2 || cardCount[1][1] == 2 || cardCount[2][1] == 2))) { // 2
                return 2;
            } else { // one pair (only option left)
                return 1;
            }
        }
        return 0;
    }
}
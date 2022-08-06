import java.util.Scanner;

public class Nato {
    private final String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private final String[] natoAlphabet = {"alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel", "india", "juliett", "kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango", "uniform", "victor", "whiskey", "xray", "yankee", "zulu", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};

    private int randomIndex;
    private int points;

    private int getNatoIndex(String word) {
        for (int i = 0; i < natoAlphabet.length; i++) {
            if (natoAlphabet[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private String getInputWord() {
        Scanner inputWord = new Scanner(System.in);
        return inputWord.nextLine().toLowerCase();
    }

    private void setRandomIndex() {
        randomIndex = (int) (Math.random() * alphabet.length);
    }
    private int getRandomIndex() {
        return randomIndex;
    }

    private void randomize() {
        setRandomIndex();
    }

    private String getRandomLetter() {
        return alphabet[getRandomIndex()];
    }

    private void showRandomLetter() {
        System.out.printf("What is the word for the symbol %s (to exit type exit): ", getRandomLetter());
    }

    private void showCurrentPoints() {
        System.out.printf("Your current points are: %d%n%n", points);
    }

    private String getNatoWord() {
        return natoAlphabet[randomIndex];
    }

    public boolean play() {
        randomize();
        showRandomLetter();
        String inputWord = getInputWord();

        if (inputWord.equals("exit")) return false;

        if (getNatoIndex(inputWord) == getRandomIndex()) {
            System.out.printf("%nHooray!%n");
            points++;
        } else {
            System.out.printf("%nThat's wrong. The correct answer is %s.%n", getNatoWord());
            points--;
        }

        showCurrentPoints();
        return true;
    }
}

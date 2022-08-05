import java.util.Scanner;

public class Nato {
    private String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private String[] nato_alphabet = {"alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel", "india", "juliett", "kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango", "uniform", "victor", "whiskey", "xray", "yankee", "zulu", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};

    private int random_index;
    private int points;

    private int get_nato_index(String word) {
        for (int i = 0; i < nato_alphabet.length; i++) if (nato_alphabet[i].equals(word)) return i;
        return -1;
    }

    private String get_input_word() {
        Scanner input_word = new Scanner(System.in);
        return input_word.nextLine().toLowerCase();
    }

    private void set_random_index() {
        random_index = (int) (Math.random() * alphabet.length);
    }
    private int get_random_index() {
        return random_index;
    }

    private void randomize() {
        set_random_index();
    }

    private String get_random_letter() {
        return alphabet[get_random_index()];
    }

    private void show_random_letter() {
        System.out.printf("What is the word for the symbol %s (to exit type exit): ", get_random_letter());
    }

    private void increase_points() {
        points++;
    }

    private void decrease_points() {
        points--;
    }

    private void show_current_points() {
        System.out.printf("Your current points are: %d%n%n", points);
    }

    private String get_nato_word() {
        return nato_alphabet[random_index];
    }

    public boolean play() {
        randomize();
        show_random_letter();
        String input_word = get_input_word();

        if (input_word.equals("exit")) return false;

        if (get_nato_index(input_word) == get_random_index()) {
            System.out.printf("%nHooray!%n");
            increase_points();
        } else {
            System.out.printf("%nThat's wrong. The correct answer is %s.%n", get_nato_word());
            decrease_points();
        }

        show_current_points();
        return true;
    }
}

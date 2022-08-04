public class Main {
    private static boolean play = true;

    public static void main(String args[]) {
        Nato nato = new Nato();

        while (play) {
            play = nato.play();
        }
    }
}

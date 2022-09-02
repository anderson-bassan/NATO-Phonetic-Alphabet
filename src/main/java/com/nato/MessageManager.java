package com.nato;

public class MessageManager {
    public final String INTRO_MESSAGE;
    public final String CURRENT_POINTS_MESSAGE;
    public final String FINAL_POINTS_MESSAGE;

    public final String WIN_MESSAGE;
    public final String LOSE_MESSAGE;
    public final String LOSE_BY_TIMEOUT_MESSAGE;
    public final String EXIT_MESSAGE;
    public final String TIME_OUT_MESSAGE;

    public MessageManager() {
        this.INTRO_MESSAGE = """
                <html>
                    <p>Welcome to NATO Phonetic Alphabet!</p><br>
                    <br>
                    <p>This is a game to help you learn the NATO Phonetic Alphabet while having fun. You have 2 seconds to type the word equivalent to the letter shown, otherwise you'll lose. If you guess all words correctly, then you win the game.</p><br>
                    <p>The main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this program on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_ and u/geoffreychallen.</p><br>
                    <p>my post link: <a href="">https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/</p><br>
                    <br>
                    <p>Enjoy!</p><br>
                    <br>
                    <p style="text-align: right">- Created by Anderson Bassan</p>
                    <br>
                    <br>
                    <p style="text-align: center">[PRESS ENTER TO START]</p>
                </html>
                """;

        this.CURRENT_POINTS_MESSAGE = "your current points are";
        this.FINAL_POINTS_MESSAGE = "you finished with a score of";
        this.WIN_MESSAGE = "you own";
        this.LOSE_MESSAGE = "game over";
        this.LOSE_BY_TIMEOUT_MESSAGE = "you lost by timeout";
        this.EXIT_MESSAGE = "exit";
        this.TIME_OUT_MESSAGE = "time out";
    }
}

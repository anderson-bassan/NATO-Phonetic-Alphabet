package com.nato;

public class TextManager {
    public final String INTRO;
    public final String CURRENT_POINTS_MESSAGE;
    public final String FINAL_POINTS_MESSAGE;

    public final String WIN_MESSAGE;
    public final String LOSE_MESSAGE;
    public final String LOSE_BY_TIMEOUT_MESSAGE;
    public final String EXIT_MESSAGE;
    public final String TIME_OUT_MESSAGE;

    public TextManager() {
        this.INTRO = """
                
                
                \tWelcome to NATO Phonetic Alphabet!
                
                \tThis is a game to help you learn the NATO Phonetic Alphabet while having fun.
                \tYou have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.
                \tIf you guess all words correctly, then you win the game.
                
                
                \tThe main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this
                \tprogram on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_
                \tand u/geoffreychallen.
                
                \tmy post link: https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/
                
                \tEnjoy!
                \t
                                                                                               - coded by Anderson Bassan
                \t                                       [ PRESS ENTER  TO START ]
                                                                                             
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

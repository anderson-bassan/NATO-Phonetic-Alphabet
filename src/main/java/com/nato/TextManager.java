package com.nato;

public class TextManager {
    String introText;

    public TextManager() {
        this.introText = """
                
                
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
    }

    public String getIntroText() {
        return this.introText;
    }
}

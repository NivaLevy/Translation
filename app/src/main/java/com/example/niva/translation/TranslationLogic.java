package com.example.niva.translation;

import java.util.Random;

/**
 * Created by Niva on 05/04/2016.
 */
public class TranslationLogic {

    private String [][] words;
    private final int N = 5, ANSWER = 1, QUESTION = 0;
    private int iterator = 0, right = 0, wrong = 0;

    public TranslationLogic() {
        words = new String[N][2];
        generateWords();
    }


    private void generateWords() {

        words[0][0] = "כואב";
        words[0][1] = "excruciating";

        words[1][0] = "חתול";
        words[1][1] = "cat";

        words[2][0] = "חקלאות";
        words[2][1] = "agriculture";

        words[3][0] = "מנוע";
        words[3][1] = "engine";


        words[4][0] = "רהיטים";
        words[4][1] = "furniture";

    }

    public String getNext(){
        Random r = new Random();
        iterator = r.nextInt(N);
        return words[iterator][QUESTION];
    }

    public boolean report(String answer){
        if (answer.equals(words[iterator][ANSWER])){
            right++;
            return true;
        }
        wrong++;
        return false;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    public String getAns() {
        return words[iterator][ANSWER];
    }
}

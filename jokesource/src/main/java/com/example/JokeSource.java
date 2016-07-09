package com.example;

import java.util.Random;

public class JokeSource {

    private Random random = new Random();

    public String getJoke(){
        String joke;
        switch(random.nextInt(3)){
            case 0:{
                joke = "9 out of 10 voices in my head are telling me that I am too fat. The last one is calmly preparing a bowl of chips.";
                break;
            }
            case 1:{
                joke = "Farting in a lift is wrong on so many levels!";
                break;
            }
            default:{
                joke = "If you start to think I talk too much, just tell me. We’ll talk about it.";
                break;
            }
        }
        return joke;
    }

}

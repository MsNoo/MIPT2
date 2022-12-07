package com.example.mipt2.calc;

import android.content.Context;
import android.widget.Toast;

public class Calc {
    public static int getSymbolsCount(String phrase){
        return phrase.length();
    }

    public static int getWordsCount(String phrase){
        String words = phrase.trim();
        if (words.isEmpty()){
            return 0;
        }
        else{
            return words.split("\\s+").length;
        }
    }
}

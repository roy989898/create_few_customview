package com.example.pomingpo.few_customview;

/**
 * Created by roy.leung on 29/1/2018.
 */

public class Util {
    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}

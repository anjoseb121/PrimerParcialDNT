package com.ajbe.primerparcialdnt.utils;

/**
 * Created by HP on 3/15/2017. For UAC
 */

public class RandomUtils {
    /* * returns random integer between minimum and maximum range */
    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}

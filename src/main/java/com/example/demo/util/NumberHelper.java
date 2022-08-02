package com.example.demo.util;

import java.time.temporal.TemporalAmount;
import java.util.Random;

public class NumberHelper {
    public static TemporalAmount generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

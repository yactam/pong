package com.next.pong.utils;

public class MathUtils {

    public static double clamp(double min, double value, double max) {
        if (min > max) {
            throw new IllegalArgumentException("min (" + min + ") cannot be larger than max (" + max + ")");
        }

        return Math.max(min, Math.min(value, max));
    }

}

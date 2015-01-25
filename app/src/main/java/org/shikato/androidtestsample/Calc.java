package org.shikato.androidtestsample;

import java.lang.Integer;
import java.lang.NumberFormatException;
import java.lang.String;

public class Calc {

    public static int add(int num1, int num2) throws NumberFormatException {
        return num1 + num2;
    }

    public static int add(String num1Str, String num2Str) throws NumberFormatException {
        int num1 = Integer.parseInt(num1Str.trim());
        int num2 = Integer.parseInt(num2Str.trim());
        return num1 + num2;
    }
}


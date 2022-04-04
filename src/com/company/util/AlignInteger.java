package com.company.util;

public class AlignInteger {
    public static int alignInteger(int number, int alignedTo){
        return number - (number % alignedTo);
    }
}

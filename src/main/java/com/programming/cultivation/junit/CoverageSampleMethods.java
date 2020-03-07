package com.programming.cultivation.junit;

public class CoverageSampleMethods {

    public Boolean testMethod(int a, int b, int c) {
        boolean result = false;
        if (a == 1 && b == 2 || c == 2) {
            result = true;
        }
        return result;
    }
}

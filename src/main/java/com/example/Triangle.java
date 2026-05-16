package com.example;


public class Triangle {

    public static String typeTriangle(int a, int b, int c) {
        if (a == b && b == c)
            return "Equilateral";
        if (a == b || b == c || a == c)
            return "Isosceles";
        return "Scalene";
    }
}
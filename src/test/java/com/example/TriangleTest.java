package test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testEquilateral() {
        assertEquals("Equilateral", Triangle.typeTriangle(3,3,3));
    }

    @Test
    public void testIsosceles() {
        assertEquals("Isosceles", Triangle.typeTriangle(3,3,4));
    }

    @Test
    public void testScalene() {
        assertEquals("Scalene", Triangle.typeTriangle(3,4,5));
    }
}
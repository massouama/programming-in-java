package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        Rectangle rectangle = new Rectangle(5, 10); // Assuming your Rectangle takes width and height as parameters
        double expectedArea = 50; // Area = width * height
        assertEquals(expectedArea, rectangle.area(), "The area should be width times height.");
    }

    @Test
    void perimeter() {
        Rectangle rectangle = new Rectangle(5, 10); // Assuming your Rectangle takes width and height as parameters
        double expectedPerimeter = 30; // Perimeter = 2 * (width + height)
        assertEquals(expectedPerimeter, rectangle.perimeter(), "The perimeter should be twice the sum of width and height.");
    }
}
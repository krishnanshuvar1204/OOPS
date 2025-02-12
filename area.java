import java.util.*;
public class areacalculator
 {
    public static double calculateArea(double l, double w)
    {
        return l*w;
    }
    public static double calculateArea(double side)
    {
        return side * side;
    }
    public static double calculateArea(float radius)
    {
        double i = 3.14;
        return i * radius * radius;
    }
    public static double calculateArea(double base, double height, boolean isTriangle) 
    {
        return 0.5 * base * height;
    }

    public static void main(String[] args)
    {
        double Length = 10,Width = 5;
        System.out.println("Area of Rectangle: " + calculateArea(Length,Width));

        double squareSide = 4;
        System.out.println("Area of Square: " + calculateArea(squareSide));

        float circleRadius = 7;
        System.out.println("Area of Circle: " + calculateArea(circleRadius));

        double triangleBase = 8, triangleHeight = 6;
        System.out.println("Area of Triangle: " + calculateArea(triangleBase, triangleHeight, true));
    }
}
package by.stn.java_exercises.modul_1.ex_7_fixed;

import java.util.ArrayList;
import java.util.List;

public class PlacementChecker {
    public static void main(String[] args) {
        Rectangle shape1 = new Rectangle(1, 0.1);
        Rectangle shape2 = new Rectangle(0.91, 2);
        Rectangle shapeContainer = new Rectangle(2, 1);
        System.out.println("It's " + check(shape1, shape2, shapeContainer) + " that figures are fit");
    }

    public static boolean check(Rectangle shape1, Rectangle shape2, Rectangle shapeContainer) {
        List<Rectangle> freeSpace;
        //метод проверки, поворот фигур
        if (fits(shape1, shapeContainer)) {
            freeSpace = placeShape(shape1, shapeContainer);
            return fits(shape2, freeSpace.get(0)) || fits(shape2, freeSpace.get(1));
        } else if (fits(reverseShape(shape1), shapeContainer)) {
            freeSpace = placeShape(shape1, shapeContainer);
            return fits(shape2, freeSpace.get(0)) || fits(shape2, freeSpace.get(1));
        } else
            return false;
    }

    private static boolean fits(Rectangle shape, Rectangle rectangle) {
        return shape.getSideA() <= rectangle.getSideA() && shape.getSideB() <= rectangle.getSideB();
    }

    private static Rectangle reverseShape(Rectangle shape) {
        shape.reverse(shape.getSideA(), shape.getSideB());
        return shape;
    }

    private static ArrayList<Rectangle> placeShape(Rectangle shape, Rectangle rectangle) {
        List<Rectangle> freeSpace = new ArrayList<>();
        freeSpace.add(new Rectangle(rectangle.getSideA() - shape.getSideA(), rectangle.getSideB()));
        freeSpace.add(new Rectangle(rectangle.getSideB() - shape.getSideB(), rectangle.getSideA()));
        return (ArrayList<Rectangle>) freeSpace;
    }
}
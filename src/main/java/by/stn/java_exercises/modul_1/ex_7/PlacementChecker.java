package by.stn.java_exercises.modul_1.ex_7;

import java.util.ArrayList;
import java.util.List;

public class PlacementChecker {
    public static boolean check(Rectangle shape1, Rectangle shape2, Rectangle shapeContainer) {
        if (fits(shape1, shapeContainer)) {
            return fitsInEmptySpace(shape2,placeShape(shape1, shapeContainer));
        } else if (fits(shape1.reverse(), shapeContainer)) {
            return fitsInEmptySpace(shape2,placeShape(shape1, shapeContainer));
        } else
            return false;
    }

    private static boolean fits(Rectangle shape, Rectangle shapeContainer) {
        return shape.getSideA() <= shapeContainer.getSideA() && shape.getSideB() <= shapeContainer.getSideB();
    }

    private static boolean fitsInEmptySpace(Rectangle shape, List<Rectangle> emptySpace) {
        return fits(shape, emptySpace.get(0)) || fits(shape, emptySpace.get(1));
    }

    private static List<Rectangle> placeShape(Rectangle shape, Rectangle rectangle) {
        List<Rectangle> emptySpace = new ArrayList<>();
        emptySpace.add(new Rectangle(rectangle.getSideA() - shape.getSideA(), rectangle.getSideB()));
        emptySpace.add(new Rectangle(rectangle.getSideB() - shape.getSideB(), rectangle.getSideA()));
        return emptySpace;
    }

    public static void main(String[] args) {
        Rectangle shape1 = new Rectangle(1, 0.1);
        Rectangle shape2 = new Rectangle(0.9, 2);
        Rectangle shapeContainer = new Rectangle(2, 1);
        System.out.println("It's " + check(shape1, shape2, shapeContainer) + " that figures do fit");
    }
}
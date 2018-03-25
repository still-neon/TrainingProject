package by.stn.java_exercises.modul_1.ex_7_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/7/2018.
 */
public class Rectangle {
    @Getter
    private double sideA;
    @Getter
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = Math.max(sideA, sideB);
        this.sideB = Math.min(sideA, sideB);
    }

    public Rectangle reverse() {
        double tempSide = sideA;
        sideA = sideB;
        sideB = tempSide;
        return this;
    }
}
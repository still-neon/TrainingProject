package by.stn.java_exercises.modul_1.ex_7_need_fix;

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

    public void reverse(double sideA, double sideB) {
        this.sideA = sideB;
        this.sideB = sideA;
    }
}
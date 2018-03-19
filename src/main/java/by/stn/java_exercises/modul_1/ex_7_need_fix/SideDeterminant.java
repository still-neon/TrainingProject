package by.stn.java_exercises.modul_1.ex_7_need_fix;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/7/2018.
 */
public class SideDeterminant {
    @Getter
    private double firstMax;
    @Getter
    private double firstMin;
    @Getter
    private double secondMax;
    @Getter
    private double secondMin;
    @Getter
    private double rectMax;
    @Getter
    private double rectMin;

    public SideDeterminant(double aSide, double bSide, double cSide, double dSide, double eSide, double fSide) {
        firstMax = Math.max(aSide, bSide);
        firstMin = Math.min(aSide, bSide);
        secondMax = Math.max(cSide, dSide);
        secondMin = Math.min(cSide, dSide);
        rectMax = Math.max(eSide, fSide);
        rectMin = Math.min(eSide, fSide);
    }
}
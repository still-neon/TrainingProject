package by.stn.java_exercises.modul_1.ex_7_fixed;

public class PlacementChecker {
    //входные параметры

    public static void main(String[] args) {
        System.out.println("It's " + check(1, 0.1, 2, 0.9, 2, 1) + " that figures are fit");
    }

    public static boolean check(double aSide, double bSide, double cSide, double dSide, double eSide, double fSide) {
        SideDeterminant sc = new SideDeterminant(aSide, bSide, cSide, dSide, eSide, fSide);

        //сделать с условиями в одном классе, или в конструкторе, названия сторон, класс ректангл

        if ((sc.getFirstMin() + sc.getSecondMin()) <= sc.getRectMin() && Math.max(sc.getFirstMax(), sc.getSecondMax()) <= sc.getRectMax())
            return true;
        else if ((sc.getFirstMin() + sc.getSecondMax()) <= sc.getRectMin() && Math.max(sc.getFirstMax(), sc.getSecondMin()) <= sc.getRectMax())
            return true;
        else if ((sc.getFirstMin() + sc.getSecondMax()) <= sc.getRectMax() && Math.max(sc.getFirstMax(), sc.getSecondMin()) <= sc.getRectMin())
            return true;
        else if ((sc.getFirstMax() + sc.getSecondMax()) <= sc.getRectMin() && Math.max(sc.getFirstMin(), sc.getSecondMin()) <= sc.getRectMax())
            return true;
        else if ((sc.getFirstMin() + sc.getSecondMin()) <= sc.getRectMax() && Math.max(sc.getFirstMax(), sc.getSecondMax()) <= sc.getRectMin())
            return true;
        else if ((sc.getFirstMax() + sc.getSecondMax()) <= sc.getRectMax() && Math.max(sc.getFirstMin(), sc.getSecondMin()) <= sc.getRectMin())
            return true;
        else if ((sc.getFirstMax() + sc.getSecondMin()) <= sc.getRectMax() && Math.max(sc.getFirstMin(), sc.getSecondMax()) <= sc.getRectMin())
            return true;
        else if ((sc.getFirstMax() + sc.getSecondMin()) <= sc.getRectMin() && Math.max(sc.getFirstMin(), sc.getSecondMax()) <= sc.getRectMax())
            return true;
        else
            return false;
    }
}
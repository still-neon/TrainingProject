package by.stn.trainingproject.combinationcounter;

import lombok.Getter;

public class InheritanceInitializationTask implements Printable {

    private Zopa zo = new Zopa();

    public Zopa getZo() {
        return zo;
    }

    private class Zopa implements Comparable<Integer>, Printable {
        private int val = 18;

        public Zopa() {
            val = 33;
        }

        @Override
        public int compareTo(Integer o) {
            return 14;
        }

        {
            val = 47;
        }

        @Override
        public void print() {
            System.out.println(val);
            val = compareTo(null);
        }
    }

    private static class Zulu implements Comparable<Integer>, Printable {
        private int val = 17;

        @Override
        public int compareTo(Integer o) {
            return -o.compareTo(val);
        }

        static {
            System.out.println(48);
        }

        @Override
        public void print() {

        }
    }

    private static class Sigma extends Zulu {
        @Override
        public int compareTo(Integer o) {
            return super.compareTo(o) + 5;
        }
    }

    private static void process(Printable p) {
        p.print();
    }

    private static void process(Zulu z) {
        System.out.println(112);
    }

    private interface Printable {
        void print();
    }

    public static void main(String[] args) {
        InheritanceInitializationTask iit = new InheritanceInitializationTask();
        Zopa zo = new iit.getZo();
        Zulu zu = new Zulu();
        Sigma s = new Sigma();

    }
}

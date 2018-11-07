package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

public enum Goods {
    BREAD("Bread"), MILK("Milk"), COFFEE("Coffee"), WATER("Water"), BEER("Beer"), MEAT("Meat");

    @Getter
    private String name;

    Goods(String name) {
        this.name = name;
    }
}
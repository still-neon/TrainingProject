package by.stn.java_exercises.modul_2.ex_1;

import lombok.Getter;

import java.util.List;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public class Customer {
    @Getter
    private List<String> goods;

    public Customer(List<String> goods) {
        this.goods = goods;
    }
}
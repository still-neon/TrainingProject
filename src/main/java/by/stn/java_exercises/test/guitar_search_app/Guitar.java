package by.stn.java_exercises.test.guitar_search_app;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public class Guitar {
    @Getter
    private String serialNumber;
    @Getter
    @Setter
    private double price;
    @Getter
    private GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }
}
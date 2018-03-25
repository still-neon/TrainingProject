package by.stn.java_exercises.test.guitar_search_app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public class Inventory {
    List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, int numString, Wood backWood, Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, new GuitarSpec(builder, model, type, numString, backWood, topWood));
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();

            if (guitar.getSpec().matches(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}
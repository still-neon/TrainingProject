package by.stn.java_exercises.test.guitar_search_app;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public class GuitarSpec {
    @Getter
    private Builder builder;
    @Getter
    private String model;
    @Getter
    private Type type;
    @Getter
    private Wood backWood;
    @Getter
    private Wood topWood;
    @Getter
    private int numString;

    public GuitarSpec(Builder builder, String model, Type type, int numString,
                      Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.numString = numString;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matches(GuitarSpec otherSpec) {
        if (builder != otherSpec.getBuilder())
            return false;
        if ((model != null) && (!model.equals("")) &&
                (!model.equals(otherSpec.getModel())))
            return false;
        if (type != otherSpec.getType())
            return false;
        if (numString != otherSpec.getNumString())
            return false;
        if (backWood != otherSpec.getBackWood())
            return false;
        if (topWood != otherSpec.getTopWood())
            return false;
        return true;
    }
}
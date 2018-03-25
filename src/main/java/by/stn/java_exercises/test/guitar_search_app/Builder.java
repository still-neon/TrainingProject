package by.stn.java_exercises.test.guitar_search_app;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    @Override
    public String toString() {
        switch(this) {
            case FENDER:   return "Fender";
            case MARTIN:   return "Martin";
            case GIBSON:   return "Gibson";
            case COLLINGS: return "Collings";
            case OLSON:    return "Olson";
            case RYAN:     return "Ryan";
            case PRS :     return "PRS";
            default:       return "Unspecified";
        }
    }
}

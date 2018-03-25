package by.stn.java_exercises.test.guitar_search_app;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "acoustic";
            case ELECTRIC:
                return "electric";
            default:       return "unspecified";
        }
    }
}

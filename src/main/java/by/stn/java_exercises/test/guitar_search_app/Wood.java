package by.stn.java_exercises.test.guitar_search_app;

/**
 * Created by EugenKrasotkin on 3/23/2018.
 */
public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
    COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

    @Override
    public String toString() {
        switch(this) {
            case INDIAN_ROSEWOOD:    return "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
            case MAHOGANY:           return "Mahogany";
            case MAPLE:              return "Maple";
            case COCOBOLO:           return "Cocobolo";
            case CEDAR:              return "Cedar";
            case ADIRONDACK:         return "Adirondack";
            case ALDER:              return "Alder";
            case SITKA:              return "Sitka";
            default:  return "unspecified";
        }
    }
}

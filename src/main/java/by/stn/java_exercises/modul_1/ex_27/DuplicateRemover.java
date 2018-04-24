package by.stn.java_exercises.modul_1.ex_27;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LockDog on 09.04.2018.
 */
public class DuplicateRemover {
    public static List<Integer> remove(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }
}
package by.stn.trainingproject.counter.console;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class InputConsole {
    public static void main(String[] args) {
        char[] buf = new char[10];
        int counter = 0;

        System.out.println("Enter from 0 to 10 symbols:");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in),0);
            is.read(buf);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        for(char ch:buf) {
            if(ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) counter++;
        }
        System.out.println("You entered " + counter + " letters");
    }
}
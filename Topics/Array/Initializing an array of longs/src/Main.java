import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        long[] longNumbers = new long[3];
        longNumbers[0] = 100_000_000_001L;
        longNumbers[1] = 100_000_000_002L;
        longNumbers[2] = 100_000_000_003L;

        System.out.println(Arrays.toString(longNumbers));
    }
}
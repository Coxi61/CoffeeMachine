import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        final int lowWeekdayRange = 10;
        final int highWeekdayRange = 20;
        final int lowWeekendRange = 15;
        final int highWeekendRange = 25;

        Scanner scanner = new Scanner(System.in);
        int peanut = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        System.out.println(
                (isWeekend && lowWeekendRange <= peanut && peanut <= highWeekendRange) ||
                        (!isWeekend && lowWeekdayRange <= peanut && peanut <= highWeekdayRange)
        );

    }
}
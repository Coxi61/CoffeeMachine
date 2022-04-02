import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();

        long firstFactorial = 1;

        int n = 1;
        do {
            n++;
            firstFactorial = Math.multiplyExact(firstFactorial, n);
        } while (firstFactorial <= m);

        System.out.println(n);

    }
}


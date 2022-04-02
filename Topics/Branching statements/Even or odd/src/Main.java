import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        while (true) {
            i = scanner.nextInt();
            if (i == 0) {
                break;
            } else {
                System.out.println((i % 2 == 0) ? "even" : "odd");
            }

        }

    }
}
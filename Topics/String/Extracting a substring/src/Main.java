import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        if (0 <= from && from <= str.length() && 0 <= to && to <= str.length()) {
            System.out.println(str.substring(from, to + 1));
        } else {
            System.out.println("invalid input");
        }

    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int i = 1;
        int x = 1;
        int[] sequence = new int[n];

        while (x <= n) {
            sequence[i - 1] = x;
            i++;
            x = i * i;
        }
        i -= 1;


        for (int j = 0; j <= i - 1; j++) {
            System.out.println(sequence[j]);
        }

        System.out.println();
        System.out.println(sequence.toString());
    }
}
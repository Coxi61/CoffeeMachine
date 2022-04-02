import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // ex. n = 7

        int count = 0; //for transversal cycle independent from inner FOR cycle and outer FOR cycle
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                count++;
                if (count < n) {
                    System.out.print(i + " ");
                } else if (count == n) {
                    System.out.print(i);    //no space for the last printed number
                } else {
                    break;
                }

            }

        }


    }
}
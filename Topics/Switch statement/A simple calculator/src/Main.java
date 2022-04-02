import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        char op = scanner.next().charAt(0);
        long b = scanner.nextLong();

        long result = 0;
        boolean error = false;
        switch (op) {
            case '+' :
                result = a + b;
                break;
            case '-' :
                result = a - b;
                break;
            case '/' :
                if (b == 0) {
                    System.out.print("Division by 0!");
                    error = true;
                } else {
                    result = a / b;
                }
                break;
            case '*' :
                result = a * b;
                break;
            default:
                System.out.print("Unknown operator");
                error = true;
                break;
        }

        if (!error) {
            System.out.print(result);
        }




    }
}
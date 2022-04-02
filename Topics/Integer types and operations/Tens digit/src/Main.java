
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        final int tensDigitPlace = 2;
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        String numberInString = Integer.toString(inputNumber);
        //System.out.println("numberInString = " + numberInString);
        int numberOfDigit = numberInString.length();
        //System.out.println(numberOfDigit);
        if (numberOfDigit >= tensDigitPlace) {
            char tensDigit = numberInString.substring(numberOfDigit - 2, numberOfDigit - 1).charAt(0);
            System.out.println(tensDigit);
        } else {
            System.out.println("0");
        }
        //System.out.println("tensDigit = " + tensDigit);

    }
}
import java.util.Scanner;
import java.util.StringTokenizer;

//trick : percentage calculation and result of division has to use FLOAT variables
//otherwise it will yield proper result
//floats should be compared by Float.compare(fatMoney, targetF) built in method
class Main {

    static int baseMoney;
    static int yearlyPercent;
    static int target;
    static double targetF;

    static double fatMoney = 0;
    static int year = 0;

    public static void main(String[] args) {

        //inputs
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        StringTokenizer token = new StringTokenizer(inputString);

        baseMoney = Integer.parseInt(token.nextToken());
        yearlyPercent = Integer.parseInt(token.nextToken());
        target = Integer.parseInt(token.nextToken());
        targetF = target;

        int counter = 0;
        fatMoney = baseMoney;
        while (Double.compare(fatMoney, targetF) < 0) {
            fatMoney = fatMoney + (yearlyPercent * (fatMoney / 100));
            counter++;
        }

        year = counter;

        //show result
        System.out.println(year);


    }



}
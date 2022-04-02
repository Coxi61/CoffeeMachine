import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        final int highNoArmy = 1;
        final int lowPack = 1;
        final int highPack = 19;
        final int lowThrong = 20;
        final int highThrong = 249;
        final int lowZounds = 250;
        final int highZounds = 999;
        final int lowLegion = 1000;

        Scanner scanner = new Scanner(System.in);
        int unit = scanner.nextInt();
        String unitName = "unknown";

        if (unit < highNoArmy) {
            unitName = "no army";
        } else if (lowPack <= unit && unit <= highPack) {
            unitName = "pack";
        } else if (lowThrong <= unit && unit <= highThrong) {
            unitName = "throng";
        } else if (lowZounds <= unit && unit <= highZounds) {
            unitName = "zounds";
        } else if (lowLegion <= unit) {
            unitName = "legion";
        }
        System.out.println(unitName);
    }
}
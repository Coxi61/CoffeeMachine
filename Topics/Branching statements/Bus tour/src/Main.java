import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int bridgeNumber = scanner.nextInt();

        //System.out.println("busHeight = " + busHeight + ", bridgeNumber = " + bridgeNumber);

        int crashBridgeIndex = -1;
        int[] bridgeHeights = new int[bridgeNumber];

        for (int i = 0; i < bridgeNumber; i++) {
            bridgeHeights[i] = scanner.nextInt();
            //System.out.printf("bridgeHeights[%d] = %d, ", i, bridgeHeights[i]);

            if (bridgeHeights[i] <= busHeight) {
                crashBridgeIndex = i;
                break;
            }
        }

        if (crashBridgeIndex < 0) {
            System.out.println("Will not crash");
        } else {
            System.out.printf("Will crash on bridge %d", crashBridgeIndex + 1);
        }

    }
}
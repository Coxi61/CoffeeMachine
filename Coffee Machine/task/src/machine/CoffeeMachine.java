
package machine;

import java.util.Scanner;


public class CoffeeMachine {
        public static void main(String[] args) {
                StatesBasedMachine SBM = new StatesBasedMachine();
                SBM.initializeMachine();
                SBM.fill(400,540,120,9, 550);
                SBM.promptWaitForWhat();
                Scanner scanner = new Scanner(System.in);

                //before the very first input, constructor will print the proper request for information

                boolean willBeNextInput = true;
                String input;
                while (willBeNextInput) {
                        input = scanner.next();
                        willBeNextInput = SBM.processInput(input);
                }

        }

}

enum MachineStates {
        WAIT_FOR_ACTION,
        WAIT_FOR_BUYTYPE,
        WAIT_FOR_FILL_WATER,
        WAIT_FOR_FILL_MILK,
        WAIT_FOR_FILL_BEAN,
        WAIT_FOR_FILL_CUPPVC
}







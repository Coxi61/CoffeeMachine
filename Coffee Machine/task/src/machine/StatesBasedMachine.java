package machine;

public class StatesBasedMachine {


    //constants
    final static int ESPRESSO_WATER_PER_CUP = 250;
    //final int ESPRESSO_MILK_PER_CUP = 0;
    final static int ESPRESSO_BEAN_PER_CUP = 16;
    final static int ESPRESSO_PRICE = 4;

    final static int LATTE_WATER_PER_CUP = 350;
    final static int LATTE_MILK_PER_CUP = 75;
    final static int LATTE_BEAN_PER_CUP = 20;
    final static int LATTE_PRICE = 7;

    final static int CAPPUCCINO_WATER_PER_CUP = 200;
    final static int CAPPUCCINO_MILK_PER_CUP = 100;
    final static int CAPPUCCINO_BEAN_PER_CUP = 12;
    final static int CAPPUCCINO_PRICE = 6;


    int water;
    int milk;
    int bean;
    int cupPvc;
    int money;

    int cupFromWater;
    int cupFromMilk;
    int cupFromBean;
    int maxPossibleCup;
    int cupDiscrepancy;

    String action; //buy, fill, take, remaining, exit
    String coffeeType; //1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu

    MachineStates ms = MachineStates.WAIT_FOR_ACTION;


    public void promptWaitForWhat() {
        switch (this.ms) {
            case WAIT_FOR_ACTION:
                System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
                break;
            case WAIT_FOR_BUYTYPE:
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
                break;
            case WAIT_FOR_FILL_WATER:
                System.out.print("Write how many ml of water you want to add:\n> ");
                break;
            case WAIT_FOR_FILL_MILK:
                System.out.print("Write how many ml of milk you want to add:\n> ");
                break;
            case WAIT_FOR_FILL_BEAN:
                System.out.print("Write how many grams of coffee beans you want to add:\n> ");
                break;
            case WAIT_FOR_FILL_CUPPVC:
                System.out.print("Write how many disposable cups of coffee you want to add:\n> ");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.ms);
        }
    }

    public static void showParameter(String s) {
        System.out.println("received parameter : " + s);
    }


    public boolean processInput(String input) {

        showParameter(input);
        boolean returnWillBeNextInput = true;
        if (this.ms == MachineStates.WAIT_FOR_ACTION) {
            switch (input) {
                case "fill":
                    this.action = "fill";
                    this.ms = MachineStates.WAIT_FOR_FILL_WATER;
                    break;
                case "buy":
                    this.action = "buy";
                    this.ms = MachineStates.WAIT_FOR_BUYTYPE;
                    break;
                case "take":
                    this.action = "take";
                    //this.ms = MachineStates.WAIT_FOR_ACTION;
                    this.takeMoney();
                    break;
                case "remaining":
                    this.action = "remaining";
                    //this.ms = MachineStates.WAIT_FOR_ACTION;

                    this.showStoke();
                    break;
                case "exit":
                    this.action = "exit";
                    //this.ms = MachineStates.WAIT_FOR_ACTION;
                    returnWillBeNextInput = false;
                    break;
                default:
                    throw new IllegalStateException("unexpected input in WAIT_FOR_ACTION MachineState...");
            }
        } else if (this.ms == MachineStates.WAIT_FOR_BUYTYPE) {
            switch (input) {
                case "1":
                    this.coffeeType = "espresso";
                    break;
                case "2":
                    this.coffeeType = "latte";
                    break;
                case "3":
                    this.coffeeType = "cappuccino";
                    break;
                case "back":
                    this.coffeeType = "back";
                    break;
                default:
                    throw new IllegalStateException("unexpected input in WAIT_FOR_BUYTYPE MachineState...");

            }
            this.calcRemainingIngredients(1, this.coffeeType);
            this.ms = MachineStates.WAIT_FOR_ACTION;
        } else if (this.ms == MachineStates.WAIT_FOR_FILL_WATER) {
            this.water += Integer.parseInt(input);
            this.ms = MachineStates.WAIT_FOR_FILL_MILK;
        } else if (this.ms == MachineStates.WAIT_FOR_FILL_MILK) {
            this.milk += Integer.parseInt(input);
            this.ms = MachineStates.WAIT_FOR_FILL_BEAN;
        } else if (this.ms == MachineStates.WAIT_FOR_FILL_BEAN) {
            this.bean += Integer.parseInt(input);
            this.ms = MachineStates.WAIT_FOR_FILL_CUPPVC;
        } else if (this.ms == MachineStates.WAIT_FOR_FILL_CUPPVC) {
            this.cupPvc += Integer.parseInt(input);
            this.ms = MachineStates.WAIT_FOR_ACTION;
        }
        //prompt user for the next information the machine is waiting for
        if (returnWillBeNextInput) {
            this.promptWaitForWhat();
        }
        return returnWillBeNextInput;
    }


    public void takeMoney() {
        System.out.printf("I gave you $%d\n", money);
        System.out.println();
        money = 0;
    }

    public void calcRemainingIngredients(int cupBought, String coffeeType) {

        //backup state for the case of failure
        int backupWater = water;
        int backupMilk = milk;
        int backupBean = bean;
        int backupCupPvc = cupPvc;
        int backupMoney = money;

        String missingIngredients = "";


        switch (coffeeType) {
            case "espresso":
                water -= cupBought * ESPRESSO_WATER_PER_CUP;
                //milk -= cupBought * ESPRESSO_MILK_PER_CUP;
                bean -= cupBought * ESPRESSO_BEAN_PER_CUP;
                money += cupBought * ESPRESSO_PRICE;
                cupPvc -= cupBought;
                break;
            case "latte":
                water -= cupBought * LATTE_WATER_PER_CUP;
                milk -= cupBought * LATTE_MILK_PER_CUP;
                bean -= cupBought * LATTE_BEAN_PER_CUP;
                money += cupBought * LATTE_PRICE;
                cupPvc -= cupBought;
                break;
            case "cappuccino":
                water -= cupBought * CAPPUCCINO_WATER_PER_CUP;
                milk -= cupBought * CAPPUCCINO_MILK_PER_CUP;
                bean -= cupBought * CAPPUCCINO_BEAN_PER_CUP;
                money += cupBought * CAPPUCCINO_PRICE;
                cupPvc -= cupBought;
                break;
        }

        //alert and restore if machine run out of something
        if (water < 0 || milk < 0 || bean < 0 || cupPvc < 0) {

            missingIngredients += water < 0 ? "water" : "";
            missingIngredients += milk < 0 ? "milk" : "";
            missingIngredients += bean < 0 ? "bean" : "";
            missingIngredients += cupPvc < 0 ? "cupPvc" : "";

            System.out.printf("Sorry, not enough %s!\n", missingIngredients);
            System.out.println();

            water = backupWater;
            milk = backupMilk;
            bean = backupBean;
            cupPvc = backupCupPvc;
            money = backupMoney;
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
        }
    }

    public void fill(int plusWater, int plusMilk, int plusBean, int plusCupPvc, int plusMoney) {
        water += plusWater;
        milk += plusMilk;
        bean += plusBean;
        cupPvc += plusCupPvc;
        money += plusMoney;
    }

    public void initializeMachine() {
        cupFromWater = 0;
        cupFromMilk = 0;
        cupFromBean = 0;
        maxPossibleCup = 0;
        cupDiscrepancy = 0;

        water = 0;
        milk = 0;
        bean = 0;
        cupPvc = 0;
        money = 0;
        action = "to be decided";
        coffeeType = "none";
    }

    public void showStoke() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(bean + " g of coffee beans");
        System.out.println(cupPvc + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

}

import java.util.Scanner;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {

        boolean firstNameMissing = firstName == null || firstName.isEmpty() || firstName.trim().isEmpty();
        boolean lastNameMissing = lastName == null || lastName.isEmpty() || lastName.trim().isEmpty();

        if (firstNameMissing && lastNameMissing) {
            return null;
        } else if (firstNameMissing) {
            return lastName;
        } else if (lastNameMissing) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}
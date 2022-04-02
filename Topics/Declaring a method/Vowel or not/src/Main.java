import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {

        List<Character> allVowels = List.of('a', 'A', 'i','I','e','E','o','O','u','U');
        if (allVowels.contains(ch)) {
            return true;
        } else {
            return false;
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * The Main method for this assignment.
     * You can optionally run this to interactively try the three methods.
     * @param args parameters are unused
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    /**
     * Returns whether a given string is non-empty, contains one lower case letter,
     * at least one upper case letter, at least one digit, and meets the minimum length.
     */
    public static boolean checkForPassword(String str, int minLength) {
        if (str == null) {
            return false;
        }
        final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{" + minLength + ",}$";
        return Pattern.matches(regex, str);
    }

    /**
     * Returns a list of email addresses that occur in a given string.
     * Only @utoronto.ca or @mail.utoronto.ca are accepted.
     */
    public static List<String> extractEmails(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        final Pattern pattern = Pattern.compile("\\b[^\\s@]+@(?:mail\\.)?utoronto\\.ca\\b");
        final Matcher matcher = pattern.matcher(str);
        final List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    /**
     * Checks whether a given string contains the same capital letter twice.
     */
    public static boolean checkForDoubles(String str) {
        if (str == null) {
            return false;
        }
        return str.matches(".*([A-Z]).*\\1.*");
    }
}
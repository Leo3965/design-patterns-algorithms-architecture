package regular.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        example2();
    }

    public static void example1() {
        Pattern pattern = Pattern.compile("^[A|a|aa]gent (\\d{3,4})$");
        Matcher matcher = pattern.matcher("Agent 007");

        Boolean found = matcher.find();
        System.out.println("found: " + found);

        if (found) {
            System.out.println("Group " + matcher.group(1));
        }
    }

    public static void cardNumberExample() {
        var cardNumber = "1234-2222-3333-4343"; // XXXX-XXXX-XXXX-4343
        var pattern = Pattern.compile("(\\d{4}-){3}\\d{4}");
        var matcher = pattern.matcher(cardNumber);

        System.out.println(matcher.find());
        var maskedCard = matcher.replaceAll("XXXX-XXXX-XXXX-4343");
        System.out.println(maskedCard);
    }

    public static void example2() {
        Pattern pattern = Pattern.compile("^(\\d+) divided by (\\d+)$");
        Matcher matcher = pattern.matcher("10 divided by 2");

        Boolean found = matcher.find();
        System.out.println("found: " + found);

        if (found) {
            var number = Integer.parseInt(matcher.group(1));
            var divisor = Integer.parseInt(matcher.group(2));
            var simplified = "Result of " + matcher.replaceFirst("$1/$2") + " is equal to: ";
            System.out.println(simplified + number / divisor);
        }
    }
}

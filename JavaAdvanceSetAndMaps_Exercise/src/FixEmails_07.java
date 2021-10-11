import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> people = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String email = scanner.nextLine().toLowerCase();
            String cutLastTwo = email.substring(email.length()-2);
            switch (cutLastTwo) {
                case "us":
                case "om":
                case "uk":

                    break;
                default:
                    people.put(input, email);
                    break;
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : people.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }
    }
}

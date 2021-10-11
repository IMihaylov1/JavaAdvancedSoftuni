import java.util.ArrayDeque;

import java.util.Scanner;

public class Browser_History_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> stack = new ArrayDeque<>();

        String url = scanner.nextLine();
        String currentURL = "";
        while (!url.equals("Home")) {

            if (url.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    url = scanner.nextLine();
                    continue;
                }

            } else {
                if (!currentURL.equals("")) {

                    stack.push(currentURL);
                }
                currentURL = url;

            }
            System.out.println(currentURL);
            url = scanner.nextLine();
        }

    }
}

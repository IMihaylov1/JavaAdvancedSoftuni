import java.util.*;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> allPlayers = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            String cards = tokens[1];
            String[] tokensCard = cards.split(", ");
            if (!allPlayers.containsKey(playerName)) {
                Set<String> card = new LinkedHashSet<>();

                allPlayers.put(playerName, card);
                allPlayers.get(playerName).addAll(Arrays.asList(tokensCard));
            } else {
                allPlayers.get(playerName).addAll(Arrays.asList(tokensCard));
            }

            input = scanner.nextLine();
        }
        Map<String, Integer> total = new LinkedHashMap<>();
        int sum = 0;
        for (String name : allPlayers.keySet()) {
            Set<String> playerCard = allPlayers.get(name);
            for (String card : playerCard) {
                String[] tokens = card.split("");
                String number = tokens[0];
                String cardType = tokens[1];

                switch (number) {

                    case "1":
                        try {
                            String type = tokens[2];
                            if (type.equals("S")) {
                                sum += 10 * 4;
                                break;
                            } else if (type.equals("H")) {
                                sum += 10 * 3;
                                break;
                            } else if (type.equals("D")) {
                                sum += 10 * 2;
                                break;
                            } else {
                                sum += 10;
                                break;
                            }
                        } catch (Exception e) {
                            if (cardType.equals("S")) {
                                sum += 4;
                                break;
                            } else if (cardType.equals("H")) {
                                sum += 3;
                                break;
                            } else if (cardType.equals("D")) {
                                sum += 2;
                                break;
                            } else {
                                sum += 1;
                                break;
                            }
                        }
                    case "2":
                        if (cardType.equals("S")) {
                            sum += 2 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 2 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 2 * 2;
                            break;
                        } else {
                            sum += 2;
                        }
                        break;
                    case "3":
                        if (cardType.equals("S")) {
                            sum += 3 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 3 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 3 * 2;
                            break;
                        } else {
                            sum += 3;
                        }
                        break;
                    case "4":
                        if (cardType.equals("S")) {
                            sum += 4 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 4 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 4 * 2;
                            break;
                        } else {
                            sum += 4;
                        }
                        break;
                    case "5":
                        if (cardType.equals("S")) {
                            sum += 5 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 5 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 5 * 2;
                            break;
                        } else {
                            sum += 5;
                        }
                        break;
                    case "6":
                        if (cardType.equals("S")) {
                            sum += 6 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 6 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 6 * 2;
                            break;
                        } else {
                            sum += 6;
                        }
                        break;
                    case "7":
                        if (cardType.equals("S")) {
                            sum += 7 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 7 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 7 * 2;
                            break;
                        } else {
                            sum += 7;
                        }
                        break;
                    case "8":
                        if (cardType.equals("S")) {
                            sum += 8 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 8 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 8 * 2;
                            break;
                        } else {
                            sum += 8;
                        }
                        break;
                    case "9":
                        if (cardType.equals("S")) {
                            sum += 9 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 9 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 9 * 2;
                            break;
                        } else {
                            sum += 9;
                        }
                        break;
                    case "J":
                        if (cardType.equals("S")) {
                            sum += 11 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 11 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 11 * 2;
                            break;
                        } else {
                            sum += 11;
                        }
                        break;
                    case "Q":
                        if (cardType.equals("S")) {
                            sum += 12 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 12 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 12 * 2;
                            break;
                        } else {
                            sum += 12;
                        }
                        break;
                    case "K":
                        if (cardType.equals("S")) {
                            sum += 13 * 4;
                            break;
                        } else if (cardType.equals("H")) {
                            sum += 13 * 3;
                            break;
                        } else if (cardType.equals("D")) {
                            sum += 13 * 2;
                            break;
                        } else {
                            sum += 13;
                        }
                        break;
                    case "A":
                        sum = getSum(sum, cardType);
                        break;
                }
            }
            total.put(name, sum);
            sum = 0;
        }
        for (Map.Entry<String, Integer> entry : total.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }

    private static int getSum(int sum, String cardType) {
        if (cardType.equals("S")) {
            sum += 14 * 4;
            return sum;
        } else if (cardType.equals("H")) {
            sum += 14 * 3;
            return sum;
        } else if (cardType.equals("D")) {
            sum += 14 * 2;
            return sum;
        } else {
            sum += 14;
        }
        return sum;
    }
}


import java.util.*;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        fillThePleyerWithCard(firstPlayer, firstPlayerCards);
        fillThePleyerWithCard(secondPlayer, secondPlayerCards);

        int rounds = 50;
        while (rounds-- > 0) {

            int firstPlayerCard = getFirstCard(firstPlayer);
            int secondPlayerCard = getFirstCard(secondPlayer);
            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.addAll(Arrays.asList(firstPlayerCard,secondPlayerCard));
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayer.addAll(Arrays.asList(firstPlayerCard,secondPlayerCard));
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }
        String output = "Draw!";
        if (firstPlayer.size() < secondPlayer.size()) {
            output = "Second player win!";
        } else if (firstPlayer.size() > secondPlayer.size()) {
            output = "First player win!";
        }

        System.out.println(output);
    }

    private static void fillThePleyerWithCard(Set<Integer> firstPlayer, int[] firstPlayerCards) {
        for (int card : firstPlayerCards) {
            firstPlayer.add(card);
        }
    }

    public static int getFirstCard(Set<Integer> playerCards) {

        for (Integer card : playerCards) {
            return card;
        }
        return 0;
    }
}

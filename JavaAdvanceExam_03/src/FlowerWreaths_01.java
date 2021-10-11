import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] line = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();

        for (int flower : line) {
            stackLilies.push(flower);

        }

        line = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueRoses = new ArrayDeque<>();
        for (int flower : line) {
            queueRoses.offer(flower);

        }
        int countWreaths = 0;
        int storedFlowers = 0;

        while (stackLilies.size() > 0 && queueRoses.size() > 0) {

            int liliesCount = stackLilies.peek();
            int rosesCont = queueRoses.peek();

            int sum = liliesCount + rosesCont;

            if (sum == 15) {
                countWreaths++;
                stackLilies.pop();
                queueRoses.poll();
            } else if (sum > 15) {
                int extraFlowers = sum - 15;
                liliesCount = liliesCount - extraFlowers;
                countWreaths++;
                stackLilies.pop();
                queueRoses.poll();

            }else {
                storedFlowers = storedFlowers+sum;
                stackLilies.pop();
                queueRoses.poll();
            }
        }

        if (storedFlowers >=15){
            int addWreaths = storedFlowers/15;
            countWreaths= countWreaths+addWreaths;
        }

        if (countWreaths >=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5-countWreaths);
        }

    }
}

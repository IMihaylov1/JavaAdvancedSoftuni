import java.util.*;
public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bombs = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] bombCasing = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int countDaruta = 0;
        int countCherry = 0;
        int countSmoke = 0;


        ArrayDeque<Integer> stackBombEffects = new ArrayDeque<>();
        for (int bomb : bombs) {
            stackBombEffects.offer(bomb);
        }


        ArrayDeque<Integer> queueBombCasing = new ArrayDeque<>();
        for (int b : bombCasing) {
            queueBombCasing.push(b);
        }

        while (stackBombEffects.size() > 0 && queueBombCasing.size() > 0) {
            int firstStack = stackBombEffects.peek();
            int firstQueue = queueBombCasing.peek();
            int sum = firstStack + firstQueue;

            if (sum == 40) {
                countDaruta++;
                stackBombEffects.poll();
                queueBombCasing.pop();
            } else if (sum == 60) {
                countCherry++;
                stackBombEffects.poll();
                queueBombCasing.pop();
            } else if (sum == 120) {
                countSmoke++;
                stackBombEffects.poll();
                queueBombCasing.pop();
            } else {
                Integer currentCasing = queueBombCasing.pop() - 5;
                queueBombCasing.addFirst(currentCasing);
            }
            if (countDaruta >= 3 && countCherry >= 3 && countSmoke >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                if(stackBombEffects.isEmpty()){
                    System.out.println("Bomb Effects: empty");
                }else {
                    System.out.print("Bomb Effects: ");
                    printArrayDeque(stackBombEffects);
                }



                if (queueBombCasing.isEmpty()) {
                    System.out.println("Bomb Casings: empty");
                } else {
                    System.out.print("Bomb Casings: ");
                    printArrayDeque(queueBombCasing);
                }

                System.out.printf("Cherry Bombs: %d%n",countCherry);
                System.out.printf("Datura Bombs: %d%n",countDaruta);
                System.out.printf("Smoke Decoy Bombs: %d",countSmoke);
                return;
            }
        }
        System.out.println("You don't have enough materials to fill the bomb pouch.");

        if(stackBombEffects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");
            printArrayDeque(stackBombEffects);
        }



        if (queueBombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            printArrayDeque(queueBombCasing);
        }

        System.out.printf("Cherry Bombs: %d%n",countCherry);
        System.out.printf("Datura Bombs: %d%n",countDaruta);
        System.out.printf("Smoke Decoy Bombs: %d",countSmoke);
    }


    private static void printArrayDeque(ArrayDeque<Integer> queueBombCasing) {
        for (int i = 0; i < queueBombCasing.size(); i++) {
            if (i == queueBombCasing.size() -1) {
                System.out.println(queueBombCasing.pop());
            } else {
                System.out.print(queueBombCasing.pop() + ", ");
                i--;
            }
        }
    }
}

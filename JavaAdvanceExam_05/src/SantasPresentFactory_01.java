import java.util.*;

public class SantasPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersOfMaterial = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbersOfMagicLevel = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackMaterial = new ArrayDeque<>();
        ArrayDeque<Integer> queueMagic = new ArrayDeque<>();

        for (int i : numbersOfMaterial) {
            stackMaterial.push(i);
        }
        for (int i : numbersOfMagicLevel) {
            queueMagic.offer(i);
        }
        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        while (stackMaterial.size() > 0 && queueMagic.size() > 0) {
            int firstMaterial = stackMaterial.peek();
            int firstMagic = queueMagic.peek();
            if (firstMaterial == 0 || firstMagic == 0) {
                if (firstMaterial == 0) {
                    stackMaterial.pop();
                    continue;
                }
                queueMagic.poll();
            } else if (firstMaterial < 0 || firstMagic < 0) {
                int sumFirstAndFirst = (firstMagic) + (firstMaterial);
                stackMaterial.pop();
                queueMagic.poll();
                stackMaterial.push(sumFirstAndFirst);

            } else {
                int sum = firstMaterial * firstMagic;
                switch (sum) {
                    case 150:
                        Integer dollCount = presents.get("Doll");
                        presents.put("Doll", dollCount + 1);
                        stackMaterial.pop();
                        queueMagic.poll();
                        break;
                    case 250:
                        Integer trainCount = presents.get("Wooden train");
                        presents.put("Wooden train", trainCount + 1);
                        stackMaterial.pop();
                        queueMagic.poll();
                        break;
                    case 300:
                        Integer teddy_bear = presents.get("Teddy bear");
                        presents.put("Teddy bear", teddy_bear + 1);
                        stackMaterial.pop();
                        queueMagic.poll();
                        break;
                    case 400:
                        int bicycle = presents.get("Bicycle");
                        presents.put("Bicycle", bicycle + 1);
                        stackMaterial.pop();
                        queueMagic.poll();
                        break;
                    default:
                        queueMagic.poll();
                        Integer pop = stackMaterial.pop() + 15;
                        stackMaterial.push(pop);
                }
            }
        }
        if (presents.get("Doll") > 0 && presents.get("Wooden train") > 0 ||
                presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!stackMaterial.isEmpty()) {
           if(!stackMaterial.contains(0)){
               System.out.print("Materials left: ");
           }

            printArrayDeque(stackMaterial);

        } else if (!queueMagic.isEmpty()) {
            if(!queueMagic.contains(0)){
                System.out.print("Materials left: ");
            }
            printArrayDeque(queueMagic);

        } else {

        }

        presents.entrySet().stream().filter(p -> p.getValue() > 0)
                .forEach(p -> System.out.printf("%s: %d%n", p.getKey(), p.getValue()));

    }

    private static void printArrayDeque(ArrayDeque<Integer> queueBombCasing) {
        for (int i = 0; i < queueBombCasing.size(); i++) {
            if (i == queueBombCasing.size() - 1) {
                System.out.println(queueBombCasing.pop());
            } else {
                System.out.print(queueBombCasing.pop() + ", ");
                i--;
            }
        }
    }
}

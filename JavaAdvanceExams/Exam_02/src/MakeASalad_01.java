import java.util.*;

public class MakeASalad_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> veggies= new LinkedHashMap<>() {{
            put("tomato", 80);
            put("carrot", 136);
            put("lettuce", 109);
            put("potato", 215);
        }};
        ArrayDeque<String> vegetables=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(x -> x.matches("(tomato|carrot|lettuce|potato)")).forEach(vegetables::offer);

        ArrayDeque<Integer> salads=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(salads::push);

        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int currentSalad = salads.peek(); // Показва първия елемент!

            while (currentSalad > 0 && !vegetables.isEmpty()) {
                currentSalad -= veggies.get(vegetables.poll()); //Взима елемента и го изважда!
            }
            System.out.print(salads.pop() + " ");
        }
        System.out.println();

        if(!salads.isEmpty()){
            System.out.println(salads.toString().replaceAll("[\\[\\],]",""));
        }

        if(!vegetables.isEmpty()){
            System.out.println(vegetables.toString().replaceAll("[\\[\\],]",""));
        }

    }

}

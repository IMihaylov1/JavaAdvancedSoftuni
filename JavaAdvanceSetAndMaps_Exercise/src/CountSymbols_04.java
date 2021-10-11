import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character,Integer> all = new TreeMap<>();
        for (int i = 0; i <input.length() ; i++) {
            char symbol = input.charAt(i);
            if(!all.containsKey(symbol)){
                all.put(symbol,0);
            }
            Integer currentValue = all.get(symbol);
            all.put(symbol,currentValue+1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : all.entrySet()) {
            System.out.printf("%s: %d time/s%n",characterIntegerEntry.getKey(),characterIntegerEntry.getValue());
        }
    }
}

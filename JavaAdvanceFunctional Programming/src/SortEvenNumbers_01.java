import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] lineIntegers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> integerList = new ArrayList<>();
        for (int integer : lineIntegers) {
            if (integer % 2 == 0) {
                integerList.add(integer);
            }
        }
        List<String> list = integerList.stream().map(Objects::toString).collect(Collectors.toList());
        String result = list.stream().collect(Collectors.joining(", "));
        System.out.println(result);

        List<Integer> collect = integerList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(Objects::toString).collect(Collectors.toList());
        String result2 = collect1.stream().collect(Collectors.joining(", "));
        System.out.println(result2);

    }
}

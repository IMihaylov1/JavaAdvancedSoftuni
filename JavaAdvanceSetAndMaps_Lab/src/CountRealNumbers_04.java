import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> grades = new LinkedHashMap<>();

        for (double currentGrade : input) {
            if (!grades.containsKey(currentGrade)) {
                grades.put(currentGrade, 1);
            } else {
                grades.put(currentGrade, grades.get(currentGrade) + 1);
            }
        }
        grades.entrySet().forEach(e->
                System.out.println(String.format("%.1f -> %d",e.getKey(),e.getValue()))
                );
    }
}

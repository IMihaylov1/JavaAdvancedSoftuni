import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);
        }
        //                  Petko -> 3.00 3.66 (avg: 3.33)
//                  Vladimir -> 4.50 5.00 (avg: 4.75)
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double sum = 0;
            double count = 0;
            for (Double e : entry.getValue()) {
                sum += e;
                count++;
                System.out.printf("%.2f ", e);
            }
            double avg = sum / count;
            System.out.printf("(avg: %.2f)%n", avg);
        }

    }
}



import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                for (double currentGrade : grades) {
                    students.get(name).add(currentGrade);
                }
            } else {
                for (double grade : grades) {
                    students.get(name).add(grade);
                }
            }
        }
        students.forEach((name, grades) -> {

            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            double avg = sum / grades.size();


            System.out.println(String.format("%s is graduated with %s", name, avg));


        });
    }
}
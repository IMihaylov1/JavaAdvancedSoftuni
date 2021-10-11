import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Robotics_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> robots = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(";");

        ExtractRobots(robots, input);

        int[] processTime = new int[robots.size()];

        String inputTime = scanner.nextLine();
        if (inputTime.length() == 7) {
            inputTime = "0" + inputTime;
        }
        LocalTime time = LocalTime.parse(inputTime);

        ArrayDeque<String> productsToOperate = new ArrayDeque<>();

        String products = scanner.nextLine();
        while (!products.equals("End")) {
            productsToOperate.offer(products);

            products = scanner.nextLine();
        }
        while (!productsToOperate.isEmpty()) {
            time = time.plusSeconds(1);

            String currentProduct = productsToOperate.poll();
            decreaseProcessTime(processTime);

            if (!assignJob(robots, processTime, currentProduct, time)) {
                productsToOperate.offer(currentProduct);
            }


        }

    }

    private static void decreaseProcessTime(int[] processTime) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] > 0) {
                processTime[i]--;
            }
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] processTime, String currentProduct, LocalTime totalSeconds) {
        for (int i = 0; i < processTime.length; i++) {

            if (processTime[i] == 0) {
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if (count == i) {
                        processTime[i] = entry.getValue();
                        LogJobAssigned(entry.getKey(), currentProduct, totalSeconds);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void LogJobAssigned(String name, String product, LocalTime time) {
        String format = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(String.format("%s - %s [%s]", name, product, format));
    }


    private static void ExtractRobots(Map<String, Integer> robots, String[] input) {
        for (String s : input) {
            String[] robot = s.split("-");
            String robotName = robot[0];
            int workingTime = Integer.parseInt(robot[1]);
            robots.put(robotName, workingTime);

        }
    }
}

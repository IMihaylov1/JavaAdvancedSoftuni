import java.util.*;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> usersAndIP = new TreeMap<>();
        Map<String, Integer> countRepeatIP = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] toArray = input.split("\\s+");
            String IP = toArray[0].substring(3);
            String userName = toArray[2].substring(5);

            usersAndIP.putIfAbsent(userName, new LinkedHashSet<>());

            usersAndIP.get(userName).add(IP);
            if (countRepeatIP.containsKey(userName)){
                countRepeatIP.put(userName, countRepeatIP.get(userName) + 1);
            }else {
                countRepeatIP.put(userName, 1);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : usersAndIP.entrySet()) {
            String user = entry.getKey();
            System.out.println(user + ": ");

            Object[] SetToArray = entry.getValue().toArray();       //convert Set to Array
            for (int i = 0; i < SetToArray.length; i++) {
                if (i < SetToArray.length - 1) {
                    System.out.print(SetToArray[i] + " => " + countRepeatIP.get(user) + ", ");
                } else {
                    System.out.print(SetToArray[i] + " => " + countRepeatIP.get(user) + ".");
                }
            }
            System.out.println();


        }

    }
}
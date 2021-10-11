import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vIp = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String command = scanner.nextLine();

        while (!command.equals("PARTY")) {
            String checkIfLetterOrNum = command.substring(0,1);
            switch (checkIfLetterOrNum) {
                case "0":
                case "9":
                case "8":
                case "7":
                case "6":
                case "5":
                case "4":
                case "3":
                case "2":
                case "1":
                    vIp.add(command);
                    break;
                default:
                    regular.add(command);
                    break;
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("END")){
            if(vIp.contains(command)){
                vIp.remove(command);
            }
            if(regular.contains(command)){
                regular.remove(command);
            }
            command = scanner.nextLine();
        }
        System.out.println(vIp.size()+regular.size());
        vIp.forEach(System.out::println);
        regular.forEach(System.out::println);

    }
}

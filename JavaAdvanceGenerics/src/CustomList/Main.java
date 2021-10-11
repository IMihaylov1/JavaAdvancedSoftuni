package CustomList;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        CustomList<String> customList = new CustomList<String>();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String commandWord = tokens[0];
            switch (commandWord) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementToContains = tokens[1];
                    System.out.println(customList.contains(elementToContains));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    customList.swap(index1, index2);
                    break;
                case "Greater":
                    String elementGreater = tokens[1];
                    System.out.println(customList.countGreaterThan(elementGreater));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
            command = scanner.nextLine();
        }

    }

}


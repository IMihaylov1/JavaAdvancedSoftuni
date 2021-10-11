import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterByAge_05 {
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }
        public String getName(){
            return this.name;
        }
        public int getAge(){
            return this.age;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> allPeople = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] tokens = input.split(", ");

            String name = tokens[0];
            int agePerson = Integer.parseInt(tokens[1]);
            Person person = new Person(name, agePerson);
            allPeople.add(person);
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        if (condition.equals("younger")) {
            allPeople.removeIf(allPerson -> allPerson.getAge() > ageCondition);
        }else {
            allPeople.removeIf(allPerson -> allPerson.getAge() < ageCondition);
        }

        if(format.equals("name age")){
            for (Person allPerson : allPeople) {
                System.out.printf("%s - %d%n",allPerson.getName(),allPerson.getAge());
            }
        }else if(format.equals("name")){
            for (Person allPerson : allPeople) {
                System.out.println(allPerson.getName());
            }
        }else {
            for (Person allPerson : allPeople) {
                System.out.println(allPerson.getAge());
            }

        }
    }
}

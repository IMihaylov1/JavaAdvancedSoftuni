package Google;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> personMap = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String type = tokens[1];
            switch (type) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    if (!personMap.containsKey(personName)) {
                        personMap.put(personName, new Person(company));
                    } else {
                        personMap.get(personName).setCompany(company);
                    }
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    if (!personMap.containsKey(personName)) {
                        personMap.put(personName, new Person(car));
                    }
                    else {
                        personMap.get(personName).setCar(car);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.putIfAbsent(personName, new Person());
                    personMap.get(personName).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentsName = tokens[2];
                    String parentsBirthday = tokens[3];
                    Parents parents = new Parents(parentsName, parentsBirthday);
                    personMap.putIfAbsent(personName, new Person());
                    personMap.get(personName).addParents(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children children = new Children(childName, childBirthday);
                    personMap.putIfAbsent(personName, new Person());
                    personMap.get(personName).addChildren(children);
                    break;
            }
            input = scanner.nextLine();
        }

        String nameToAppear = scanner.nextLine();


        for (Map.Entry<String, Person> stringPersonEntry : personMap.entrySet()) {
            if (stringPersonEntry.getKey().equals(nameToAppear)) {
                System.out.println(nameToAppear);
                Person person = stringPersonEntry.getValue();
                System.out.println("Company:");
                if (stringPersonEntry.getValue().getCompany() != null) {
                    String companyName = person.getCompany().getCompanyName();
                    String department = person.getCompany().getDepartment();
                    double salary = person.getCompany().getSalary();
                    System.out.printf(" %s %s %.2f%n",companyName,department,salary);
                }
                System.out.println("Car:");
                if (person.getCar() != null) {
                    System.out.println(person.getCar().getCarModel() + " " + person.getCar().getCarSpeed());
                }
                System.out.println("Pokemon:");
                if (person.getPokemonList().size() != 0) {
                    List<Pokemon> pokemonList = person.getPokemonList();
                    for (Pokemon pokemon : pokemonList) {
                        System.out.println(pokemon.getPokemonName() + " " + pokemon.getPokemonType());
                    }
                }
                System.out.println("Parents:");
                if (person.getParentsList().size() != 0) {
                    List<Parents> parentsList = person.getParentsList();
                    for (Parents parents : parentsList) {
                        System.out.println(parents.getParentsName() + " " + parents.getParentsBirthday());
                    }
                }
                System.out.println("Children:");
                if (person.getChildrenList().size() != 0) {
                    List<Children> childrenList = person.getChildrenList();
                    for (Children children : childrenList) {
                        System.out.println(children.getChildName() + " " + children.getChildBirthday());
                    }
                }
            }
        }
    }
}

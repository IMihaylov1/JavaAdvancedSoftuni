import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continents = input[0];
            String countries = input[1];
            String cities = input[2];

            if (!earth.containsKey(continents)) {
                earth.put(continents, new LinkedHashMap<>());
                earth.get(continents).put(countries, new ArrayList<>());
            } else {
                if (!earth.get(continents).containsKey(countries)) {
                    earth.get(continents).put(countries, new ArrayList<>());
                    earth.get(continents).get(countries);
                }
            }
            earth.get(continents).get(countries).add(cities);
        }
        earth.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) -> {
                System.out.printf("  %s -> ", country);
                printCities(cities);
            });
        });
    }

    private static void printCities(List<String> cities) {
        for (int i = 0; i < cities.size(); i++) {
            String city = cities.get(i);
            if (i == cities.size()-1) {
                System.out.print(city);
            } else {
                System.out.print(city + ", ");
            }
        }
        System.out.println();
    }
}

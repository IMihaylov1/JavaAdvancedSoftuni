import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
                shops.get(shop).put(product, price);
            } else {
                shops.get(shop).put(product, price);
            }


            input = scanner.nextLine();
        }

        shops.forEach((shopName, product) -> {
            System.out.println(shopName + "->");
            product.forEach((productName,productPrice)->{
                System.out.println(String.format("Product: %s, Price: %.1f",
                        productName,productPrice
                ));
            });
        });
    }
}

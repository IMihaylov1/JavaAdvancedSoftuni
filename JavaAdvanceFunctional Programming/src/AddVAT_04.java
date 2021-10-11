import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        double priceWithVat = 0;
        UnaryOperator<Double> addVat = value -> value * 1.2;

        System.out.println("Price with VAT:");
        for (double price : arr) {
            priceWithVat =addVat.apply(price);
            System.out.printf("%.2f%n",priceWithVat);
        }
    }
}

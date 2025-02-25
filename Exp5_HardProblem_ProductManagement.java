import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class Exp5_HardProblem_ProductManagement {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.99),
                new Product("Smartphone", "Electronics", 999.49),
                new Product("Tablet", "Electronics", 550.99),
                new Product("TV", "Appliances", 750.00),
                new Product("Microwave", "Appliances", 180.75),
                new Product("Refrigerator", "Appliances", 1299.99),
                new Product("Shirt", "Clothing", 49.99),
                new Product("Jeans", "Clothing", 79.99),
                new Product("Jacket", "Clothing", 120.00)
        );

        Map<String, List<Product>> productsByCategory = products.stream().collect(groupingBy(Product::getCategory));

        System.out.println("\n--- Products Grouped by Category ---");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream().collect(groupingBy(Product::getCategory, maxBy(Comparator.comparing(Product::getPrice))));

        System.out.println("\n--- Most Expensive Product in Each Category ---");
        mostExpensiveByCategory.forEach((category, product) ->
                System.out.println(category + ": " + product.get().getName() + " ($" + product.get().getPrice() + ")"));

        double averagePrice = products.stream()
                .collect(averagingDouble(Product::getPrice));

        System.out.println("\n--- Average Price of All Products ---");
        System.out.printf("Average Price: $%.2f\n", averagePrice);
    }
}

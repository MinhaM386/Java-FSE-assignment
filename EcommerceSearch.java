package FactoryMethodPatternExample.DS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int searchId) {
        for (Product product : products) {
            if (product.productId == searchId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int searchId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == searchId)
                return products[mid];
            else if (products[mid].productId < searchId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mobile", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Backpack", "Travel")
        };

        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p.productId + " - " + p.productName);
        }

        System.out.print("\nEnter Product ID to search: ");
        int searchId = sc.nextInt();

        // Linear Search
        long startLinear = System.nanoTime();
        Product linearResult = linearSearch(products, searchId);
        long endLinear = System.nanoTime();

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        long startBinary = System.nanoTime();
        Product binaryResult = binarySearch(products, searchId);
        long endBinary = System.nanoTime();

        System.out.println("\n===== Linear Search Result =====");
        if (linearResult != null)
            linearResult.display();
        else
            System.out.println("Product not found.");

        long linearTime = endLinear - startLinear;
        System.out.println("Time Taken: " + linearTime + " ns");

        System.out.println("\n===== Binary Search Result =====");
        if (binaryResult != null)
            binaryResult.display();
        else
            System.out.println("Product not found.");

        long binaryTime = endBinary - startBinary;
        System.out.println("Time Taken: " + binaryTime + " ns");

        System.out.println("\n===== Performance Comparison =====");
        if (linearTime < binaryTime)
            System.out.println("Linear Search is faster.");
        else if (binaryTime < linearTime)
            System.out.println("Binary Search is faster.");
        else
            System.out.println("Both searches took the same time.");

        sc.close();
    }
}
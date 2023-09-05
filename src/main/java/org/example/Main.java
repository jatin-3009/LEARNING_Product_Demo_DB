package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

//        service.addProduct(new Product("MacBook Pro", "Laptop", "Brown Table", 2023));
//        service.addProduct(new Product("MSI Katana", "Laptop", "Brown Table", 2022));
//        service.addProduct(new Product("Realme 2 Pro", "Mobile", "Brown Table", 2019));
//        service.addProduct(new Product("Oppo Air 3", "Wireless Earphones", "Brown Table", 2023));
//        service.addProduct(new Product("Plantronics", "Wired Headset", "Brown Table", 2023));
//        service.addProduct(new Product("Logitech B170", "Wireless Mouse", "Brown Table", 2023));
//        service.addProduct(new Product("Boat Nirvana Ion", "Wireless Earphones", "Brown Cupboard", 2023));
//        service.addProduct(new Product("Tusk", "Electric Toothbrush", "Brown Cupboard", 2023));
//        service.addProduct(new Product("Yonex Nanoray", "Badminton Racket", "Near Window", 2023));

        System.out.println("========================================");
        System.out.println("Printing all the products");
        System.out.println("========================================\n");

        List<Product> products = service.getAllProducts();

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\n========================================");
        System.out.println("Printing a particular product");
        System.out.println("========================================\n");

        Product logitechMouse = service.getProduct("Logitech B170");
        System.out.println(logitechMouse);

        System.out.println("\n========================================");
        System.out.println("Printing products with a particular text");
        System.out.println("========================================\n");

        List<Product> products1 = service.getProductWithText("Wireless");

        for (Product product : products1) {
            System.out.println(product);
        }

        System.out.println("\n========================================");
        System.out.println("Search products by place");
        System.out.println("========================================\n");

        List<Product> products2 = service.getProductByPlace("Cupboard");

        for (Product product : products2) {
            System.out.println(product);
        }

        System.out.println("\n========================================");
        System.out.println("Print products out of warranty");
        System.out.println("========================================\n");

        List<Product> products3 = service.getProductOutOfWarranty(2022);

        for (Product product : products3) {
            System.out.println(product);
        }
    }
}
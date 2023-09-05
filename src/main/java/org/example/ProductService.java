package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDB db = new ProductDB();

    public void addProduct(Product product) {
        db.save(product);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {
        return db.getProduct(name);
    }


    public List<Product> getProductWithText(String inputText) {
        String text = inputText.toLowerCase();
        return db.getProductWithText(text);
    }

    public List<Product> getProductByPlace(String inputText) {
        String text = inputText.toLowerCase();
        return db.getProductsByPlace(text);
    }

    public List<Product> getProductOutOfWarranty(int year) {
        return db.getProductsOutOfWarranty(year);
    }
}

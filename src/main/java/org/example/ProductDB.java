package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProductDemo", "postgres", "Jatin@1998");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {

        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, product.getName());
            st.setString(2, product.getType());
            st.setString(3, product.getPlace());
            st.setInt(4, product.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));

                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public Product getProduct(String name) {
        Product product = new Product();
        String query = "select name, type, place, warranty from product where name=?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    public List<Product> getProductWithText(String text) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where lower(name) like lower(?) OR " +
                        "lower(type) like lower(?) OR lower(place) like lower(?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + text + "%");
            st.setString(2, "%" + text + "%");
            st.setString(3, "%" + text + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));

                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;

    }

    public List<Product> getProductsByPlace(String text) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where lower(place) like lower(?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + text + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public List<Product> getProductsOutOfWarranty(int year) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where warranty <= ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}

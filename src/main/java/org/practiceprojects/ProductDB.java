package org.practiceprojects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection conn = null;

    public ProductDB(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdemo","root","db@Meg@bite002");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product p){
        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(query);
            st.setString(1,p.getName());
            st.setString(2,p.getType());
            st.setString(3,p.getPlace());
            st.setInt(4,p.getWarranty());
            boolean rowInserted = st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllproducts() {
        List<Product> products = new ArrayList<>();
        String query = "Select name, type, place, warranty from product";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product getProduct(String name) {
        String query = "Select name, type, place, warranty from product where name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Product();
    }
}

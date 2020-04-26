package com.stock_sim.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock_sim.utils.Item;
import com.stock_sim.utils.Order;
import com.stock_sim.utils.Supplier;

public class Persistence {
    private Connection conn;
    private Supplier[] suppliers;
    private Item[] items;
    private Order[] order;

    public Persistence() {
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:postgresql://localhost:5432/stock";
            String user = "postgres";
            String passwd = "root";

            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connected to database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertItem(Item item) {
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement(
                    "INSERT INTO items(name, price, quantity, threshold, weight, supplier, orderid) VALUES(?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setInt(4, item.getThreshold());
            pstmt.setBoolean(5, item.getWeight());
            pstmt.setInt(6, item.getSupplier() == null ? 0 : item.getSupplier().getId());
            pstmt.setInt(7, item.getOrder() == null ? 0 : item.getOrder().getId());

            pstmt.executeUpdate();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT _id FROM items WHERE items.name='" + item.getName() + "'");
            rs.next();
            item.setId(rs.getInt("_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSupplier(Supplier supplier) {
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement("INSERT INTO suppliers(name, phone, adress, zipcode) VALUES(?, ?, ?, ?)");

            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getPhone());
            pstmt.setString(3, supplier.getAdress());
            pstmt.setString(4, supplier.getZipCode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(Order order) {
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement("INSERT INTO orders(price, quantity, date) VALUES(?, ?, ?)");

            pstmt.setDouble(1, order.getPrice());
            pstmt.setInt(2, order.getQuantity());
            pstmt.setString(3, order.getDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item[] selectItems() {
        List<Item> it = new ArrayList<>();
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt
                    .executeQuery("SELECT _id, name, price, quantity, threshold, weight, supplier, orderid FROM items");

            while (rs.next()) {
                Item i = new Item(rs.getInt("_id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getInt("threshold"), rs.getBoolean("weight"), null, null);
                it.add(i);

                if (rs.getInt("orderid") != 0)
                    i.setOrder(order[rs.getInt("orderid") - 1]);
                if (rs.getInt("supplier") != 0)
                    i.setSupplier(suppliers[rs.getInt("supplier") - 1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        items = new Item[it.size()];
        items = it.toArray(items);

        return items;
    }

    public Supplier[] selectSuppliers() {
        ArrayList<Supplier> supp = new ArrayList<>();
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT _id, name, phone, adress, zipcode FROM suppliers");

            while (rs.next()) {
                supp.add(new Supplier(rs.getInt("_id"), rs.getString("name"), rs.getString("phone"),
                        rs.getString("adress"), rs.getString("zipcode")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        suppliers = new Supplier[supp.size()];
        suppliers = supp.toArray(suppliers);

        return suppliers;
    }

    public Order[] selectOrders() {
        ArrayList<Order> odr = new ArrayList<>();
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT _id, price, quantity, date FROM orders");

            while (rs.next()) {
                odr.add(new Order(rs.getInt("_id"), rs.getInt("quantity"), rs.getDouble("price"),
                        rs.getString("date")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        order = new Order[odr.size()];
        order = odr.toArray(order);

        return order;
    }

    public void deleteItem(Item item) {
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement("DELETE FROM items WHERE items._id = ?");

            pstmt.setInt(1, item.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
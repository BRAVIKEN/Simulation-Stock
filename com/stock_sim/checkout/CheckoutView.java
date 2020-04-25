package com.stock_sim.checkout;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import com.stock_sim.system.*;
import com.stock_sim.checkout.*;
import com.stock_sim.utils.*;


/**
 * CheckoutView
 */
public class CheckoutView implements ActionListener {
    private CheckoutMVC mvc;
    private JFrame frame;
    private JPanel panel;
    private MenuItem menuItemQuit;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton add_manually;
    private JButton return_item;
    private JButton pay;
    private JButton total;

    public CheckoutView() {
    }

    public void init(CheckoutMVC comvc) {
        mvc = comvc;
        createWindow();
        createTable();
        createCommands();
        frame.pack();
    }

    public void createWindow() {
        frame = new JFrame("Checkout");

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");

        menuItemQuit = new MenuItem("Quit");
        menuItemQuit.addActionListener(this);
        menu.add(menuItemQuit);
        menuBar.add(menu);

        frame.setMenuBar(menuBar);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.getContentPane().add(panel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public void createTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Items");
        tableModel.addColumn("Price");

        table = new JTable(tableModel);
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(1000, 800));
        scrollpane.setMinimumSize(new Dimension(500, 500));

        panel.add(scrollpane, BorderLayout.WEST);
    }

    public void createCommands() {
        JPanel grid = new JPanel();
        grid.setPreferredSize(new Dimension(150, 0));
        grid.setLayout(new GridLayout(4, 1));

        add_manually = new JButton("Add manually");
        add_manually.addActionListener(this);

        return_item = new JButton("Return item");
        return_item.addActionListener(this);

        pay = new JButton("Pay");
        pay.addActionListener(this);

        total = new JButton("Total");
        total.addActionListener(this);

        grid.add(add_manually);
        grid.add(return_item);
        grid.add(pay);
        grid.add(total);

        frame.getContentPane().add(grid, BorderLayout.CENTER);
    }

    public String inputDialog(String title, String message) {
        JOptionPane optionPane = new JOptionPane();
        return optionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public void messageDialog(String title, String message) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void messageDialog(String title, JTable tab) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, new JScrollPane(tab), title, JOptionPane.INFORMATION_MESSAGE);
    }

    public String[][] baskets_to_string(Basket... baskets) {
        int size = 0, i = 0;
        String[][] str;

        for (Basket basket : baskets) {
            size += basket.getBasket().size() + 1;
        }

        str = new String[size][2];

        for (Basket basket : baskets) {
            for (int j = 0; j < basket.getBasket().size(); ++j, ++i) {
                Item item = basket.getBasket().get(j);
                str[i][0] = item.getName();
                str[i][1] = Double.toString(item.getPrice());
            }

            str[i][0] = "Solde";
            str[i][1] = String.format("%.2f", basket.getBalance());

            ++i;
        }

        return str;
    }

    public void printTicket(Basket... basket) {
        messageDialog("Ticket", new JTable(baskets_to_string(basket), new String[] { "Items", "price" }));

        mvc.model.endCurentBasket();
        tableModel.setRowCount(0);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemQuit) {
            System.exit(0);
        } else if (e.getSource() == add_manually) {
            try {
                Item item = mvc.controller
                        .scanBarCode(Integer.parseInt(inputDialog("Add manually", "Enter the barcode")));
                if (item == null) {
                    messageDialog("Error", "Invalid barcode");
                    return;
                }
                tableModel.addRow(new Object[] { item.getName(), Double.toString(item.getPrice()) });
            } catch (NumberFormatException ex) {
                messageDialog("Error", "Invalid barcode");
            }
        } else if (e.getSource() == return_item) {
            try {
                int i = mvc.controller.returnItem(Integer.parseInt(inputDialog("Return items", "Enter the barcode")));
                if (i == 0) {
                    messageDialog("Error", "Invalid barcode");
                    return;
                }
            } catch (NumberFormatException ex) {
                messageDialog("Error", "Invalid barcode");
            }
        } else if (e.getSource() == pay) {
            Basket b = mvc.controller.printActualBasketTicket();
            if (b != null) {
                printTicket(b);
            }
        } else if (e.getSource() == total) {
            ArrayList<Basket> b = mvc.controller.printAllTickets();
            if (b != null) {
                printTicket(b.toArray(new Basket[b.size()]));
            }
        }
    }
}
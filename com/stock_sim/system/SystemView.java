package com.stock_sim.system;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import com.stock_sim.utils.*;

/**
 * SystemView
 */
public class SystemView implements ActionListener {
    private SystemMVC mvc;
    private JFrame frame;
    private JPanel panel;
    private MenuItem menuItemQuit;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton newItem;
    private JButton print;

    public SystemView() {
    }

    public void init(SystemMVC sysmvc) {
        mvc = sysmvc;
        createWindow();
        createTable();
        createCommands();
        frame.pack();
    }

    public void createWindow() {
        frame = new JFrame("Stock Management");

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
        tableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Items");

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!table.getSelectionModel().isSelectionEmpty()) {
                    displayItem(mvc.model.getItem(table.getSelectedRow()));
                }
            }
        });

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(1000, 800));
        scrollpane.setMinimumSize(new Dimension(500, 500));
        panel.add(scrollpane, BorderLayout.WEST);
    }

    public void createCommands() {
        JPanel grid = new JPanel();
        grid.setPreferredSize(new Dimension(150, 0));
        grid.setLayout(new GridLayout(8, 1));

        newItem = new JButton("New Item");
        newItem.addActionListener(this);

        print = new JButton("Print");
        print.addActionListener(this);

        grid.add(newItem);
        grid.add(print);

        frame.getContentPane().add(grid, BorderLayout.CENTER);
    }

    public JPanel createItemPanel(Item item) {
        JPanel itemPanel = new JPanel(new BorderLayout());

        JScrollPane scrollpane = new JScrollPane(itemToTable(item));
        scrollpane.setPreferredSize(new Dimension(500, 300));

        itemPanel.add(scrollpane, BorderLayout.PAGE_START);

        JPanel grid = new JPanel();
        grid.setPreferredSize(new Dimension(300, 25));
        grid.setLayout(new GridLayout(1, 3));

        final JButton order = new JButton(item.getOrder() == null ? "Create order" : "Cancel order");
        order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (item.getOrder() == null) {
                        String input = inputDialog("Create order", "Enter the amount");
                        if (input != null) {
                            int amount = Integer.parseInt(input);
                            mvc.model.createOrder(item.getBarCode(), amount);
                            order.setText("Cancel order");
                        }
                    } else {
                        item.setOrder(null);
                        order.setText("Create order");
                    }
                } catch (NumberFormatException ex) {
                    messageDialog("Error", "Invalid amount");
                }
            }
        });

        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the item ?");
                if (input == 0) {
                    mvc.model.removeItem(item);
                    refreshStock();
                }
            }
        });

        JButton printItem = new JButton("Print");

        grid.add(order);
        grid.add(delete);
        grid.add(printItem);

        itemPanel.add(grid, BorderLayout.PAGE_END);

        return itemPanel;
    }

    public JPanel createSupplierPanel(Supplier supplier) {
        JPanel itemPanel = new JPanel(new BorderLayout());

        JScrollPane scrollpane = new JScrollPane(supplierToTable(supplier));
        scrollpane.setPreferredSize(new Dimension(500, 300));

        itemPanel.add(scrollpane, BorderLayout.PAGE_START);

        JPanel grid = new JPanel();
        grid.setPreferredSize(new Dimension(300, 25));
        grid.setLayout(new GridLayout(1, 1));

        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        grid.add(delete);

        itemPanel.add(grid, BorderLayout.PAGE_END);

        return itemPanel;
    }

    public JTable itemToTable(Item item) {
        int size = item.getOrder() != null ? 10 : 8;
        String[][] str = new String[size][2];

        str[0][0] = "Items";
        str[0][1] = item.getName();

        str[1][0] = "Barcode";
        str[1][1] = Integer.toString(item.getBarCode());

        str[2][0] = "Price";
        str[2][1] = Double.toString(item.getPrice());

        str[3][0] = "Quantity";
        str[3][1] = Integer.toString(item.getQuantity());

        str[4][0] = "Threshold";
        str[4][1] = Integer.toString(item.getThreshold());

        str[5][0] = "Weight";
        str[5][1] = Boolean.toString(item.getWeight());

        str[6][0] = "Supplier";
        str[6][1] = item.getSupplier() != null ? item.getSupplier().getName() : "";

        if (size > 8) {
            Order order = item.getOrder();
            str[7][0] = "Order date";
            str[7][1] = order.getDate();

            str[8][0] = "Order price";
            str[8][1] = Double.toString(order.getPrice());

            str[9][0] = "Order quantity";
            str[9][1] = Integer.toString(order.getQuantity());
        } else {
            str[7][0] = "Order";
            str[7][1] = "No";
        }

        JTable tab = new JTable(str, new String[] { "Info", "Value" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                if (row == 6 || row == 1)
                    return false;
                return true;
            }
        };
        tab.getTableHeader().setReorderingAllowed(false);
        tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tab.getSelectedRows()[0] == 6) {
                    if (item.getSupplier() == null) {
                        int index;
                        JComboBox cb;
                        ArrayList<Supplier> suppliers = mvc.model.getAllSuppliers();
                        int size = suppliers.size() + 1;
                        String[] supp = new String[size];

                        for (int i = 0; i < size - 1; ++i) {
                            supp[i] = suppliers.get(i).getName();
                        }
                        supp[size - 1] = "Add new supplier";

                        cb = new JComboBox<String>(supp);
                        index = comboDialog("Suppliers", cb);

                        if (index == size - 1) {
                            Supplier su = new Supplier();
                            mvc.model.addSupplier(su);
                            item.setSupplier(su);
                        } else if (index != -1) {
                            item.setSupplier(mvc.model.getSupplier(index));
                        } else {
                            return;
                        }
                    }
                    displaySupplier(item.getSupplier());
                }
            }
        });

        tab.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                try {
                    if (e.getColumn() == 1) {
                        mvc.model.editItem(item, e.getLastRow(),
                                tab.getModel().getValueAt(e.getLastRow(), e.getColumn()).toString());
                        if (e.getLastRow() == 0)
                            refreshStock();
                    }
                } catch (NumberFormatException ex) {
                    messageDialog("Error", "Invalid value");
                }
            }
        });

        return tab;
    }

    public JTable supplierToTable(Supplier supplier) {
        String[][] str = new String[4][2];

        str[0][0] = "Name";
        str[0][1] = supplier.getName();

        str[1][0] = "Phone";
        str[1][1] = supplier.getPhone();

        str[2][0] = "Adress";
        str[2][1] = supplier.getAdress();

        str[3][0] = "zipCode";
        str[3][1] = supplier.getZipCode();

        final JTable tab = new JTable(str, new String[] { "Info", "Value" }) {
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return true;
            }
        };
        tab.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                try {
                    mvc.model.editSupplier(supplier, e.getLastRow(),
                            tab.getModel().getValueAt(e.getLastRow(), e.getColumn()).toString());
                } catch (NumberFormatException ex) {
                    messageDialog("Error", "Invalid value");
                }
            }
        });

        tab.getTableHeader().setReorderingAllowed(false);

        return tab;
    }

    public void messageDialog(String title, String message) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public String inputDialog(String title, String message) {
        JOptionPane optionPane = new JOptionPane();
        return optionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public void messageDialog(String title, JPanel tab) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, new JScrollPane(tab), title, JOptionPane.INFORMATION_MESSAGE);
    }

    public int comboDialog(String title, JComboBox combo) {
        String[] options = { "OK", "Cancel" };

        JOptionPane optionPane = new JOptionPane();
        int choice = optionPane.showOptionDialog(null, combo, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        return choice == 0 ? combo.getSelectedIndex() : -1;
    }

    public void displayStock(ArrayList<Item> stock) {
        for (Item item : stock) {
            tableModel.addRow(new Object[] { item.getName() });
        }
    }

    public void displayItem(Item item) {
        messageDialog(item.getName(), createItemPanel(item));
    }

    public void displaySupplier(Supplier supplier) {
        messageDialog(supplier.getName(), createSupplierPanel(supplier));
    }

    public void refreshStock() {
        tableModel.setRowCount(0);
        displayStock(mvc.model.getStock().getAllItems());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemQuit) {
            System.exit(0);
        } else if (e.getSource() == newItem) {
            Item item = new Item();
            mvc.model.addItem(item);
            displayItem(item);
            refreshStock();
        } else if (e.getSource() == print) {

        }
    }
}
package com.study.gui.view;

import com.study.constant.ImageIcons;
import com.study.model.Product;
import com.study.model.User;
import com.study.payment.CreditCardPaymentMethod;
import com.study.payment.DigitalWalletPaymentMethod;
import com.study.payment.PaymentMethod;
import com.study.payment.VisaPaymentMethod;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartPage extends DefaultPage {

  private User loggedUser;
  private JTable cartTable;
  private JLabel totalPriceLabel;
  private JLabel balanceLabel;
  private JRadioButton cardPayment, visaPayment, walletPayment;
  private JButton payButton;
  private JButton clearButton;
  private JLabel paymentStatusLabel;
  private JPanel topBarPanel;

  private PaymentMethod paymentMethod;

  public CartPage(User loggedUser) {
    super();
    this.loggedUser = loggedUser;

    setTitle("Cart Page");
    setLayout(new BorderLayout());


    topBarPanel = new JPanel();
    topBarPanel.setBackground(new Color(63,71,95));
    topBarPanel.setPreferredSize(new Dimension(getWidth(), 50));
    GridBagLayout layout = new GridBagLayout();
    topBarPanel.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets = new Insets(0, 0, 0, 120);
    gbc.fill = GridBagConstraints.NONE;


    JButton goBackButton = new JButton("Go Back", ImageIcons.exit);

    goBackButton.setFocusable(false);
    goBackButton.addActionListener(e -> {
      setVisible(false);
      dispose();
      new HomePage(loggedUser);
    });
    gbc.insets = new Insets(0, 0, 0, 20);
    topBarPanel.add(goBackButton, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(0, 20, 0, 0);
    JLabel logo = new JLabel(ImageIcons.logo);
    topBarPanel.add(logo, gbc);
    gbc.insets = new Insets(0, 60, 0, 0);
    JLabel logoText = new JLabel("E-Commerce");

    logoText.setFont(new Font("Serif", Font.BOLD, 24));
    logoText.setForeground(Color.WHITE);

    topBarPanel.add(logoText, gbc);

    add(topBarPanel, BorderLayout.NORTH);

    // Create the table model and table
    String[] columnNames = {"Brand", "Name", "Price", "Stock"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false; // Make table cells non-editable
      }
    };
    cartTable = new JTable(tableModel);
    cartTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
    cartTable.setFillsViewportHeight(true);

    
    JScrollPane scrollPane = new JScrollPane(cartTable);
    add(scrollPane, BorderLayout.CENTER);

    
    JPanel paymentPanel = new JPanel();
    paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
    paymentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    paymentPanel.setPreferredSize(new Dimension(500, 0)); 
    add(paymentPanel, BorderLayout.EAST);

   
    balanceLabel = new JLabel("Balance: TL " + loggedUser.getBalance());
    balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
    balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    paymentPanel.add(balanceLabel);

 
    totalPriceLabel = new JLabel("Total Price: TL");
    totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
    totalPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    paymentPanel.add(totalPriceLabel);

   
    ButtonGroup paymentGroup = new ButtonGroup();
    cardPayment = new JRadioButton("Credit Card");
    visaPayment = new JRadioButton("Visa Transfer");
    walletPayment = new JRadioButton("Wallet Balance");

    paymentGroup.add(cardPayment);
    paymentGroup.add(visaPayment);
    paymentGroup.add(walletPayment);

    paymentPanel.add(Box.createVerticalStrut(20)); // Space between components
    paymentPanel.add(cardPayment);
    paymentPanel.add(visaPayment);
    paymentPanel.add(walletPayment);

    clearButton = new JButton("Clear the Cart");
    clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    clearButton.addActionListener(e -> {
      loggedUser.getShoppingCart().revertStock();
      loggedUser.getShoppingCart().clear();
      updateCartDisplay();
    });

    paymentPanel.add(clearButton);
   
    payButton = new JButton("Pay");
    payButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    payButton.addActionListener(e -> {
      if(loggedUser.getShoppingCart().getProductList().isEmpty()){
        paymentStatusLabel.setForeground(Color.RED);
        paymentStatusLabel.setText("Shopping Cart is Empty!");
        return;
      }
      if(loggedUser.getShoppingCart().getCartPrice() > loggedUser.getBalance()){
        paymentStatusLabel.setForeground(Color.RED);
        paymentStatusLabel.setText("Not Enough Money To Pay!");
      } else if (!cardPayment.isSelected() && !walletPayment.isSelected() && !visaPayment.isSelected()) {
        paymentStatusLabel.setForeground(Color.RED);
        paymentStatusLabel.setText("Payment Method Not Selected!");
      } else{
        if (cardPayment.isSelected()){
          paymentMethod = new CreditCardPaymentMethod();
          paymentStatusLabel.setText(paymentMethod.pay(loggedUser));
        } else if (walletPayment.isSelected()) {
          paymentMethod = new DigitalWalletPaymentMethod();
          paymentStatusLabel.setText(paymentMethod.pay(loggedUser));
        }else if (visaPayment.isSelected()){
          paymentMethod = new VisaPaymentMethod();
          paymentStatusLabel.setText(paymentMethod.pay(loggedUser));
        }
        loggedUser.getShoppingCart().clear();
        paymentStatusLabel.setForeground(Color.GREEN);
        balanceLabel.setText("Balance: TL " + loggedUser.getBalance());
        updateCartDisplay();
      }
    });
    paymentPanel.add(Box.createVerticalStrut(20)); // Space between components
    paymentPanel.add(payButton);

    
    paymentStatusLabel = new JLabel("");
    paymentStatusLabel.setFont(new Font("Arial", Font.BOLD, 12));
    paymentStatusLabel.setForeground(Color.GREEN);
    paymentStatusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    paymentPanel.add(Box.createVerticalStrut(10)); // Space between components
    paymentPanel.add(paymentStatusLabel);

    
    updateCartDisplay();

    setVisible(true);
  }

  private void updateCartDisplay() {
    DefaultTableModel tableModel = (DefaultTableModel) cartTable.getModel();
    tableModel.setRowCount(0); 

    List<Product> cartItems = loggedUser.getShoppingCart().getProductList();

    for (Product product : cartItems) {
      Object[] row = {
          product.getBrand(),
          product.getName(),
          "TL" + product.getPrice(),
          product.getStock()
      };
      tableModel.addRow(row);
    }

    totalPriceLabel.setText("Total Price: TL" + loggedUser.getShoppingCart().getCartPrice());

    cartTable.revalidate();
    cartTable.repaint();
  }
}

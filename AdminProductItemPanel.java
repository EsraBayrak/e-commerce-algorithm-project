package com.study.gui.component;

import com.study.constant.ImageIcons;
import com.study.model.Product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminProductItemPanel extends JPanel {

  private JLabel imageLabel;
  private JLabel brandLabel;
  private JLabel nameLabel;
  private JLabel priceLabel;
  private JLabel stockLabel;
  private JTextField newStockField;
  private JTextField newPriceField;
  private JButton updateStockButton;
  private JButton updatePriceButton;


  public AdminProductItemPanel(Product product) {
    setLayout(new BorderLayout());
    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    setBackground(Color.WHITE);

    imageLabel = new JLabel(new ImageIcon(product.getImage()));
    imageLabel.setPreferredSize(new Dimension(200, 150));
    imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(imageLabel, BorderLayout.NORTH);

    JPanel detailsPanel = new JPanel();
    detailsPanel.setLayout(new GridLayout(7, 2, 5, 5));
    detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    detailsPanel.setBackground(Color.WHITE);

    brandLabel = new JLabel("Brand: " + product.getBrand());
    brandLabel.setFont(new Font("Arial", Font.BOLD, 12));
    detailsPanel.add(brandLabel);
    detailsPanel.add(new JLabel());

    nameLabel = new JLabel("Name: " + product.getName());
    nameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    detailsPanel.add(nameLabel);
    detailsPanel.add(new JLabel());

    priceLabel = new JLabel("Price: TL" + product.getPrice());
    priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
    detailsPanel.add(priceLabel);
    detailsPanel.add(new JLabel());

    stockLabel = new JLabel("Stock: " + product.getStock());
    stockLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    detailsPanel.add(stockLabel);
    detailsPanel.add(new JLabel()); // Empty label for grid layout

    newStockField = new JTextField();
    detailsPanel.add(new JLabel("New Stock:"));
    detailsPanel.add(newStockField);

    newPriceField = new JTextField();
    detailsPanel.add(new JLabel("New Price:"));
    detailsPanel.add(newPriceField);

    updateStockButton = new JButton("Update Stock", ImageIcons.updateStock);
    updatePriceButton = new JButton("Update Price", ImageIcons.updatePrice);
    updatePriceButton.setFocusable(false);
    updateStockButton.setFocusable(false);
    updatePriceButton.addActionListener(e -> {
      try {
        int newPrice = Integer.parseInt(newPriceField.getText());
        product.setPrice(newPrice);
        priceLabel.setText("Price: TL" + product.getPrice());
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid price value", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });
    updateStockButton.addActionListener(e -> {
      try {
        int newStock = Integer.parseInt(newStockField.getText());
        product.setStock(newStock);
        stockLabel.setText("Stock: " + product.getStock());
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid stock value", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    detailsPanel.add(updatePriceButton);
    detailsPanel.add(updateStockButton);

    add(detailsPanel, BorderLayout.CENTER);
  }
}

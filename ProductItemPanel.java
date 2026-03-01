package com.study.gui.component;

import com.study.constant.ImageIcons;
import com.study.model.Product;
import com.study.model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductItemPanel extends JPanel {

  private JLabel imageLabel;
  private JLabel brandLabel;
  private JLabel nameLabel;
  private JLabel priceLabel;
  private JLabel stockLabel;
  private JButton addToCartButton;

  public ProductItemPanel(Product product, User user) {
    setLayout(new BorderLayout());

    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    setBackground(Color.WHITE);

    imageLabel = new JLabel(new ImageIcon(product.getImage()));
    imageLabel.setPreferredSize(new Dimension(200, 150));
    imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(imageLabel, BorderLayout.NORTH);

    JPanel detailsPanel = new JPanel();
    detailsPanel.setLayout(new GridLayout(5, 1, 5, 5));
    detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    detailsPanel.setBackground(Color.WHITE);

    brandLabel = new JLabel("Brand: " + product.getBrand());
    brandLabel.setFont(new Font("Arial", Font.BOLD, 12));
    detailsPanel.add(brandLabel);

    nameLabel = new JLabel("Name: " + product.getName());
    nameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    detailsPanel.add(nameLabel);

    priceLabel = new JLabel("Price: TL" + product.getPrice());
    priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
    detailsPanel.add(priceLabel);

    stockLabel = new JLabel("Stock: " + product.getStock());
    stockLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    detailsPanel.add(stockLabel);

    addToCartButton = new JButton("Add to Cart", ImageIcons.bag);
    addToCartButton.setFocusable(false);
    addToCartButton.addActionListener(e -> {

      product.setStock(product.getStock() - 1);
      user.addToShoppingCart(product);
      stockLabel.setText("Stock: " + product.getStock());

    });
    detailsPanel.add(addToCartButton);

    add(detailsPanel, BorderLayout.CENTER);
  }

}

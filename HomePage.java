package com.study.gui.view;

import com.study.constant.ImageIcons;
import com.study.gui.component.ProductItemPanel;
import com.study.model.Product;
import com.study.model.User;
import com.study.util.Filter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HomePage extends DefaultPage{

  private JPanel productsPanel;
  private JPanel filterPanel;
  private JPanel topBarPanel;
  private User loggedUser;

  public HomePage(User loggedUser) {
    super();

    this.loggedUser = loggedUser;

    setTitle("Home Page");

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

    JButton cartButton = new JButton("Cart", ImageIcons.cart);
    JButton logoutButton = new JButton("Logout", ImageIcons.exit);
    cartButton.setFocusable(false);
    cartButton.addActionListener(e -> navigateToCart());
    logoutButton.setFocusable(false);
    logoutButton.addActionListener(e -> performLogout());
    topBarPanel.add(cartButton, gbc);
    gbc.insets = new Insets(0, 0, 0, 20);
    topBarPanel.add(logoutButton, gbc);
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

    
    filterPanel = new JPanel(new BorderLayout());
    filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
    filterPanel.setBorder(BorderFactory.createTitledBorder("Filters"));

    JLabel categoryLabel = new JLabel("Category");
    categoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    filterPanel.add(categoryLabel);

    JCheckBox electronics = new JCheckBox("Electronics");
    JCheckBox wear = new JCheckBox("Wear");
    JCheckBox garden = new JCheckBox("Home & Garden");
    electronics.setSelected(true);
    wear.setSelected(true);
    garden.setSelected(true);

    int margin = 25;
    electronics.setBorder(BorderFactory.createEmptyBorder(0, margin, 0, 0));
    wear.setBorder(BorderFactory.createEmptyBorder(0, margin, 0, 0));
    garden.setBorder(BorderFactory.createEmptyBorder(0, margin, 0, 0));

    filterPanel.add(electronics);
    filterPanel.add(wear);
    filterPanel.add(garden);

    JButton filterButton = new JButton("Filter", ImageIcons.filter);
    filterButton.setFocusable(false);
    filterButton.addActionListener(e -> {
      updateProducts(Filter.filter(electronics.isSelected(), wear.isSelected(), garden.isSelected(), 3000));
    });

    filterPanel.add(Box.createHorizontalStrut(margin));
    filterPanel.add(filterButton, BorderLayout.WEST);
    filterPanel.add(Box.createVerticalStrut((getHeight() /4 * 3) - 35) );

    filterPanel.setPreferredSize(new Dimension(getWidth() / 5, getHeight()));
    add(filterPanel, BorderLayout.WEST);



    productsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    productsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    productsPanel.setBackground(Color.WHITE);
    JScrollPane scrollPane = new JScrollPane(productsPanel);
    add(scrollPane, BorderLayout.CENTER);

    updateProducts(Filter.filter(true, true, true, 3000));

    setVisible(true);
  }

  void updateProducts(List<Product> productList) {
    productsPanel.removeAll();
    productsPanel.revalidate();
    productsPanel.repaint();
    for (Product product : productList) {
      addProduct(product);
    }
  }


  public void addProduct(Product product) {
    ProductItemPanel productPanel = new ProductItemPanel(product, this.loggedUser);
    productsPanel.add(productPanel);
    productsPanel.revalidate();
    productsPanel.repaint();
  }

  public void navigateToCart(){
    setVisible(false);
    dispose();
    new CartPage(loggedUser);
  }

  public void performLogout(){
    setVisible(false);
    dispose();
    new LoginPage();
  }
}
package com.study.gui.view;

import com.study.constant.ImageIcons;
import com.study.gui.component.AdminProductItemPanel;
import com.study.model.Product;
import com.study.repository.ProductRepository;
import com.study.util.Report;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AdminPage extends DefaultPage {

  private JPanel topBarPanel;
  private JPanel productPanel;

  public AdminPage() {
    super();

    setTitle("Admin Page");

  
    topBarPanel = new JPanel();
    topBarPanel.setBackground(new Color(63, 71, 95));
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

    JButton reportButton = new JButton("Export Report", ImageIcons.report);
    reportButton.setFocusable(false);
    reportButton.addActionListener(e -> Report.createReport());
    JButton logoutButton = new JButton("Logout", ImageIcons.exit);
    logoutButton.setFocusable(false);
    logoutButton.addActionListener(e -> performLogout());
    topBarPanel.add(reportButton, gbc);
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

    
    productPanel = new JPanel();
    productPanel.setLayout(new GridLayout(0, 4, 10, 10)); // 3 columns, with 10px gaps
    productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

   
    for (Product product : ProductRepository.productList) {
      AdminProductItemPanel itemPanel = new AdminProductItemPanel(product);
      productPanel.add(itemPanel);
    }

    
    JScrollPane scrollPane = new JScrollPane(productPanel);
    add(scrollPane, BorderLayout.CENTER);

    setVisible(true);
  }

  public void performLogout() {
    setVisible(false);
    dispose();
    new LoginPage();
  }
}
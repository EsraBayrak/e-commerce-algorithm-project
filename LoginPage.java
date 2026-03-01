package com.study.gui.view;

import com.study.constant.Constants;
import com.study.constant.ImageIcons;
import com.study.constant.Images;
import com.study.gui.component.BackgroundPanel;
import com.study.model.User;
import com.study.repository.UserRepository;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends DefaultPage {

  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton;
  private Container containerCredentials;
  private Container bigContainer;

  private Integer bigContainerWidth = 200;
  private Integer bigContainerHeight = 150;

  public LoginPage() {
    super();

    BackgroundPanel backgroundPanel = new BackgroundPanel(Images.loginBackground);
    backgroundPanel.setBounds(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

    setTitle("Login Page");
    setLayout(null);

    bigContainer = new Container();
    bigContainer.setLayout(null);

    containerCredentials = new Container();
    containerCredentials.setLayout(new GridLayout(3, 2, 5, 5));

    containerCredentials.add(new JLabel("Username:"));

    usernameField = new JTextField();
    containerCredentials.add(usernameField);

    containerCredentials.add(new JLabel("Password:"));
    passwordField = new JPasswordField();
    containerCredentials.add(passwordField);

    loginButton = new JButton("Login", ImageIcons.login);
    loginButton.setBounds(50, 75, 100, 25);
    loginButton.addActionListener(e -> performLogin());

    containerCredentials.setBounds(0, 0, 200, 100);
    bigContainer.add(containerCredentials);
    bigContainer.add(loginButton);

    bigContainer.setBounds((Constants.FRAME_WIDTH - bigContainerWidth) / 2,
        (Constants.FRAME_HEIGHT - bigContainerHeight) / 2, bigContainerWidth, bigContainerHeight);


    backgroundPanel.add(bigContainer);
    add(backgroundPanel);

    setVisible(true);

  }

  private void performLogin() {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    User loggedUser = UserRepository.getUserByUserName(username);

    if (loggedUser == null) {
      JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (loggedUser.getUserName().equals(username) && loggedUser.getPassword().equals(password)) {
      setVisible(false);
      dispose();

      if (loggedUser.getAdmin()) {
        new AdminPage();
      } else {
        new HomePage(loggedUser);

      }
    } else {
      JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

}


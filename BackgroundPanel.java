package com.study.gui.component;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
  private final Image backgroundImage;

  public BackgroundPanel(Image image) {
    this.backgroundImage = image;
    setLayout(null);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
  }
}

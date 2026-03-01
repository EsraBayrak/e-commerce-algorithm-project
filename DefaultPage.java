package com.study.gui.view;

import com.study.constant.Constants;
import javax.swing.JFrame;

public abstract class DefaultPage extends JFrame {



  public DefaultPage(){
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); 
    setResizable(false);
  }

}

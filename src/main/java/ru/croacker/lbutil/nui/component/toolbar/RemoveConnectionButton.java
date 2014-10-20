package ru.croacker.lbutil.nui.component.toolbar;

import javax.swing.*;

/**
 */
public class RemoveConnectionButton extends JButton {

  public RemoveConnectionButton(){
    initComponents();
  }

  private void initComponents() {
    setText("Удалить");
    setFocusable(false);
    setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  }

}

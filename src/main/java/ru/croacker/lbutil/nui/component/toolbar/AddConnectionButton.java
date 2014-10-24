package ru.croacker.lbutil.nui.component.toolbar;

import javax.swing.*;

/**
 *
 */
public class AddConnectionButton extends JButton {

  public AddConnectionButton() {
    initComponents();
  }

  private void initComponents() {
    setText("Добавить");
    setFocusable(false);
    setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  }

}

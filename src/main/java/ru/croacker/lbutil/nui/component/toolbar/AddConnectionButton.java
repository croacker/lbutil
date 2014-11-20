package ru.croacker.lbutil.nui.component.toolbar;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class AddConnectionButton extends JButton {

  public AddConnectionButton() {
  }

  @PostConstruct
  private void initComponents() {
    setText("Добавить");
    setFocusable(false);
    setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  }

}

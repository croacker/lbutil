package ru.croacker.lbutil.nui.component.toolbar;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class RemoveConnectionButton extends JButton {

  public RemoveConnectionButton(){
  }

  @PostConstruct
  private void initComponents() {
    setText("Удалить");
    setFocusable(false);
    setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  }

}

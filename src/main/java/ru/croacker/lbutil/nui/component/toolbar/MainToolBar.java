package ru.croacker.lbutil.nui.component.toolbar;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
public class MainToolBar extends JToolBar {

  private AddConnectionButton jbAddConnection;
  private RemoveConnectionButton jbRemoveConnection;

  public MainToolBar(){
  }

  @PostConstruct
  private void initComponents() {
    setRollover(true);

    jbAddConnection = new AddConnectionButton();
    add(jbAddConnection);
    jbAddConnection.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "НАЖАЛИ!");
      }
    });

    jbRemoveConnection = new RemoveConnectionButton();
    add(jbRemoveConnection);
  }

}

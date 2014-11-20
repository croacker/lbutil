package ru.croacker.lbutil.nui.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class ConnectionsPopupMenu extends JPopupMenu {

  private JMenuItem jmiAddConnection;

  private JMenuItem jmiRemoveConnection;

  public ConnectionsPopupMenu(){
  }

  @PostConstruct
  private void initComponents() {
    jmiAddConnection = new JMenuItem();
    jmiAddConnection.setText("Добавить");
    add(jmiAddConnection);

    jmiRemoveConnection = new JMenuItem();
    jmiRemoveConnection.setText("Удалить");
    add(jmiRemoveConnection);
  }

}

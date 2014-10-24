package ru.croacker.lbutil.nui.component;

import javax.swing.*;

/**
 *
 */
public class ConnectionsPopupMenu extends JPopupMenu {

  private JMenuItem jmiAddConnection;

  private JMenuItem jmiRemoveConnection;

  public ConnectionsPopupMenu(){
    initComponents();
  }

  private void initComponents() {
    jmiAddConnection = new JMenuItem();
    jmiAddConnection.setText("Добавить");
    add(jmiAddConnection);

    jmiRemoveConnection = new JMenuItem();
    jmiRemoveConnection.setText("Удалить");
    add(jmiRemoveConnection);
  }

}

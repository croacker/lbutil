package ru.croacker.lbutil.nui.component.connection;

import ru.croacker.lbutil.ui.model.ConnectionUnitModel;

import javax.swing.*;

/**
 */
public class ConnectionsList extends JList<ConnectionUnitModel> {

  public ConnectionsList(){
    initComponents();
  }

  private void initComponents() {
    setModel(new ConnectionUnitModel());
  }


}

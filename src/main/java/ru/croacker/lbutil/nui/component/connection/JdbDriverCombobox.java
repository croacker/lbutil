package ru.croacker.lbutil.nui.component.connection;

import ru.croacker.lbutil.database.JdbcDriver;

import javax.swing.*;

/**
 * ����� JDBC ��������
 */
public class JdbDriverCombobox extends JComboBox<JdbcDriver>{

  public JdbDriverCombobox(){
    initComponents();
  }

  private void initComponents() {
    for(JdbcDriver jdbcDriver: JdbcDriver.values()){
      addItem(jdbcDriver);
    }
  }

}

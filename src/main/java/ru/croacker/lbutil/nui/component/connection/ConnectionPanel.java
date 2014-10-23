package ru.croacker.lbutil.nui.component.connection;

import javax.swing.*;

/**
 * Параметры текущего соединения
 */
public class ConnectionPanel extends JPanel {

  private JLabel jlJdbcDriver;
  private JdbDriverCombobox jcbJdbcDriver;
  private JLabel jlUrl;
  private JTextField jtfUrl;
  private JLabel jlUser;
  private JTextField jtfUser;
  private JLabel jlPassword;
  private JTextField jtfPassword;
  private JButton jbTestConnection;


  public ConnectionPanel(){
    initComponents();
  }

  private void initComponents() {
    setToolTipText("Параметры соединения");
    setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jlJdbcDriver = new javax.swing.JLabel("JDBC-драйвер:");
    jcbJdbcDriver = new JdbDriverCombobox();

    jlUrl = new JLabel("URL:");
    jtfUrl = new JTextField();

    jlUser = new javax.swing.JLabel("Пользователь:");
    jtfUser = new javax.swing.JTextField();

    jlPassword = new javax.swing.JLabel();
    jtfPassword = new javax.swing.JTextField();

    jbTestConnection = new javax.swing.JButton("Проверить");
  }

}

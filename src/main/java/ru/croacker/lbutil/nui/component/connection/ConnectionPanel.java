package ru.croacker.lbutil.nui.component.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.database.DbConnectionDto;
import ru.croacker.lbutil.service.LiquibaseService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Параметры текущего соединения
 */
@Component
public class ConnectionPanel extends JPanel {

  @Autowired
  private LiquibaseService liquibaseService;

  @Autowired
  private JdbDriverCombobox jcbJdbcDriver;
  private JLabel jlJdbcDriver;
  private JLabel jlUrl;
  private JTextField jtfUrl;
  private JLabel jlUser;
  private JTextField jtfUser;
  private JLabel jlPassword;
  private JTextField jtfPassword;
  private JButton jbTestConnection;

  private DbConnectionDto currentConnection;

  public ConnectionPanel(){
  }

  @PostConstruct
  private void initComponents() {
    setToolTipText("Параметры соединения");
    setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jlJdbcDriver = new JLabel("JDBC-драйвер:");

    jlUrl = new JLabel("URL:");
    jtfUrl = new JTextField();

    jlUser = new JLabel("Пользователь:");
    jtfUser = new JTextField();

    jlPassword = new JLabel("Пароль:");
    jtfPassword = new JTextField();

    jbTestConnection = new JButton("Проверить");

    javax.swing.GroupLayout jpConnectionLayout = new javax.swing.GroupLayout(this);
    setLayout(jpConnectionLayout);
    jpConnectionLayout.setHorizontalGroup(
        jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpConnectionLayout.createSequentialGroup()
                        .addComponent(jlJdbcDriver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbJdbcDriver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfUrl)
                    .addGroup(jpConnectionLayout.createSequentialGroup()
                        .addComponent(jlUrl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpConnectionLayout.createSequentialGroup()
                        .addComponent(jlUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPassword)
                            .addComponent(jbTestConnection, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                .addContainerGap())
    );
    jpConnectionLayout.setVerticalGroup(
        jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlJdbcDriver)
                    .addComponent(jcbJdbcDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlPassword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbTestConnection)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

  }

  public void addTestConnectionListener(ActionListener actionListener){
    jbTestConnection.addActionListener(actionListener);
  }



  private void testConnection(){
    JOptionPane.showMessageDialog(null,
        liquibaseService.testConnection(getConnection()));
  }

  public DbConnectionDto getConnection() {
    if(currentConnection == null){
      currentConnection = new DbConnectionDto();
    }
    currentConnection.setId(null)
        .setJdbcDriver(jcbJdbcDriver.getDriverName())
        .setUrl(jtfUrl.getText())
        .setUser(jtfUser.getText())
        .setPassword(jtfPassword.getText());

    return currentConnection;
  }

  public void setConnection(DbConnectionDto connection){
    currentConnection = connection;
    if(currentConnection == null){
      jcbJdbcDriver.setSelectedIndex(0);
      jtfUrl.setText("");
      jtfUser.setText("");
      jtfPassword.setText("");
    }
  }
}

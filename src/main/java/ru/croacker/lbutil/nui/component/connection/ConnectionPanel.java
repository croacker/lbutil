package ru.croacker.lbutil.nui.component.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.nui.component.common.UtilButton;
import ru.croacker.lbutil.nui.component.common.UtilLabel;
import ru.croacker.lbutil.nui.component.common.UtilTextField;

import javax.swing.*;

/**
 * Параметры текущего соединения
 */
@Component
public class ConnectionPanel extends JPanel {

  @Autowired(@Value("JDBC-драйвер:") String url)
  private UtilLabel jlJdbcDriver;
  @Autowired
  private JdbDriverCombobox jcbJdbcDriver;
  @Autowired
  private UtilLabel jlUrl;
  @Autowired
  private UtilTextField jtfUrl;
  @Autowired
  private UtilLabel jlUser;
  @Autowired
  private UtilTextField jtfUser;
  @Autowired
  private UtilLabel jlPassword;
  @Autowired
  private UtilTextField jtfPassword;
  @Autowired
  private UtilButton jbTestConnection;


  public ConnectionPanel(){
    initComponents();
  }

  private void initComponents() {
    setToolTipText("Параметры соединения");
    setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jlJdbcDriver = new UtilLabel("JDBC-драйвер:");
    jcbJdbcDriver = new JdbDriverCombobox();

    jlUrl = new UtilLabel("URL:");
    jtfUrl = new UtilTextField();

    jlUser = new UtilLabel("Пользователь:");
    jtfUser = new UtilTextField();

    jlPassword = new UtilLabel("Пароль:");
    jtfPassword = new UtilTextField();

    jbTestConnection = new UtilButton("Проверить");

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

}

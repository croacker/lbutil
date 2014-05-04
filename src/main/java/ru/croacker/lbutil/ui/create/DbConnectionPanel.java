package ru.croacker.lbutil.ui.create;

import lombok.extern.slf4j.Slf4j;
import ru.croacker.lbutil.database.JdbcDriver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 15.03.14.
 * Параметры подключения к БД
 */
@Slf4j
public class DbConnectionPanel extends javax.swing.JPanel {

    private JLabel jlJdbcDriver;
    private JComboBox jcbJdbcDriver;
    private JLabel jlUrl;
    private JTextField jtfUrl;
    private JLabel jlUser;
    private JTextField jtfUser;
    private JLabel jlPassword;
    private JPasswordField jpfPassword;
    private javax.swing.JLabel jlErrorText;
    private javax.swing.JButton jbTestConnection;

    public JdbcDriver getJdbcDriver(){
        return (JdbcDriver)jcbJdbcDriver.getSelectedItem();
    }

    public String getJdbcDriverName(){
        return ((JdbcDriver)jcbJdbcDriver.getSelectedItem()).getDriverName();
    }

    public String getUrl(){
        return jtfUrl.getText();
    }

    public String getUser(){
        return jtfUser.getText();
    }

    public String getPassword(){
        return jpfPassword.getText();
    }

    public void setErrorText(String errorText){
        jlErrorText.setText(errorText);
    }

    public JButton getJbTestConnection(){
        return jbTestConnection;
    }

    public DbConnectionPanel(){
        initComponents();
    }

    private void initComponents() {
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlJdbcDriver = new JLabel("JDBC-драйвер:");
        jlUrl = new javax.swing.JLabel("URL:");
        jlUser = new JLabel("Пользователь:");
        jlPassword = new JLabel("Пароль:");

        jcbJdbcDriver = new JComboBox();
        for(JdbcDriver jdbcDriver: JdbcDriver.values()){
            jcbJdbcDriver.addItem(jdbcDriver);
        }

        jtfUrl = new JTextField();
        jtfUser = new JTextField();
        jpfPassword = new JPasswordField();
        jlErrorText = new JLabel();
        jlErrorText.setForeground(Color.RED);

        jbTestConnection = new javax.swing.JButton("Тестовое соединение");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jlErrorText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbTestConnection))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlJdbcDriver)
                                                        .addComponent(jlUrl)
                                                        .addComponent(jlUser)
                                                        .addComponent(jlPassword))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jcbJdbcDriver)
                                                        .addComponent(jtfUrl)
                                                        .addComponent(jtfUser)
                                                        .addComponent(jpfPassword))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlJdbcDriver)
                                        .addComponent(jcbJdbcDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtfUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlUrl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlUser))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbTestConnection)
                                        .addComponent(jlErrorText))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}

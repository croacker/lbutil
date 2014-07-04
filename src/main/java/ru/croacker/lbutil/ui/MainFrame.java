package ru.croacker.lbutil.ui;

import lombok.extern.slf4j.Slf4j;
import ru.croacker.lbutil.LbUtilApp;
import ru.croacker.lbutil.database.DbConnection;
import ru.croacker.lbutil.database.JdbcDriver;
import ru.croacker.lbutil.ui.connection.ConnectionListModel;
import ru.croacker.lbutil.ui.create.MainMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23.04.14
 * Time: 0:48
 * Главное - окно приложения
 */
@Slf4j
public class MainFrame extends JFrame implements CloseableFrame, Observer {

    private LbUtilApp app;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbTestConnection;
    private javax.swing.JList jlConnections;
    private javax.swing.JPopupMenu jpmConnections;
    private javax.swing.JTextField jtCurrentConnection;
    private javax.swing.JToolBar jtbMain;

    public MainFrame(LbUtilApp app) {
        this.app = app;
        initComponents();
    }

    private void initComponents() {
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Наборы изменений Liquibase");
        setJMenuBar(new MainMenuBar(this));

        jpmConnections = new javax.swing.JPopupMenu();
        jtbMain = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlConnections = new javax.swing.JList();
        jtCurrentConnection = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbTestConnection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbMain.setRollover(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlConnections.setModel(getStubConnectionsListModel());
        jlConnections.setComponentPopupMenu(getPopupMenu());
        jScrollPane1.setViewportView(jlConnections);

        jtCurrentConnection.setEditable(false);

        jLabel1.setText("Текущее соединение:");

        jbTestConnection.setText("Тест");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 14, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtCurrentConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbTestConnection))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtCurrentConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jbTestConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtbMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jtbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }

    private void setJMenuBar(MainMenuBar mainMenuBar) {

    }

    private ListModel getStubConnectionsListModel() {
        ConnectionListModel connectionListModel = new ConnectionListModel();
        connectionListModel.add(
        new DbConnection().setJdbcDriver(JdbcDriver.H2.getDriverName())
                .setUrl("jdbc:h2:tcp://localhost/~/master;MODE=Oracle")
                .setUser("master")
                .setPassword("123"));

        connectionListModel.add(
                new DbConnection().setJdbcDriver(JdbcDriver.POSTGRESQL.getDriverName())
                        .setUrl("jdbc:postgresql://host/database")
                        .setUser("postgre")
                        .setPassword("postgre"));

        connectionListModel.add(
                new DbConnection().setJdbcDriver(JdbcDriver.ORACLE.getDriverName())
                        .setUrl("jdbc:oracle:kprb:uts@//123")
                        .setUser("uts")
                        .setPassword("123"));


        return connectionListModel;  //To change body of created methods use File | Settings | File Templates.
    }

    public void closeApp() {
        int confirm = JOptionPane.showOptionDialog(this,
                "Закрыть приложение?",
                "Экспорт набора изменений Liquibase", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (confirm == JOptionPane.YES_OPTION) {
            app.close();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showOptionDialog(this,
                "Обновить соединение?",
                "Обновить соединение", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
    }

    private JPopupMenu getPopupMenu(){
        JPopupMenu jpmConnections = new JPopupMenu();

        JMenuItem item = new JMenuItem("Добавить");
        item.setHorizontalTextPosition(JMenuItem.LEFT);
        item.addActionListener(getAddActionListener());
        jpmConnections.add(item);

        item = new JMenuItem("Редактировать");
        item.setHorizontalTextPosition(JMenuItem.LEFT);
        item.addActionListener(getEditActionListener());
        jpmConnections.add(item);

        item = new JMenuItem("Удалить");
        item.setHorizontalTextPosition(JMenuItem.LEFT);
        item.addActionListener(getRemoveActionListener());
        jpmConnections.add(item);

        return jpmConnections;
    }

    private ActionListener getAddActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    private ActionListener getEditActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    private ActionListener getRemoveActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}

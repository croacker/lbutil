package ru.croacker.lbutil.nui;

import ru.croacker.lbutil.LbUtilApp;
import ru.croacker.lbutil.nui.component.ConnectionsPopupMenu;
import ru.croacker.lbutil.nui.component.connection.ConnectionPanel;
import ru.croacker.lbutil.nui.component.connection.ConnectionsList;
import ru.croacker.lbutil.nui.component.connection.ConnectionsListPanel;
import ru.croacker.lbutil.nui.component.connection.JdbDriverCombobox;
import ru.croacker.lbutil.nui.component.exp.ExportChangelogPanel;
import ru.croacker.lbutil.nui.component.imp.ImportChangelogPanel;
import ru.croacker.lbutil.nui.component.toolbar.MainToolBar;
import ru.croacker.lbutil.ui.model.ConnectionUnitModel;

/**
 *
 * @author a_gumenyuk
 */
public class MainFrm extends javax.swing.JFrame {

  private ImportChangelogPanel jpImport;
  private javax.swing.JButton jbTestConnection;
  private JdbDriverCombobox jcbJdbcDriver;
  private javax.swing.JLabel jlJdbcDriver;
  private javax.swing.JLabel jlPassword;
  private javax.swing.JLabel jlUrl;
  private javax.swing.JLabel jlUser;
  private javax.swing.JMenu jmFile;
  private javax.swing.JMenu jmHelp;
  private javax.swing.JMenu jmService;
  private javax.swing.JMenuBar jmbMain;
  private javax.swing.JMenuItem jmiAbout;
  private javax.swing.JMenuItem jmiExit;
  private javax.swing.JMenuItem jmiParameters;
  private javax.swing.JPanel jpConnection;
  private javax.swing.JPanel jpConnectionsListPanel;
  private javax.swing.JPanel jpContent;
  private ExportChangelogPanel jpExport;
  private javax.swing.JToolBar jtbMain;
  private javax.swing.JTextField jtfPassword;
  private javax.swing.JTextField jtfUrl;
  private javax.swing.JTextField jtfUser;

  public MainFrm(LbUtilApp app) {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    jtbMain = new MainToolBar();

    jpContent = new javax.swing.JPanel();
    jpConnectionsListPanel = new ConnectionsListPanel();

    jpConnection = new ConnectionPanel();
    jlJdbcDriver = new javax.swing.JLabel();
    jcbJdbcDriver = new JdbDriverCombobox();
    jlUrl = new javax.swing.JLabel();
    jtfUrl = new javax.swing.JTextField();
    jlUser = new javax.swing.JLabel();
    jlPassword = new javax.swing.JLabel();
    jtfUser = new javax.swing.JTextField();
    jtfPassword = new javax.swing.JTextField();
    jbTestConnection = new javax.swing.JButton();
    jpExport = new ExportChangelogPanel();
    jpImport = new ImportChangelogPanel();
    jmbMain = new javax.swing.JMenuBar();
    jmFile = new javax.swing.JMenu();
    jmiExit = new javax.swing.JMenuItem();
    jmService = new javax.swing.JMenu();
    jmiParameters = new javax.swing.JMenuItem();
    jmHelp = new javax.swing.JMenu();
    jmiAbout = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jlJdbcDriver.setText("JDBC-драйвер:");

    jlUrl.setText("URL:");

    jlUser.setText("Пользователь:");

    jlPassword.setText("Пароль:");

    jbTestConnection.setText("Проверить");

    javax.swing.GroupLayout jpConnectionLayout = new javax.swing.GroupLayout(jpConnection);
    jpConnection.setLayout(jpConnectionLayout);
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

    javax.swing.GroupLayout jpContentLayout = new javax.swing.GroupLayout(jpContent);
    jpContent.setLayout(jpContentLayout);
    jpContentLayout.setHorizontalGroup(
        jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addComponent(jpConnectionsListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
    );
    jpContentLayout.setVerticalGroup(
        jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpConnectionsListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addComponent(jpConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
    );

    jmFile.setText("Файл");

    jmiExit.setText("Выход");
    jmFile.add(jmiExit);

    jmbMain.add(jmFile);

    jmService.setText("Сервис");

    jmiParameters.setText("Параметры");
    jmService.add(jmiParameters);

    jmbMain.add(jmService);

    jmHelp.setText("Справка");

    jmiAbout.setText("О'б");
    jmHelp.add(jmiAbout);

    jmbMain.add(jmHelp);

    setJMenuBar(jmbMain);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }

}

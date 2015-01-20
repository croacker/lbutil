package ru.croacker.lbutil.nui;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.nui.component.MainMenuBar;
import ru.croacker.lbutil.nui.component.connection.ConnectionPanel;
import ru.croacker.lbutil.nui.component.connection.ConnectionsListPanel;
import ru.croacker.lbutil.nui.component.exp.ExportChangelogPanel;
import ru.croacker.lbutil.nui.component.imp.ImportChangelogPanel;
import ru.croacker.lbutil.nui.component.toolbar.MainToolBar;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author a_gumenyuk
 */
@Component
public class MainFrm extends javax.swing.JFrame {

  private JPanel jpContent;

  @Autowired
  @Getter @Setter
  private MainMenuBar mainMenuBar;

  @Autowired
  @Getter @Setter
  private MainToolBar jtbMain;

  @Autowired
  @Getter @Setter
  private ConnectionsListPanel jpConnectionsListPanel;

  @Autowired
  @Getter @Setter
  private ConnectionPanel jpConnection;

  @Autowired
  @Getter @Setter
  private ImportChangelogPanel jpImport;

  @Autowired
  @Getter @Setter
  private ExportChangelogPanel jpExport;

  private JButton jbSave;

  public MainFrm() {
  }

  @SuppressWarnings("unchecked")
  @PostConstruct
  public void initComponents() {
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setJMenuBar(mainMenuBar);

    jpContent = new javax.swing.JPanel();

    jbSave = new JButton("Сохранить");
    jbSave.addActionListener(getSaveActionListener());

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
                    .addComponent(jpImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 85))
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
                .addComponent(jbSave, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
    );

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

  private ActionListener getSaveActionListener(){
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        saveConfiguration();
      }
    };
  }

  private void saveConfiguration() {
    jpConnectionsListPanel.saveConnection(jpConnection.getConnection());
  }

}

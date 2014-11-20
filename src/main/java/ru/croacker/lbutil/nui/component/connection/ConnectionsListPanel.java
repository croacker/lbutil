package ru.croacker.lbutil.nui.component.connection;

import org.springframework.stereotype.Component;
import ru.croacker.lbutil.nui.component.ConnectionsPopupMenu;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class ConnectionsListPanel extends JPanel {

  private ConnectionsList jlConnectionsList;

  private javax.swing.JScrollPane jspConnectionsListScrolPanel;

  public ConnectionsListPanel(){
  }

  @PostConstruct
  private void initComponents() {
    jlConnectionsList = new ConnectionsList();
    jlConnectionsList.setComponentPopupMenu(new ConnectionsPopupMenu());

    jspConnectionsListScrolPanel = new javax.swing.JScrollPane();
    jspConnectionsListScrolPanel.setViewportView(jlConnectionsList);

    javax.swing.GroupLayout jpConnectionsListLayout = new javax.swing.GroupLayout(this);
    setLayout(jpConnectionsListLayout);
    jpConnectionsListLayout.setHorizontalGroup(
        jpConnectionsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConnectionsListLayout.createSequentialGroup()
                .addComponent(jspConnectionsListScrolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
    );
    jpConnectionsListLayout.setVerticalGroup(
        jpConnectionsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspConnectionsListScrolPanel)
    );
  }

}

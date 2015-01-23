package ru.croacker.lbutil.nui.component.connection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.database.DbConnectionDto;
import ru.croacker.lbutil.nui.component.ConnectionsPopupMenu;
import ru.croacker.lbutil.service.PersistsService;
import ru.croacker.lbutil.ui.model.ConnectionUnitModel;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class ConnectionsListPanel extends JPanel {

  private ConnectionsList jlConnectionsList;

  private javax.swing.JScrollPane jspConnectionsListScrolPanel;

  @Autowired
  @Getter @Setter
  private PersistsService persistService;

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

    restoreConnections();
  }

  /**
   * Восстановить соединения из хранилища при запуске
   * //TODO Впоследствие вынести в сервис
   */
  private void restoreConnections(){

  }

  /**
   * Сохранить параметры соединения
   * @param connection
   */
  public void saveConnection(DbConnectionDto connection) {
    DbConnectionDto selectedConnection = getSelected();
    if (selectedConnection == null){
      selectedConnection = connection;
    }
    persistService.persists(selectedConnection);
  }

  /**
   *
   * @return
   */
  private DbConnectionDto getSelected() {
    ConnectionUnitModel connectionUnitModel = jlConnectionsList.getSelectedValue();
    if(connectionUnitModel == null ||
        connectionUnitModel.getSize() == 0){
      return null;
    }else {
      return (DbConnectionDto) connectionUnitModel.getElementAt(0);
    }
  }
}

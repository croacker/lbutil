package ru.croacker.lbutil.nui.component.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.service.ConfigurationService;
import ru.croacker.lbutil.service.IConnectionsService;
import ru.croacker.lbutil.ui.model.ConnectionUnitModel;

import javax.swing.*;

/**
 *
 */
@Component
public class ConnectionsList extends JList<ConnectionUnitModel> {

  @Autowired
  private IConnectionsService configurationService;

  public ConnectionsList(){
    initComponents();
  }

  private void initComponents() {
    setModel(new ConnectionUnitModel());
  }


}

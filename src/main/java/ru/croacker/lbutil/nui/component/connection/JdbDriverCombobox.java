package ru.croacker.lbutil.nui.component.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.database.JdbcDriver;
import ru.croacker.lbutil.service.IConfigurationService;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Выбор JDBC драйвера
 *
 */
@Component
public class JdbDriverCombobox extends JComboBox<JdbcDriver>{

  @Autowired
  private IConfigurationService configurationService;

  public JdbDriverCombobox(){
  }

  @PostConstruct
  private void initComponents() {
    for(JdbcDriver jdbcDriver: JdbcDriver.values()){
      addItem(jdbcDriver);
    }
  }

}

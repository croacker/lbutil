package ru.croacker.lbutil.nui.component.toolbar;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class MainToolBar extends JToolBar {

  private AddConnectionButton jbAddConnection;
  private RemoveConnectionButton jbRemoveConnection;

  public MainToolBar(){
  }

  @PostConstruct
  private void initComponents() {
    setRollover(true);

    jbAddConnection = new AddConnectionButton();
    add(jbAddConnection);

    jbRemoveConnection = new RemoveConnectionButton();
    add(jbRemoveConnection);
  }

}

package ru.croacker.lbutil.nui.component.toolbar;

import javax.swing.*;

/**
 */
public class MainToolBar extends JToolBar {

  private AddConnectionButton jbAddConnection;
  private RemoveConnectionButton jbRemoveConnection;

  public MainToolBar(){
    initComponents();
  }

  private void initComponents() {
    setRollover(true);

    jbAddConnection = new AddConnectionButton();
    add(jbAddConnection);

    jbRemoveConnection = new RemoveConnectionButton();
    add(jbRemoveConnection);
  }

}

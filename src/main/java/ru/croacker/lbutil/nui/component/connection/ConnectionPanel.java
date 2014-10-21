package ru.croacker.lbutil.nui.component.connection;

import javax.swing.*;

/**
 * Параметры текущего соединения
 */
public class ConnectionPanel extends JPanel {

  public ConnectionPanel(){
    initComponents();
  }

  private void initComponents() {
    setToolTipText("Параметры соединения");
    setBorder(javax.swing.BorderFactory.createEtchedBorder());

  }

}

package ru.croacker.lbutil.nui.component;

import javax.swing.*;

/**
 */
public class MainMenuBar extends JMenuBar {

  private JMenu jmFile;
  private JMenuItem jmiExit;

  private JMenu jmService;
  private JMenuItem jmiParameters;

  private JMenu jmHelp;
  private JMenuItem jmiAbout;

  public MainMenuBar(){
    initComponents();
  }

  private void initComponents() {
    jmFile = new JMenu("����");
    jmiExit = new JMenuItem("����");
    jmFile.add(jmiExit);
    add(jmFile);

    jmService = new JMenu("������");
    add(jmService);

    jmHelp = new JMenu("�������");
    add(jmHelp);
  }

}

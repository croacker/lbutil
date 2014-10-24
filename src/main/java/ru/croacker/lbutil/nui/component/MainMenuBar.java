package ru.croacker.lbutil.nui.component;

import javax.swing.*;

/**
 *
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
    jmFile = new JMenu("Файл");
    jmiExit = new JMenuItem("Файл");
    jmFile.add(jmiExit);
    add(jmFile);

    jmService = new JMenu("Сервис");
    jmiParameters = new JMenuItem("Параметры");
    jmService.add(jmiParameters);
    add(jmService);

    jmHelp = new JMenu("Справка");
    jmiAbout = new JMenuItem("О'б");
    jmHelp.add(jmiAbout);
    add(jmHelp);
  }

}

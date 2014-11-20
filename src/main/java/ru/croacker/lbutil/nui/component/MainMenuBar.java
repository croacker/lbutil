package ru.croacker.lbutil.nui.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 */
@Component
public class MainMenuBar extends JMenuBar {

  @Getter  @Setter
  private JMenu jmFile;

  @Getter  @Setter
  private JMenuItem jmiExit;

  @Getter  @Setter
  private JMenu jmService;

  @Getter  @Setter
  private JMenuItem jmiParameters;

  @Getter  @Setter
  private JMenu jmHelp;

  @Getter  @Setter
  private JMenuItem jmiAbout;

  public MainMenuBar(){
  }

  @PostConstruct
  public void initComponents() {
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

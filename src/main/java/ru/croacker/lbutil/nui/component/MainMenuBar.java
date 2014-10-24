package ru.croacker.lbutil.nui.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.nui.component.common.UtilMenu;
import ru.croacker.lbutil.nui.component.common.UtilMenuItem;

import javax.swing.*;

/**
 *
 */
@Component
@Lazy
public class MainMenuBar extends JMenuBar {

  @Autowired
  private UtilMenu jmFile;
  @Autowired
  private UtilMenuItem jmiExit;

  @Autowired
  private UtilMenu jmService;
  @Autowired
  private UtilMenuItem jmiParameters;

  @Autowired
  private UtilMenu jmHelp;
  @Autowired
  private UtilMenuItem jmiAbout;

  public MainMenuBar(){
    initComponents();
  }

  private void initComponents() {
//    jmFile.setText("Файл");
//    jmiExit.setText("Файл");
//    jmFile.add(jmiExit);
//    add(jmFile);
//
//    jmService.setText("Сервис");
//    jmiParameters.setText("Параметры");
//    jmService.add(jmiParameters);
//    add(jmService);
//
//    jmHelp.setText("Справка");
//    jmiAbout.setText("О'б");
//    jmHelp.add(jmiAbout);
//    add(jmHelp);
  }

}

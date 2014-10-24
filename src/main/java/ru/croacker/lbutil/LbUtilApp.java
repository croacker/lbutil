package ru.croacker.lbutil;

import lombok.extern.slf4j.Slf4j;
import ru.croacker.lbutil.nui.MainFrm;

import javax.swing.*;

/**
 * Created by user on 15.03.14.
 */
@Slf4j
public class LbUtilApp implements Runnable {

  JFrame frmMain;

  public void run() {
    initLookAndFeel();
    frmMain = ContextLoader.getInstance().getContext().getBean(MainFrm.class);
    frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMain.setVisible(true);
  }

  public static void main(String[] args) {
    loadContext();
    Runnable application = new LbUtilApp();
    application.run();
  }

  private static void loadContext() {
    ContextLoader.getInstance().load();
  }

  private void initLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void close() {
    System.exit(0);
  }
}

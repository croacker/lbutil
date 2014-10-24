package ru.croacker.lbutil.nui.component.common;

import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 */
@Component
public class UtilMenu extends JMenu{
  public UtilMenu(){}
  public UtilMenu(String text){
    super(text);
  }

}

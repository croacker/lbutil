package ru.croacker.lbutil.ui.create;

import ru.croacker.lbutil.ui.CreateChangelogFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 16.03.14.
 */
public class MainMenuBar extends JMenuBar {

    //TODO:to interface
    private CreateChangelogFrame parent;

    private JMenu jmFile;
    private JMenuItem jmiExit;

    private JMenu jmService;
    private JMenuItem jmiProperties;

    private JMenu jmHelp;
    private JMenuItem jmiAbout;

    public MainMenuBar(CreateChangelogFrame parent){
        this.parent = parent;
        initComponents();
    }

    private void initComponents() {
        jmFile = new JMenu("Файл");
        add(jmFile);
        jmiExit = new JMenuItem("Выход");
        jmiExit.addActionListener(getExitListener());
        jmFile.add(jmiExit);

        jmService = new JMenu("Сервис");
        add(jmService);
        jmiProperties = new JMenuItem("Параметры");
        jmService.add(jmiProperties);

        jmHelp = new JMenu("Справка");
        add(jmHelp);
        jmiAbout = new JMenuItem("О'б");
        jmHelp.add(jmiAbout);
    }

    private ActionListener getExitListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.closeApplication();
            }
        };
    }

}

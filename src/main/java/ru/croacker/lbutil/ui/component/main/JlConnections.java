package ru.croacker.lbutil.ui.component.main;

import ru.croacker.lbutil.LbUtilApp;
import ru.croacker.lbutil.ui.model.ConnectionUnitModel;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: a_gumenyuk
 * Date: 15.06.14
 * Time: 16:30
 * Список соединений
 */
public class JlConnections extends JList {

    private LbUtilApp app;

    public JlConnections(LbUtilApp app, ConnectionUnitModel connections){
        super(connections);
        this.app = app;
    }
}

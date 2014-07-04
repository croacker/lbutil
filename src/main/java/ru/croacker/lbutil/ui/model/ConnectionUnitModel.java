package ru.croacker.lbutil.ui.model;

import ru.croacker.lbutil.database.DbConnection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a_gumenyuk
 * Date: 15.06.14
 * Time: 16:27
 * Модель для отображения списка соединений
 */
public class ConnectionUnitModel extends AbstractListModel {

    private List<DbConnection> connections = new ArrayList<>();

    public List<DbConnection> getConnections() {
        return connections;
    }

    public void setConnections(List<DbConnection> connections) {
        this.connections = connections;
    }

    @Override
    public int getSize() {
        return getConnections().size();
    }

    @Override
    public Object getElementAt(int index) {
        return getConnections().get(index);
    }
}

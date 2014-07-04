package ru.croacker.lbutil.ui.connection;

import ru.croacker.lbutil.database.DbConnection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 04.07.14
 * Time: 23:05
 * Модель списка соединений
 */
public class ConnectionListModel extends AbstractListModel<DbConnection> {

    List<DbConnection> connections = new ArrayList<>();

    @Override
    public int getSize() {
        return connections.size();
    }

    public void add(DbConnection connection){
        connections.add(connection);
    }

    public void remove(DbConnection connection){
        connections.remove(connection);
    }

    @Override
    public DbConnection getElementAt(int i) {
        return connections.get(i);
    }

}

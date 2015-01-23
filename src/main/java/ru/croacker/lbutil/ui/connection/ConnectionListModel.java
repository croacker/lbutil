package ru.croacker.lbutil.ui.connection;

import ru.croacker.lbutil.database.DbConnectionDto;

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
public class ConnectionListModel extends AbstractListModel<DbConnectionDto> {

    List<DbConnectionDto> connections = new ArrayList<>();

    @Override
    public int getSize() {
        return connections.size();
    }

    public void add(DbConnectionDto connection){
        connections.add(connection);
    }

    public void remove(DbConnectionDto connection){
        connections.remove(connection);
    }

    @Override
    public DbConnectionDto getElementAt(int i) {
        return connections.get(i);
    }

}

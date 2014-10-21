package ru.croacker.lbutil.ui.model;

import ru.croacker.lbutil.database.DbConnection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель для отображения списка соединений
 */
public class ConnectionUnitModel<DbConnection> extends AbstractListModel<DbConnection> {

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
  public DbConnection getElementAt(int index) {
    return getConnections().get(index);
  }

  public void addConnection(DbConnection connection){
    getConnections().add(connection);
  }
}

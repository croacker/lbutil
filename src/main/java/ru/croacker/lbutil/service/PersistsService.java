package ru.croacker.lbutil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.croacker.lbutil.data.DbConnection;
import ru.croacker.lbutil.data.dao.DbConnectionDao;
import ru.croacker.lbutil.database.DbConnectionDto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class PersistsService {

  @Autowired
  private DbConnectionDao dbConnectionDao;

  public List<DbConnection> getAll(){
    return dbConnectionDao.findAll();
  }

  public void persists(DbConnectionDto connectionDto){
    DbConnection connection = new DbConnection();
    connection.setJdbcDriver(connectionDto.getJdbcDriver());
    connection.setUrl(connectionDto.getUrl());
    connection.setUser(connectionDto.getUser());
    connection.setPassword(connectionDto.getPassword());
    dbConnectionDao.persist(connection);
  }

}

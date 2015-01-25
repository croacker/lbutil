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

  public List<DbConnectionDto> getAll(){
    List<DbConnectionDto> connectionDtos = new ArrayList<>();
    for (DbConnection dbConnection: dbConnectionDao.findAll()){
      DbConnectionDto connectionDto = new DbConnectionDto();
      connectionDto.setId(dbConnection.getId());
      connectionDto.setName(dbConnection.getName() != null ? dbConnection.getName():dbConnection.getUrl());
      connectionDto.setJdbcDriver(dbConnection.getJdbcDriver());
      connectionDto.setUrl(dbConnection.getUrl());
      connectionDto.setUser(dbConnection.getUser());
      connectionDto.setPassword(dbConnection.getPassword());

      connectionDtos.add(connectionDto);
    }
    return connectionDtos;
  }

  public void persists(DbConnectionDto connectionDto){
    DbConnection dbConnection = dbConnectionDao.findById(connectionDto.getId());
    if(dbConnection == null){
      dbConnection = new DbConnection();
    }
    dbConnection.setName(connectionDto.getName());
    dbConnection.setJdbcDriver(connectionDto.getJdbcDriver());
    dbConnection.setUrl(connectionDto.getUrl());
    dbConnection.setUser(connectionDto.getUser());
    dbConnection.setPassword(connectionDto.getPassword());
    dbConnectionDao.persist(dbConnection);
  }

  public void remove(DbConnectionDto connectionDto){
    DbConnection dbConnection = dbConnectionDao.findById(connectionDto.getId());
    dbConnectionDao.remove(dbConnection);
  }

}

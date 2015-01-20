package ru.croacker.lbutil.service;

import org.springframework.stereotype.Service;
import ru.croacker.lbutil.database.DbConnection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class PersistsService {

  public List<DbConnection> getAll(){
    return new ArrayList<>();
  }

  public void persists(DbConnection connection){}

}

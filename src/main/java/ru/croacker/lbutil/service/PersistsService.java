package ru.croacker.lbutil.service;

import org.springframework.stereotype.Service;
import ru.croacker.lbutil.database.DbConnectionDto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class PersistsService {

  public List<DbConnectionDto> getAll(){
    return new ArrayList<>();
  }

  public void persists(DbConnectionDto connection){}

}

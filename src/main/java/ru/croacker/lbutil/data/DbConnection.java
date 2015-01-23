package ru.croacker.lbutil.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by user on 24.01.2015.
 */
@Entity
@Table(name="db_connection")
public class DbConnection {

  @Id
  @GeneratedValue
  private long id;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

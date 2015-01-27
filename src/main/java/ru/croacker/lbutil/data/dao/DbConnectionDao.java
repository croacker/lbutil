package ru.croacker.lbutil.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.croacker.lbutil.data.DbConnection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by user on 24.01.2015.
 */
@Repository
public class DbConnectionDao {

  @PersistenceContext
  EntityManager entityManager;

  public List<DbConnection> findAll() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<DbConnection> query = criteriaBuilder.createQuery(DbConnection.class);
    Root<DbConnection> root = query.from(DbConnection.class);
    query.select(root);
    return entityManager.createQuery(query).getResultList();
  }

  @Transactional
  public DbConnection persist(DbConnection dbConnection){
    return entityManager.merge(dbConnection);
  }

  public DbConnection findById(Long id) {
    return entityManager.find(DbConnection.class, id);
  }

  @Transactional
  public void remove(DbConnection dbConnection) {
    entityManager.remove(entityManager.contains(dbConnection) ? dbConnection : entityManager.merge(dbConnection));
  }
}

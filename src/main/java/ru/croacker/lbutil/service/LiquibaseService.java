package ru.croacker.lbutil.service;

import liquibase.database.Database;
import liquibase.diff.output.DiffOutputControl;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.integration.commandline.CommandLineUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.croacker.lbutil.database.DbConnection;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Сервис взаимодействия с liquibase
 */
@Service
@Slf4j
public class LiquibaseService {

  public String testConnection(DbConnection connection) {
    String resultMessage;
    try {
      getDatabase(connection);
      resultMessage = "Соединение успешно установлено!";
    } catch (DatabaseException e) {
      resultMessage = e.getMessage();
      log.error(e.getMessage(), e);
    }
    return resultMessage;
  }

  /**
   * Применить файл наборов изменений к существующей БД
   * @throws LiquibaseException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  public void writeChangelog(DbConnection connection, String changelogFile) throws LiquibaseException, IOException, ParserConfigurationException {
    CommandLineUtils.doGenerateChangeLog(changelogFile, getDatabase(connection), null, null,
        null, "samebadu", null, null, new DiffOutputControl());
  }

  /**
   * Сформировать файл наборов изменений на основании существующей БД
   * @throws LiquibaseException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  public void createChangelog(DbConnection connection, String changelogFile) throws LiquibaseException, IOException, ParserConfigurationException {
    CommandLineUtils.doGenerateChangeLog(changelogFile, getDatabase(connection), null, null,
        null, "samebadu", null, null, new DiffOutputControl());
  }

  private Database getDatabase(DbConnection connection) throws DatabaseException {
    return CommandLineUtils.createDatabaseObject(
        getClass().getClassLoader(),
        connection.getUrl(),
        connection.getUser(),
        connection.getPassword(),
        connection.getJdbcDriver(), null, null, false, false, null, null, null, null);
  }

}

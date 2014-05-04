package ru.croacker.lbutil.liquibase;

import liquibase.database.Database;
import liquibase.diff.output.DiffOutputControl;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.integration.commandline.CommandLineUtils;
import ru.croacker.lbutil.database.DbConnection;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by user on 15.03.14.
 */
public class LbRuner {

    private DbConnection dbConnection;

    public LbRuner(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Database getDatabase() throws DatabaseException {
        return CommandLineUtils.createDatabaseObject(
                getClass().getClassLoader(),
                dbConnection.getUrl(),
                dbConnection.getUser(),
                dbConnection.getPassword(),
                dbConnection.getJdbcDriver(), null, null, false, false, null, null, null, null);
    }

    public void writeChangelog() throws LiquibaseException, IOException, ParserConfigurationException {
        CommandLineUtils.doGenerateChangeLog(dbConnection.getChangelogFile(), getDatabase(), null, null,
               null, "samebadu", null, null, new DiffOutputControl());
    }
}

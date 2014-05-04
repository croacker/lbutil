package ru.croacker.lbutil.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by user on 16.03.14.
 * JDBC-drivers enum
 */
@AllArgsConstructor
public enum JdbcDriver {

    H2("org.h2.Driver"),
    POSTGRESQL("org.postgresql.Driver"),
    ORACLE("oracle.jdbc.OracleDriver"),
    DERBY_REMOTE("org.apache.derby.jdbc.ClientDriver"),
    DERBY_EMBEDDED("org.apache.derby.jdbc.EmbeddedDriver"),
    HSQL_REMOTE("org.hsql.jdbcDriver"),
    HSQL_EMBEDDED("org.hsql.jdbc.JDBCDriver"),
    MYSQL("com.mysql.jdbc.Driver"),
    MSSQL_JTDS("net.sourceforge.jtds.jdbc.Driver"),
    MSSQL_MS("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    SQLITE("org.sqlite.JDBC"),
    SYSBASE_NATIVE("com.sybase.jdbc4.jdbc.SybConnectionPoolDataSource")
    ;

    @Getter
    @Setter
    private String driverName;
}

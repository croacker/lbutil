package ru.croacker.lbutil.database;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: croacker
 * Date: 23.04.14
 * Time: 18:52
 * Соединение с БД
 */
public class DbConnection {

    @Getter
    private String jdbcDriver;
    @Getter
    private String url;
    @Getter
    private String user;
    @Getter
    private String password;
//    @Getter
//    private String changelogFile;//TODO: Убрать

    public DbConnection setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
        return this;
    }

    public DbConnection setUrl(String url) {
        this.url = url;
        return this;
    }

    public DbConnection setUser(String user) {
        this.user = user;
        return this;
    }

    public DbConnection setPassword(String password) {
        this.password = password;
        return this;
    }

//    public DbConnection setChangelogFile(String changelogFile) {
//        this.changelogFile = changelogFile;
//        return this;
//    }
}

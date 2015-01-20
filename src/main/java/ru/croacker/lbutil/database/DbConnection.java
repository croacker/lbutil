package ru.croacker.lbutil.database;

import lombok.Getter;

/**
 * Соединение с БД
 */
public class DbConnection {

    @Getter
    private Long id;
    @Getter
    private String jdbcDriver;
    @Getter
    private String url;
    @Getter
    private String user;
    @Getter
    private String password;

    public DbConnection setId(Long id){
        this.id = id;
        return this;
    }

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

}

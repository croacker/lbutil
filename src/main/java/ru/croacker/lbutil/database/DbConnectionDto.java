package ru.croacker.lbutil.database;

import lombok.Getter;

/**
 * Соединение с БД
 */
public class DbConnectionDto {

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

    public DbConnectionDto setId(Long id){
        this.id = id;
        return this;
    }

    public DbConnectionDto setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
        return this;
    }

    public DbConnectionDto setUrl(String url) {
        this.url = url;
        return this;
    }

    public DbConnectionDto setUser(String user) {
        this.user = user;
        return this;
    }

    public DbConnectionDto setPassword(String password) {
        this.password = password;
        return this;
    }

}

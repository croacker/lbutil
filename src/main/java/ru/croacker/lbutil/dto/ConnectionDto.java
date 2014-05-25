package ru.croacker.lbutil.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 04.05.14
 * Time: 23:06
 * Данные о соединении которое будет сохраняться
 */
public class ConnectionDto {

    @Getter @Setter
    private String jdbcDriver;
    @Getter @Setter
    private String url;
    @Getter @Setter
    private String user;
    @Getter @Setter
    private String password;

}

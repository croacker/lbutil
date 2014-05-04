package ru.croacker.lbutil.ui;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import ru.croacker.lbutil.LbUtilApp;
import ru.croacker.lbutil.database.DbConnection;
import ru.croacker.lbutil.liquibase.LbRuner;
import ru.croacker.lbutil.ui.create.ChangelogFilePanel;
import ru.croacker.lbutil.ui.create.DbConnectionPanel;
import ru.croacker.lbutil.ui.create.MainMenuBar;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by user on 15.03.14.
 * Окноу экс'порта наборов изменений в файл
 */
@Slf4j
public class CreateChangelogFrame extends JFrame {

    private LbUtilApp app;

    private DbConnectionPanel dbConnectionPanel;
    private ChangelogFilePanel changelogFilePanel;

    public CreateChangelogFrame(LbUtilApp app) {
        this.app = app;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Экспорт набора изменений Liquibase");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(new MainMenuBar(this));

        dbConnectionPanel = new DbConnectionPanel();
        dbConnectionPanel.getJbTestConnection().addActionListener(getClickTestConnectionListener());
        changelogFilePanel = new ChangelogFilePanel();
        changelogFilePanel.getJbExport().addActionListener(getClickExportListener());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dbConnectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changelogFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(dbConnectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changelogFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private ActionListener getClickExportListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportChangelog();
            }
        };
    }

    private ActionListener getClickTestConnectionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testConnection();
            }
        };
    }

    /**
     * Проверка условий
     */
    private boolean checkPreconditions() {
        String errorText = StringUtils.EMPTY;
        if (StringUtils.isEmpty(dbConnectionPanel.getJdbcDriverName())) {
            errorText = "Ошибка: Не указан Jdbc-драйвер";
        } else if (StringUtils.isEmpty(dbConnectionPanel.getUrl())) {
            errorText = "Ошибка: Не указан URL подключения к БД";
        } else if (StringUtils.isEmpty(changelogFilePanel.getChangelogFile())) {
            errorText = "Ошибка: Не указан файл";
        }

        dbConnectionPanel.setErrorText(errorText);

        if (!StringUtils.isEmpty(errorText)) {
            log.error(errorText);
        }

        return StringUtils.isEmpty(errorText);
    }

    /**
     * Выгрузить в файл
     * TODO:снизить уровень уебищности
     */
    private void exportChangelog() {
        if (checkPreconditions()) {
            Locale.setDefault(Locale.ENGLISH);
            LbRuner lbRuner = new LbRuner(getConnection());

            String resultMessage;
            try {
                lbRuner.writeChangelog();
                resultMessage = "Экспорт набора изменений завершен!";
            } catch (LiquibaseException e1) {
                resultMessage = e1.getMessage();
                log.error(e1.getMessage(), e1);
            } catch (IOException e1) {
                resultMessage = e1.getMessage();
                log.error(e1.getMessage(), e1);
            } catch (ParserConfigurationException e1) {
                resultMessage = e1.getMessage();
                log.error(e1.getMessage(), e1);
            }
            JOptionPane.showMessageDialog(null,
                    resultMessage);
        }
    }

    /**
     * Проверить соединение
     * TODO:снизить уровень уебищности
     */
    private void testConnection(){
        LbRuner lbRuner = new LbRuner(getConnection());
        String resultMessage;
        try {
            lbRuner.getDatabase();
            resultMessage = "Соединение успешно установлено!";
        } catch (DatabaseException e) {
            resultMessage = e.getMessage();
            log.error(e.getMessage(), e);
        }
        JOptionPane.showMessageDialog(null,
                resultMessage);
    }

    private DbConnection getConnection(){
        return new DbConnection()
                .setJdbcDriver(dbConnectionPanel.getJdbcDriverName())
                .setUrl(dbConnectionPanel.getUrl())
                .setUser(dbConnectionPanel.getUser())
                .setPassword(dbConnectionPanel.getPassword())
                .setChangelogFile(changelogFilePanel.getChangelogFile());
    }

    public void closeApplication() {
        int confirm = JOptionPane.showOptionDialog(this,
                "Закрыть приложение?",
                "Экспорт набора изменений Liquibase", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (confirm == JOptionPane.YES_OPTION) {
            app.close();
        }
    }
}

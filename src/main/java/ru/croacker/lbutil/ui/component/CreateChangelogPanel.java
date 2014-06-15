package ru.croacker.lbutil.ui.component;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23.04.14
 * Time: 0:57
 *
 */
public class CreateChangelogPanel extends JPanel{

    private DbConnectionPanel dbConnectionPanel;
    private ChangelogFilePanel changelogFilePanel;

    private void initComponents() {
        dbConnectionPanel = new DbConnectionPanel();
        changelogFilePanel = new ChangelogFilePanel();

//        changelogFilePanel.getJbExport().addActionListener(getClickExportListener());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
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
    }

}

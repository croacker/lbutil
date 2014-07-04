package ru.croacker.lbutil.ui.component;

import lombok.Getter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 15.03.14.
 * Местонахождение файла в который будет записан liquibase changelog
 */
public class ChangelogFilePanel extends JPanel {

    private javax.swing.JLabel jlChangelogFile;
    private javax.swing.JTextField jtfChangelogFile;
    private javax.swing.JButton jbChooseFile;
    @Getter private javax.swing.JButton jbExport;

    public String getChangelogFile(){
        return jtfChangelogFile.getText();
    }

    public ChangelogFilePanel(){
        initComponents();
    }

    private void initComponents() {
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlChangelogFile = new JLabel();
        jlChangelogFile.setText("Файл:");

        jtfChangelogFile = new JTextField();

        jbExport = new JButton();
        jbExport.setText("Экспорт");

        jbChooseFile = new JButton();
        jbChooseFile.setText("...");
        jbChooseFile.addActionListener(getChoosefileActionListener());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlChangelogFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jtfChangelogFile, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExport)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlChangelogFile)
                                        .addComponent(jtfChangelogFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbChooseFile)
                                        .addComponent(jbExport))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    private ActionListener getChoosefileActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        };
    }

    //TODO:to individual component
    private void chooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Укажите файл для сохранения набора изменений");
        fileChooser.setFileFilter(new FileNameExtensionFilter("XML(*.xml)", "xml"));
        int rVal = fileChooser.showSaveDialog(getParent());
        if (rVal == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath()
                    + (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".xml") ? "" : ".xml");
            jtfChangelogFile.setText(fileName);
        }
    }

}

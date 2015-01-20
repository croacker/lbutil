package ru.croacker.lbutil.nui.component.exp;

import org.springframework.stereotype.Component;
import ru.croacker.lbutil.nui.component.SelectFileButton;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
@Component
public class ExportChangelogPanel extends JPanel {

  private GroupLayout jpExportLayout;

  private JLabel jlExportFile;
  private JTextField jtfExportFile;
  private JButton jbSelectExportFile;
  private JButton jbExport;

  public ExportChangelogPanel(){
  }

  @PostConstruct
  private void initComponents() {
    setBorder(javax.swing.BorderFactory.createEtchedBorder());
    setToolTipText("Экспорт");

    jlExportFile = new JLabel("Файл:");
    jtfExportFile = new JTextField();
    jbSelectExportFile = getSelectFile(jtfExportFile);
    jbExport = new JButton("Экспорт");

    jpExportLayout = new javax.swing.GroupLayout(this);
    setLayout(jpExportLayout);

    jpExportLayout.setHorizontalGroup(
        jpExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlExportFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfExportFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSelectExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
    );

    jpExportLayout.setVerticalGroup(
        jpExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlExportFile)
                    .addComponent(jtfExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelectExportFile)
                    .addComponent(jbExport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }

  private JButton getSelectFile(JTextComponent filenameVisualizer){
    return new SelectFileButton(filenameVisualizer);
  }

}

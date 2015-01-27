package ru.croacker.lbutil.nui.component.connection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.croacker.lbutil.database.DbConnectionDto;
import ru.croacker.lbutil.nui.component.ConnectionsPopupMenu;
import ru.croacker.lbutil.service.PersistsService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 */
@Component
public class ConnectionsListPanel extends JPanel {

    public ConnectionsList jlConnections;

    private JScrollPane jspConnections;

    @Autowired
    private ConnectionsPopupMenu cpmConnections;

    @Autowired
    @Getter
    @Setter
    private PersistsService persistService;

    public ConnectionsListPanel() {
    }

    @PostConstruct
    private void initComponents() {
        cpmConnections.setInvoker(this);

        jlConnections = new ConnectionsList();
        jlConnections.setComponentPopupMenu(cpmConnections);

        jspConnections = new JScrollPane(jlConnections);
        jspConnections.setPreferredSize(new Dimension(100, 100));

        javax.swing.GroupLayout jpConnectionsListLayout = new javax.swing.GroupLayout(this);
        setLayout(jpConnectionsListLayout);
        jpConnectionsListLayout.setHorizontalGroup(
                jpConnectionsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpConnectionsListLayout.createSequentialGroup()
                                .addComponent(jspConnections, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
        );
        jpConnectionsListLayout.setVerticalGroup(
                jpConnectionsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jspConnections)
        );
    }

    /**
     * @return
     */
    public DbConnectionDto getSelected() {
        return jlConnections.getSelectedValue();
    }

    public void setConections(final List<DbConnectionDto> connectionDtos) {
        ((DefaultListModel) jlConnections.getModel()).removeAllElements();
        if (SwingUtilities.isEventDispatchThread()) {
            addConnections(connectionDtos);
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    addConnections(connectionDtos);
                }
            });
        }
        if (jlConnections.getModel().getSize() != 0) {
            jlConnections.setSelectionInterval(0, 0);
        }
    }

    private void addConnections(List<DbConnectionDto> connectionDtos) {
        for (DbConnectionDto connectionDto : connectionDtos) {
            ((DefaultListModel) jlConnections.getModel()).addElement(connectionDto);
        }
    }

    public int getConnectionsCount() {
        return jlConnections.getModel().getSize();
    }

    public void addListSelectionListener(ListSelectionListener listener) {
        jlConnections.addListSelectionListener(listener);
    }

    public void addNewConnectionMenuListener(ActionListener listener) {
        cpmConnections.getJmiNewConnection().addActionListener(listener);
    }

    public void addRemoveConnectionMenuListener(ActionListener listener) {
        cpmConnections.getJmiRemoveConnection().addActionListener(listener);
    }
}

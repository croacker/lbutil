package ru.croacker.lbutil.nui.component.toolbar;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 *
 */
@Component
public class AddConnectionButton extends JButton {

    public AddConnectionButton() {
    }

    @PostConstruct
    private void initComponents() {
        setToolTipText("Добавить");
        setFocusable(false);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setIcon(getImage());
    }

    private ImageIcon getImage() {
        return new ImageIcon(getClass().getResource("btnAdd.ico"));
//        return new ImageIcon("src/main/resources/img/btnAdd.ico");
    }

}

package ru.croacker.lbutil;

import lombok.extern.slf4j.Slf4j;
import ru.croacker.lbutil.service.PreferenceService;
import ru.croacker.lbutil.ui.CreateChangelogFrame;
import ru.croacker.lbutil.ui.MainFrame;

import javax.swing.*;

/**
 * Created by user on 15.03.14.
 */
@Slf4j
public class LbUtilApp implements Runnable {

    JFrame frmMain;

    public void run() {
        initLookAndFeel();
        frmMain = new MainFrame(this);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setVisible(true);
    }

    public static void main( String[] args )
    {
        Runnable application = new LbUtilApp();
        application.run();
        PreferenceService.getInstance().getConnectionsNames();
    }

    private void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (InstantiationException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedLookAndFeelException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void close(){
        System.exit(0);
    }
}

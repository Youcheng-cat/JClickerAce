/*
 * Created by JFormDesigner on Mon Aug 19 17:51:18 CST 2024
 */

package com.youcheng.app.view;

import java.awt.*;
import java.util.TimerTask;
import javax.swing.*;
import com.formdev.flatlaf.extras.*;
import net.miginfocom.swing.*;

/**
 * @author Youcheng_cat
 */
public class Hud extends JDialog {
    private Timer timer;


    public void hiddenHud() {
        timer.start();
    }

    public void hiddenHud(int ms) {
        java.util.Timer wait = new java.util.Timer();
        wait.schedule(new TimerTask() {
            @Override
            public void run() {
                hiddenHud();
                wait.cancel();
            }
        }, ms);
    }

    public void setText(String s) {
        SwingUtilities.invokeLater(() -> {
            label1.setText(s);
            pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation((screenSize.width - this.getWidth()) / 2, 0);
        });
    }

    public void postHud(String string) {
        setText(string);
        timer.stop();
        setOpacity(1);
    }

    public Hud() {
        super();
        setAlwaysOnTop(true);
        setUndecorated(true);
        setOpacity(0);
        initComponents();
        initTimer();
        setVisible(true);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - this.getWidth()) / 2, 0);
    }

    private void initTimer() {
        timer = new Timer(5, e -> {
            double o = getOpacity();
            o -= 0.05;
            if (o < 0) {
                setOpacity(0);
                timer.stop();
            }else {
                setOpacity((float) o);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3,align center center",
            // columns
            "[fill]",
            // rows
            "[]"));

        //---- label1 ----
        label1.setText("JClickerAce    \u5df2\u7981\u7528");
        contentPane.add(label1, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Mon Aug 19 17:51:18 CST 2024
 */

package com.youcheng.app.view;

import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.extras.*;
import net.miginfocom.swing.*;

/**
 * @author Youcheng_cat
 */
public class Hud extends JDialog {
    private static double easeOutExpo(double t) {
        return (t == 1 ? 1 : 1 - Math.pow(2, -10 * t));
    }

    public Hud() {
        setUndecorated(true);
        initComponents();
        setVisible(true);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - this.getWidth()) / 2, 0);
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
        label1.setText("\u6587\u672c    Text123");
        contentPane.add(label1, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

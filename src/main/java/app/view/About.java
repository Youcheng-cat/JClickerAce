/*
 * Created by JFormDesigner on Sun Aug 25 18:30:24 CST 2024
 */

package com.youcheng.app.view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

/**
 * @author Lisa
 */
public class About extends JDialog {
    private About about;

    public About(Window window) {
        super(window);
        setModal(true);
        initComponents();
        setSize(410, 270);
        setLocationRelativeTo(window);
        setVisible(true);
    }

    private void ok(ActionEvent e) {
        this.dispose();
    }

    private void editorPane1HyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                Desktop.getDesktop().browse(new URL(e.getURL().toString()).toURI());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        editorPane1 = new JEditorPane();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle("\u5173\u4e8e");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "fill,insets dialog,hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]"));

                //---- editorPane1 ----
                editorPane1.setEditable(false);
                editorPane1.setContentType("text/html");
                editorPane1.setText("<html>\n<body>\n<h1>JClickerAce</h1>\nJClickerAce\u662f\u4e00\u4e2a\u5f00\u6e90\u7684\u9f20\u6807\u952e\u76d8\u8fde\u70b9\u5668\uff0c\u4f5c\u800514\u5c81\u5c0f\u5347\u521d\u4e00\u679a~<br>\n\u672c\u9879\u76ee\u4f7f\u7528Java\u7f16\u5199\uff0c\u5df2\u4f7f\u7528MIT\u8bb8\u53ef\u8bc1\u5f00\u6e90\uff0c\u6b22\u8fce\u63d0\u51fa\u5b9d\u8d35\u6539\u8fdb\u7684\u610f\u89c1\uff01\n<p>\nGitHub\uff1a<a href='https://github.com/Youcheng-cat/JClickerAce'>https://github.com/Youcheng-cat/JClickerAce</a><br>\n\u4f5c\u8005B\u7ad9\u4e3b\u9875\uff1a<a href='https://space.bilibili.com/1727948844'>@\u67da\u6a59\u732b</a>\n</p>\n<footer>\nCopyright (c) 2024 Youcheng-cat\n</footer>\n</body>\n</html>");
                editorPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                editorPane1.addHyperlinkListener(e -> editorPane1HyperlinkUpdate(e));
                contentPanel.add(editorPane1, "cell 0 0,dock center");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[button,fill]",
                    // rows
                    null));

                //---- okButton ----
                okButton.setText("\u786e\u8ba4");
                okButton.setBackground(UIManager.getColor("Button.default.background"));
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, "cell 0 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JEditorPane editorPane1;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

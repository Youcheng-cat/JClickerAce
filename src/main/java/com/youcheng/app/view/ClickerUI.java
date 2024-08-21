/*
 * Created by JFormDesigner on Mon Aug 12 18:10:13 CST 2024
 */

package com.youcheng.app.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.*;

/**
 * @author Youcheng_cat
 */
@SuppressWarnings("all")
public class ClickerUI extends JFrame {
    //点击速率设置方法
    public void setClickSpeedListener(DocumentListener listener) {
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) clickSpeed.getEditor();
        JFormattedTextField textField = editor.getTextField();
        textField.getDocument().addDocumentListener(listener);
    }

    public int getClickSpeed() {
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) clickSpeed.getEditor();
        JFormattedTextField textField = editor.getTextField();
        if (textField.getText().equals("1,000")) {
            return 1000;
        }
        return Integer.parseInt(textField.getText());
    }

    public void setClickSpeed(int speed) {
        clickSpeed.setValue(speed);
    }

    //点击设置单位监听器
    public void setRadioButton2Listener(ActionListener listener) {
        radioButton2.addActionListener(listener);
    }

    public void setRadioButton1Listener(ActionListener listener) {
        radioButton1.addActionListener(listener);
    }

    public void setRadioButton1SetSelected(boolean selected) {
        radioButton1.setSelected(selected);
    }

    public void setRadioButton2SetSelected(boolean selected) {
        radioButton2.setSelected(selected);
    }

    //点击模式
    public void setModeComboBoxActionListener(ActionListener listener) {
        comboBox1.addActionListener(listener);
    }
    public int getModeComboBoxModel() {
        if (Objects.equals(comboBox1.getSelectedItem(), "切换")) {
            return 1;
        }else {
            return 2;
        }
    }
    public void setModeComboBoxModel(int mode) {
        comboBox1.setSelectedItem(mode == 1 ? "切换" : "按住");
    }

    //主题切换
    public void setLafComboBoxActionListener(ActionListener listener) {
        lafComboBox.addActionListener(listener);
    }

    public int getLafComboBoxModel() {
        if (Objects.equals(lafComboBox.getSelectedItem(), "深色主题")) {
            FlatLaf.setup(new FlatMacDarkLaf());
            FlatLaf.updateUI();
            return 1;
        } else {
            FlatLaf.setup(new FlatMacLightLaf());
            FlatLaf.updateUI();
            return 2;
        }
    }

    public void setLafComboBoxModel(int laf) {
        lafComboBox.setSelectedItem(laf == 1 ? "深色主题" : "亮色主题");
    }

    //是否在应用内启用
    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public JCheckBox getCheckBox2() {
        return checkBox2;
    }

    //选键按钮
    public JToggleButton getDisableKeyButton() {
        return disableKeyButton;
    }

    public JToggleButton getHotKeyButton() {
        return hotKeyButton;
    }

    public JToggleButton getKeyButton() {
        return keyButton;
    }

    public ClickerUI() {
        initComponents();
        NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(1);
        numberFormatter.setMaximum(1000);
        numberFormatter.setAllowsInvalid(false);

        JSpinner.NumberEditor defaultEditor = new JSpinner.NumberEditor(clickSpeed);
        defaultEditor.getTextField().setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
        defaultEditor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        clickSpeed.setEditor(defaultEditor);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        optionsMenu = new JMenu();
        tabbedPane4 = new JTabbedPane();
        panel1 = new JPanel();
        label2 = new JLabel();
        keyButton = new JToggleButton();
        speedLabel = new JLabel();
        clickSpeed = new JSpinner();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        hotKeyButton = new JToggleButton();
        panel2 = new JPanel();
        label5 = new JLabel();
        checkBox1 = new JCheckBox();
        label6 = new JLabel();
        lafComboBox = new JComboBox<>();
        label7 = new JLabel();
        disableKeyButton = new JToggleButton();
        label8 = new JLabel();
        checkBox2 = new JCheckBox();
        label9 = new JLabel();
        radioButton2 = new JRadioButton();
        radioButton1 = new JRadioButton();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        setTitle("JClickerAce");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== optionsMenu ========
            {
                optionsMenu.setText("\u5e2e\u52a9");
            }
            menuBar1.add(optionsMenu);
        }
        setJMenuBar(menuBar1);

        //======== tabbedPane4 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label2 ----
                label2.setText("\u8fde\u70b9\u6309\u952e:");
                panel1.add(label2, "cell 0 0");

                //---- keyButton ----
                keyButton.setText("\u5de6\u952e");
                panel1.add(keyButton, "cell 1 0");

                //---- speedLabel ----
                speedLabel.setText("\u70b9\u51fb\u901f\u5ea6(CPS):");
                panel1.add(speedLabel, "cell 0 1");

                //---- clickSpeed ----
                clickSpeed.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
                panel1.add(clickSpeed, "");

                //---- label3 ----
                label3.setText("\u70b9\u51fb\u6a21\u5f0f:");
                panel1.add(label3, "cell 0 2");

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u5207\u6362",
                    "\u6309\u4f4f"
                }));
                panel1.add(comboBox1, "cell 1 2");

                //---- label4 ----
                label4.setText("\u5f00\u542f/\u505c\u6b62\u952e:");
                panel1.add(label4, "cell 0 3");

                //---- hotKeyButton ----
                hotKeyButton.setText("F1");
                panel1.add(hotKeyButton, "cell 1 3");
            }
            tabbedPane4.addTab("\u8fde\u70b9\u529f\u80fd", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label5 ----
                label5.setText("\u8fde\u70b9\u5668\u5185\u5173\u95ed\u8fde\u70b9:");
                panel2.add(label5, "cell 0 0");

                //---- checkBox1 ----
                checkBox1.setEnabled(false);
                panel2.add(checkBox1, "cell 1 0,alignx right,growx 0");

                //---- label6 ----
                label6.setText("\u4e3b\u9898\u660e\u6697:");
                panel2.add(label6, "cell 0 1");

                //---- lafComboBox ----
                lafComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u6df1\u8272\u4e3b\u9898",
                    "\u4eae\u8272\u4e3b\u9898"
                }));
                panel2.add(lafComboBox, "cell 1 1");

                //---- label7 ----
                label7.setText("\u7981\u7528\u8fde\u70b9\u5668\u6309\u952e:");
                panel2.add(label7, "cell 0 2");

                //---- disableKeyButton ----
                disableKeyButton.setText("F8");
                disableKeyButton.setEnabled(false);
                panel2.add(disableKeyButton, "cell 1 2");

                //---- label8 ----
                label8.setText("\u663e\u793aHUD\u63d0\u793a:");
                panel2.add(label8, "cell 0 3");

                //---- checkBox2 ----
                checkBox2.setEnabled(false);
                panel2.add(checkBox2, "cell 1 3,alignx right,growx 0");

                //---- label9 ----
                label9.setText("\u70b9\u51fb\u901f\u5ea6\u5355\u4f4d:");
                panel2.add(label9, "cell 0 4");

                //---- radioButton2 ----
                radioButton2.setText("CPS/s");
                radioButton2.setSelected(true);
                panel2.add(radioButton2, "cell 1 4");

                //---- radioButton1 ----
                radioButton1.setText("\u95f4\u9694/ms");
                panel2.add(radioButton1, "cell 2 4");
            }
            tabbedPane4.addTab("\u8bbe\u7f6e", panel2);
        }
        contentPane.add(tabbedPane4, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- 点击速度 ----
        var 点击速度 = new ButtonGroup();
        点击速度.add(radioButton2);
        点击速度.add(radioButton1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu optionsMenu;
    private JTabbedPane tabbedPane4;
    private JPanel panel1;
    private JLabel label2;
    private JToggleButton keyButton;
    private JLabel speedLabel;
    private JSpinner clickSpeed;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JToggleButton hotKeyButton;
    private JPanel panel2;
    private JLabel label5;
    private JCheckBox checkBox1;
    private JLabel label6;
    private JComboBox<String> lafComboBox;
    private JLabel label7;
    private JToggleButton disableKeyButton;
    private JLabel label8;
    private JCheckBox checkBox2;
    private JLabel label9;
    private JRadioButton radioButton2;
    private JRadioButton radioButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

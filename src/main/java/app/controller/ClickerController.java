package com.youcheng.app.controller;

import com.youcheng.app.model.ClickerModel;
import com.youcheng.app.view.ClickerUI;
import com.youcheng.app.view.Hud;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class ClickerController {
    private ClickerModel model;
    private ClickerUI view;
    private Hud hud;

    public ClickerController(ClickerModel model, ClickerUI view, Hud hud) {
        this.model = model;
        this.view = view;
        this.hud = hud;

        // 初始化视图
        initView();

        // 设置监听器
        setListeners();
    }

    private void post(String s) {
        if (model.isEnableHud()) {
            hud.postHud(s);
        }
    }

    private void initView() {
        view.setLafComboBoxModel(model.getLaf());
        view.setModeComboBoxModel(model.getClickerMode());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(400, 250);
        view.setLocationRelativeTo(null);
        view.getCheckBox1().setSelected(!model.isEnableOnApp());
        view.getHudTip().setSelected(model.isEnableHud());
        view.setVisible(true);
        if (model.isUseCPS()) {
            view.setSpeedLabelText("点击速度(CPS):");
            view.setRadioButton2SetSelected(true);
            view.setClickSpeed(model.getClickSpeed());
        } else {
            view.setSpeedLabelText("点击间隔(ms):");
            view.setRadioButton1SetSelected(true);
            view.setClickSpeed(model.getClickInterval());
        }
    }

    private void setListeners() {
        view.setLafComboBoxActionListener(e -> {
            model.setLaf(view.getLafComboBoxModel());
        });

        view.setClickSpeedListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (model.isUseCPS()) {
                    model.setClickSpeed(view.getClickSpeed());
                } else {
                    model.setClickInterval(view.getClickSpeed());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        view.setRadioButton2Listener(e -> {
            model.setUseCPS(true);
            view.setSpeedLabelText("点击速度(CPS):");
            view.setClickSpeed(model.getClickSpeed());
        });
        view.setRadioButton1Listener(e -> {
            model.setUseCPS(false);
            view.setSpeedLabelText("点击间隔(ms):");
            view.setClickSpeed(model.getClickInterval());
        });

        view.setModeComboBoxActionListener(e -> {
            model.setClickerMode(view.getModeComboBoxModel());
        });

        view.getCheckBox1().addActionListener(e -> {
            model.setEnableOnApp(!view.getCheckBox1().isSelected());
        });
        view.getHudTip().addActionListener(e -> {
            model.setEnableHud(view.getHudTip().isSelected());
        });
        view.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                if (!model.isEnableOnApp()) {
                    post("JClickerAce    已禁用");
                    model.setEnableClick(false);
                    hud.hiddenHud(500);
                }
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                if (!model.isEnableOnApp()) {
                    post("JClickerAce    已启用");
                    model.setEnableClick(true);
                    hud.hiddenHud(500);
                }
            }
        });
    }
}

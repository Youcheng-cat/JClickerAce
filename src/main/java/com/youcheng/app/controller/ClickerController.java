package com.youcheng.app.controller;

import com.youcheng.app.model.ClickerModel;
import com.youcheng.app.view.ClickerUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ClickerController {
    private ClickerModel model;
    private ClickerUI view;

    public ClickerController(ClickerModel model, ClickerUI view) {
        this.model = model;
        this.view = view;

        //视图初始化
        view.setLafComboBoxModel(model.getLaf());
        view.setModeComboBoxModel(model.getClickerMode());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(400, 250);
        view.setLocationRelativeTo(null);
        view.getCheckBox1().setSelected(!model.isEnableOnApp());
        view.getCheckBox2().setSelected(model.isEnableHud());
        view.setVisible(true);
        if (model.isUseCPS()) {
            view.setRadioButton2SetSelected(true);
            view.setClickSpeed(model.getClickSpeed());
        } else {
            view.setRadioButton1SetSelected(true);
            view.setClickSpeed(model.getClickInterval());
        }

        //设置监听器
        //-主题设置器
        view.setLafComboBoxActionListener(e -> {
            model.setLaf(view.getLafComboBoxModel());
        });

        //-点击速度
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

        //-点击速度单位
        view.setRadioButton2Listener(e -> {
            model.setUseCPS(true);
            view.setClickSpeed(model.getClickSpeed());
        });
        view.setRadioButton1Listener(e -> {
            model.setUseCPS(false);
            view.setClickSpeed(model.getClickInterval());
        });

        //-点击模式
        view.setModeComboBoxActionListener(e -> {
            model.setClickerMode(view.getModeComboBoxModel());
        });

        //-是否应用内开启
        view.getCheckBox1().addActionListener(e -> {
            model.setEnableOnApp(!view.getCheckBox1().isSelected());
        });
        //-是否显示HUD
        view.getCheckBox2().addActionListener(e -> {
            model.setEnableHud(view.getCheckBox2().isSelected());
        });
    }
}

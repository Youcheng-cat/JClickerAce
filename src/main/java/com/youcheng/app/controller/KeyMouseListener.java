package com.youcheng.app.controller;

import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;
import com.youcheng.app.model.ClickerModel;
import com.youcheng.app.model.KeyConfig;
import com.youcheng.app.view.ClickerUI;

import javax.swing.*;
import java.util.Timer;


public class KeyMouseListener implements NativeKeyListener, NativeMouseListener {
    private final ClickerModel model;
    private final ClickerUI view;

    public KeyMouseListener(ClickerModel model, ClickerUI view) {
        this.model = model;
        this.view = view;

        //设置监听器
        view.getKeyButton().addActionListener(e -> {
            view.getKeyButton().setText("...");
            model.setSetKey(true);
        });
        view.getHotKeyButton().addActionListener(e -> {
            view.getHotKeyButton().setText("...");
            model.setSetKey(true);
        });
        view.getDisableKeyButton().addActionListener(e -> {
            view.getDisableKeyButton().setText("...");
            model.setSetKey(true);
        });

        //初始化界面中的文字
        view.getKeyButton().setText(model.getTargetButton().toString());
        view.getHotKeyButton().setText(model.getHotKey().toString());
        view.getDisableKeyButton().setText(model.getDisableKey().toString());
    }

    //键盘
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        //键盘按下
        //设置按键
        if (model.isSetKey()) {
            JToggleButton button;
            KeyConfig config;
            if (view.getKeyButton().isSelected()) {
                button = view.getKeyButton();
                config = model.getTargetButton();
            } else if (view.getHotKeyButton().isSelected()) {
                button = view.getHotKeyButton();
                config = model.getHotKey();
            } else if (view.getDisableKeyButton().isSelected()) {
                button = view.getDisableKeyButton();
                config = model.getDisableKey();
            } else return;
            config.upDataFromKey(e);
            model.setSetKey(false);
            button.setText(config.toString());
            button.setSelected(false);
            return;
        }
        if (e.getRawCode() == model.getHotKey().getButton()) {
            if (model.getClickerMode() == 1) {
                if (model.isClicking() && !model.isKeyPreessed()) {
                    model.stopClick();
                } else if (!model.isKeyPreessed()){
                    model.startClick();
                }
            } else if (model.getClickerMode() == 2) {
                model.startClick();
            }
        }
        model.setKeyPreessed(true);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        //键盘释放
        model.setKeyPreessed(false);
        if (e.getRawCode() == model.getHotKey().getButton()) {
            if (model.getClickerMode() == 2) {
                model.stopClick();
            }
        }
    }

    //鼠标
    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        //鼠标按下
        //设置按键
        if (model.isSetKey()) {
            JToggleButton button;
            KeyConfig config;
            if (view.getKeyButton().isSelected()) {
                button = view.getKeyButton();
                config = model.getTargetButton();
            } else if (view.getHotKeyButton().isSelected()) {
                button = view.getHotKeyButton();
                config = model.getHotKey();
            } else if (view.getDisableKeyButton().isSelected()) {
                button = view.getDisableKeyButton();
                config = model.getDisableKey();
            } else return;
            config.upDataFromMouse(e);
            button.setText(config.toString());
            model.setSetKey(false);
            button.setSelected(false);
            return;
        }
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeEvent) {
        //鼠标释放
    }
}

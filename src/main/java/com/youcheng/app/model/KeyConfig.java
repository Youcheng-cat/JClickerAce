package com.youcheng.app.model;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.youcheng.app.util.ConfigManager;

import java.awt.event.InputEvent;

public class KeyConfig {
    private int code;
    private String type;
    private int rawCode;
    private String name;

    public KeyConfig(String string) {
        code = ClickerModel.getIntConfig(string + ".var");
        type = ConfigManager.getConfig(string + ".type");
        rawCode = ClickerModel.getIntConfig(string + ".rawCode");
        name = string;
    }

    public int getButton() {
        if (type.equals("mouse")) {
            int i = 1;
            if (code == 2) {
                i = 3;
            } else if (code == 3) {
                i = 2;
            }
            return InputEvent.getMaskForButton(i);
        } else {
            return rawCode;
        }
    }

    public String getType() {
        return type;
    }

    private void setCode(int code) {
        this.code = code;
        ConfigManager.setConfig(name + ".var", String.valueOf(code));
    }

    private void setType(String type) {
        this.type = type;
        ConfigManager.setConfig(name + ".type", type);
    }

    private void setRawCode(int rawCode) {
        this.rawCode = rawCode;
        ConfigManager.setConfig(name + ".rawCode", String.valueOf(rawCode));
    }

    @Override
    public String toString() {
        if (type.equals("mouse")) {
            if (code == 1) {
                return "左键";
            } else if (code == 2) {
                return "右键";
            } else if (code == 3) {
                return "中键";
            } else return "鼠标侧键" + (code - 3);
        }
        return NativeKeyEvent.getKeyText(code);
    }

    public void upDataFromKey(NativeKeyEvent e) {
        setCode(e.getKeyCode());
        setType("keyboard");
        setRawCode(e.getRawCode());
    }

    public void upDataFromMouse(NativeMouseEvent e) {
        setCode(e.getButton());
        setType("mouse");
    }
}

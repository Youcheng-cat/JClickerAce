package com.youcheng.app.model;


import com.youcheng.app.util.ConfigManager;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClickerModel {
    private boolean isEnableOnApp;
    private boolean isEnableHud;
    //点击速度
    private int clickInterval;
    private boolean enableClick;
    private int clickSpeed;
    private boolean useCPS;
    //按键Code
    private KeyConfig targetButton;
    private KeyConfig hotKey;
    private KeyConfig disableKey;

    private int clickerMode;
    private int laf;

    //运行时数据
    private boolean isSetKey = false;
    private Thread clicker;
    private volatile boolean isClicking = false;
    private boolean isKeyPreessed = false;

    public ClickerModel() {
        initConfigs();
        initClickerThread();
    }

    private void initConfigs() {
        isEnableOnApp = Boolean.parseBoolean(ConfigManager.getConfig("isEnableOnApp"));
        isEnableHud = Boolean.parseBoolean(ConfigManager.getConfig("isEnableHud"));
        enableClick = Boolean.parseBoolean(ConfigManager.getConfig("enableClick"));
        clickInterval = getIntConfig("clickInterval");
        clickSpeed = getIntConfig("clickSpeed");
        useCPS = Boolean.parseBoolean(ConfigManager.getConfig("useCPS"));
        clickerMode = getIntConfig("clickerMode");
        laf = getIntConfig("laf");

        targetButton = new KeyConfig("targetButton");
        hotKey = new KeyConfig("hotKey");
        disableKey = new KeyConfig("disableKey");
    }

    private void initClickerThread() {
        clicker = new Thread(() -> {
            try {
                Robot robot = new Robot();
                while (true) {
                    if (isClicking) {
                        if (targetButton.getType().equals("mouse")) {
                            robot.mousePress(targetButton.getButton());
                            robot.mouseRelease(targetButton.getButton());
                        } else {
                            robot.keyPress(targetButton.getButton());
                            robot.keyRelease(targetButton.getButton());
                        }
                        robot.delay(getClickInterval());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        clicker.start();
    }

    public boolean isKeyPreessed() {
        return isKeyPreessed;
    }

    public void setKeyPreessed(boolean keyPreessed) {
        isKeyPreessed = keyPreessed;
    }

    public boolean isEnableClick() {
        return enableClick;
    }

    public void setEnableClick(boolean enableClick) {
        if (!enableClick) {
            stopClick();
        }
        this.enableClick = enableClick;
        ConfigManager.setConfig("enableClick", String.valueOf(enableClick));
    }

    public void startClick() {
        setClicking(true);
    }

    public void stopClick() {
        setClicking(false);
    }

    public boolean isClicking() {
        return isClicking;
    }

    public void setClicking(boolean clicking) {
        isClicking = clicking;
    }

    //获取配置为int
    public static int getIntConfig(String key) {
        return Integer.parseInt(ConfigManager.getConfig(key));
    }


    public int getLaf() {
        return laf;
    }

    public void setLaf(int laf) {
        this.laf = laf;
        ConfigManager.setConfig("laf", String.valueOf(laf));
    }

    public int getClickInterval() {
        if (isUseCPS()) {
            return 1000 / clickSpeed;
        }
        return clickInterval;
    }

    public void setClickInterval(int clickInterval) {
        this.clickInterval = clickInterval;
        ConfigManager.setConfig("clickInterval", String.valueOf(clickInterval));
    }

    public void setClickSpeed(int clickSpeed) {
        this.clickSpeed = clickSpeed;
        ConfigManager.setConfig("clickSpeed", String.valueOf(clickSpeed));
    }

    public int getClickSpeed() {
        return clickSpeed;
    }

    public boolean isUseCPS() {
        return useCPS;
    }

    public void setUseCPS(boolean useCPS) {
        this.useCPS = useCPS;
        ConfigManager.setConfig("useCPS", String.valueOf(useCPS));
    }

    public int getClickerMode() {
        return clickerMode;
    }

    public void setClickerMode(int clickerMode) {
        this.clickerMode = clickerMode;
        ConfigManager.setConfig("clickerMode", String.valueOf(clickerMode));
    }

    public boolean isEnableOnApp() {
        return isEnableOnApp;
    }

    public void setEnableOnApp(boolean enableOnApp) {
        this.isEnableOnApp = enableOnApp;
        ConfigManager.setConfig("isEnableOnApp", String.valueOf(enableOnApp));
    }

    public boolean isEnableHud() {
        return isEnableHud;
    }

    public void setEnableHud(boolean enableHud) {
        this.isEnableHud = enableHud;
        ConfigManager.setConfig("isEnableHud", String.valueOf(enableHud));
    }

    public KeyConfig getDisableKey() {
        return disableKey;
    }

    public KeyConfig getHotKey() {
        return hotKey;
    }

    public KeyConfig getTargetButton() {
        return targetButton;
    }

    public boolean isSetKey() {
        return isSetKey;
    }

    public void setSetKey(boolean setKey) {
        isSetKey = setKey;
    }
}
package com.youcheng.app;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.youcheng.app.controller.ClickerController;
import com.youcheng.app.controller.KeyMouseListener;
import com.youcheng.app.model.ClickerModel;
import com.youcheng.app.view.ClickerUI;
import com.youcheng.app.view.Hud;


public class ClickerApp {
    public static void main(String[] args) {
        ClickerModel model = new ClickerModel();
        if (model.getLaf() == 1) {
            FlatMacDarkLaf.setup();
        } else {
            FlatMacLightLaf.setup();
        }
        ClickerUI view = new ClickerUI();
        KeyMouseListener keyMouseListener = new KeyMouseListener(model, view);

        ClickerController controller = new ClickerController(model, view);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }
        GlobalScreen.addNativeKeyListener(keyMouseListener);
        GlobalScreen.addNativeMouseListener(keyMouseListener);
        //Hud hud = new Hud();
    }
}

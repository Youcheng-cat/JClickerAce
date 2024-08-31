package com.youcheng.app.util;

import java.io.*;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Properties props = new Properties();
    private static final String USER_PATH = "config";

    static {
        loadConfig();
    }

    private static void loadConfig() {
        //配置文件
        File configFile = new File(USER_PATH, CONFIG_FILE_NAME);

        File configDir = new File(USER_PATH);
        if (!configDir.exists()) {
            configDir.mkdirs();
        }

        if (!configFile.exists()) {
            copyResourceToFileSys("config/" + CONFIG_FILE_NAME, configFile);
        }

        //尝试加载配置文件
        try (FileInputStream fis = new FileInputStream(configFile)) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyResourceToFileSys(String resourcePath, File file) {
        try (InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(resourcePath);
             OutputStream os = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getConfig(String key) {
        return props.getProperty(key);
    }

    public static void setConfig(String key, String value) {
        props.setProperty(key, value);
        saveConfig();
    }

    public static void saveConfig() {
        File file = new File(USER_PATH, CONFIG_FILE_NAME);

        //保存
        try (FileOutputStream fos = new FileOutputStream(file)) {
            props.store(fos, "");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

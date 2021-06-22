package com.digishop.common.bundle;

import java.util.ResourceBundle;

public class PersianResourceBundle {

    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("bundle");
    }
    public static String showTranslation(String key) {
        return getBundle().getString(key);
    }
}

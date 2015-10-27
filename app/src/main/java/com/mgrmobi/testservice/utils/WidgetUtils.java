package com.mgrmobi.testservice.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class WidgetUtils {

    private WidgetUtils(){

    }

    public static String getStringFromView(final CharSequence text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        return String.valueOf(text);
    }
}

package com.mgrmobi.testservice.data.bean.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.mgrmobi.testservice.data.bean.PreferenceBean;

import java.util.Date;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class PreferenceBeanImpl implements PreferenceBean {

    private final static String PREFS_STRING = "com.mgrmobi.testservice.PREFS";
    private final static String PREFS_LAST_NOTIFY_TIME = "PREFS_LAST_NOTIFY_TIME";

    private final SharedPreferences preferences;
    private final Context context;

    public PreferenceBeanImpl(final Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFS_STRING, Context.MODE_PRIVATE);
    }

    @Override
    public void setLastModifyTime(@NonNull Date date) {
        preferences.edit()
                .putLong(PREFS_LAST_NOTIFY_TIME, date.getTime())
                .apply();
    }

    @Override
    public Date getLastModifyTime() {
        final Long milles = preferences.getLong(PREFS_LAST_NOTIFY_TIME, 0L);
        if (0L == milles) {
            return null;
        }
        return new Date(milles);
    }
}

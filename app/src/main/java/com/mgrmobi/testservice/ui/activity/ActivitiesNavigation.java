package com.mgrmobi.testservice.ui.activity;

import android.content.Context;
import android.content.Intent;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class ActivitiesNavigation {

    private ActivitiesNavigation() {

    }

    public static void startActivityRegister(final Context context) {
        final  Intent intent = new Intent(context, ActivityRegister.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

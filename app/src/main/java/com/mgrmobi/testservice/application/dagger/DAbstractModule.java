package com.mgrmobi.testservice.application.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class DAbstractModule {

    @NonNull
    private final Context context;

    protected DAbstractModule(final Context context) {
        this.context = context;
    }

    @NonNull
    public Context getContext() {
        return context;
    }


}

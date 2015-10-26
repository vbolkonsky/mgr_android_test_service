package com.mgrmobi.testservice.application.dagger;

import android.content.Context;

import dagger.Module;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
@Module
public  class DDataModule extends DAbstractModule {

    public DDataModule(Context context) {
        super(context);
    }
}

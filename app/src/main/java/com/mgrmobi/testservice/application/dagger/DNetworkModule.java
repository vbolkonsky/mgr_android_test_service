package com.mgrmobi.testservice.application.dagger;

import android.content.Context;

import dagger.Module;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
@Module
public class DNetworkModule extends DAbstractModule {

     public DNetworkModule(Context context) {
        super(context);
    }
}

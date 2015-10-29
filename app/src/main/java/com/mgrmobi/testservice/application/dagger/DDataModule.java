package com.mgrmobi.testservice.application.dagger;

import android.content.Context;

import com.mgrmobi.testservice.data.bean.PreferenceBean;
import com.mgrmobi.testservice.data.bean.impl.PreferenceBeanImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
@Module
public class DDataModule extends DAbstractModule {

    public DDataModule(Context context) {
        super(context);
    }

    @Provides
    @Singleton
    public PreferenceBean providePreference() {
        return new PreferenceBeanImpl(getContext());
    }
}

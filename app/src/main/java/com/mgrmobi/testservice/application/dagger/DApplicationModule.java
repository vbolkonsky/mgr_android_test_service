package com.mgrmobi.testservice.application.dagger;

import android.app.Application;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.application.TestServiceApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
@Module
public class DApplicationModule extends DAbstractModule {

    public DApplicationModule(final TestServiceApplication application) {
        super(application);
    }

    @Provides
    @Singleton
    public TestServiceApplication provideTestServiceApplication() {
        return (TestServiceApplication) getContext();
    }

    @Provides
    public Application provideApplication(TestServiceApplication application) {
        return (Application) getContext();
    }

    @Provides
    public String provideApplicationName(){
        return  getContext().getString(R.string.app_name);
    }
}

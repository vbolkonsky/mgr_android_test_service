package com.mgrmobi.testservice.application;

import android.app.Application;
import android.content.Context;

import com.mgrmobi.testservice.application.dagger.DApplicationComponent;
import com.mgrmobi.testservice.application.dagger.DApplicationModule;
import com.mgrmobi.testservice.application.dagger.DDataModule;
import com.mgrmobi.testservice.application.dagger.DNetworkModule;
import com.mgrmobi.testservice.application.dagger.DaggerDApplicationComponent;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class TestServiceApplication extends Application {

    private DApplicationComponent component;

    @Inject
    protected String applicationName;

    public static TestServiceApplication get(final Context context) {
        return (TestServiceApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
    }

    public DApplicationComponent getComponent() {
        return component;
    }

    public String getApplicationName() {
        return applicationName;
    }

    /**
     * creation and initialization Dagger's modules
     */
    private void buildGraphAndInject() {
        component = DaggerDApplicationComponent.builder()
                .dApplicationModule(new DApplicationModule(this))
                .dDataModule(new DDataModule(this))
                .dNetworkModule(new DNetworkModule(this))
                .build();
        component.inject(this);
    }

    public void setComponent(final DApplicationComponent component) {
        this.component = component;
        this.component.inject(this);
    }
}

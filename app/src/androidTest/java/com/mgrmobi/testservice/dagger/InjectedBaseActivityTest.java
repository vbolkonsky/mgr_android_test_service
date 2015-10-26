package com.mgrmobi.testservice.dagger;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.mgrmobi.testservice.application.TestServiceApplication;
import com.mgrmobi.testservice.application.dagger.DApplicationComponent;
import com.mgrmobi.testservice.application.dagger.DApplicationModule;
import com.mgrmobi.testservice.application.dagger.DDataModule;
import com.mgrmobi.testservice.application.dagger.DNetworkModule;
import com.mgrmobi.testservice.application.dagger.DaggerDApplicationComponent;

import org.mockito.Mockito;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class InjectedBaseActivityTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {


    protected TestServiceApplication application;

    public InjectedBaseActivityTest(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty(
                "dexmaker.dexcache",
                getInstrumentation().getTargetContext().getCacheDir().getPath());
        application = (TestServiceApplication)getInstrumentation()
                .getTargetContext()
                .getApplicationContext();
        DApplicationModule applicationModule = Mockito.spy(new DApplicationModule(application));
        Mockito.doReturn("test application").when(applicationModule).provideApplicationName();
        DApplicationComponent component = DaggerDApplicationComponent.builder()
                .dApplicationModule(applicationModule)
                .dNetworkModule(new DNetworkModule(application))
                .dDataModule(new DDataModule(application))
                .build();
        application.setComponent(component);
    }
}

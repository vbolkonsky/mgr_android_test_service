package com.mgrmobi.testservice.application.dagger;

import com.mgrmobi.testservice.application.TestServiceApplication;
import com.mgrmobi.testservice.presentation.DaggerPresentationView;
import com.mgrmobi.testservice.service.TestServiceImpl;
import com.mgrmobi.testservice.ui.activity.base.DaggerActivity;
import com.mgrmobi.testservice.ui.adapter.AdapterProducts;
import com.mgrmobi.testservice.ui.fragment.base.DaggerFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
@Singleton
@Component(
        modules = {DApplicationModule.class, DNetworkModule.class, DDataModule.class}
)
public interface DApplicationComponent {

    void inject(TestServiceApplication application);

    void inject(DaggerFragment f);

    void inject(DaggerActivity a);

    void inject(AdapterProducts adapter);

    void inject(DaggerPresentationView p);

    void inject(TestServiceImpl s);

}

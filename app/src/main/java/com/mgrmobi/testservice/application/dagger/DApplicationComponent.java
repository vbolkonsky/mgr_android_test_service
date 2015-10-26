package com.mgrmobi.testservice.application.dagger;

import com.mgrmobi.testservice.application.TestServiceApplication;

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
}
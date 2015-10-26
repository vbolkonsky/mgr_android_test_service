package com.mgrmobi.testservice.ui.activity.base;

import android.os.Bundle;

import com.mgrmobi.testservice.application.TestServiceApplication;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class DaggerActivity extends BaseActivity {

    @Inject
    protected TestServiceApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestServiceApplication.get(this).getComponent().inject(this);
    }
}

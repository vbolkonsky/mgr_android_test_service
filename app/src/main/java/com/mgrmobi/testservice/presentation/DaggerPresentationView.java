package com.mgrmobi.testservice.presentation;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mgrmobi.testservice.application.TestServiceApplication;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class DaggerPresentationView {

    @Inject
    protected Context application;

    public DaggerPresentationView(@NonNull final Context context) {
        TestServiceApplication.get(context).getComponent().inject(this);
    }
}

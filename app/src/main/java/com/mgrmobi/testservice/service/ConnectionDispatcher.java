package com.mgrmobi.testservice.service;

import android.app.Service;

/**
 * @author Valentin Bolkonsky.
 * Callback for service bind.
 */
public interface ConnectionDispatcher<S extends Service> {

    void onBind(final S service);

    void onUnbind();
}

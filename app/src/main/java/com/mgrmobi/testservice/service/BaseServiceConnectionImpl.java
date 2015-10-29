package com.mgrmobi.testservice.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * @author Valentin Bolkonsky.
 */
public class BaseServiceConnectionImpl<S extends Service> implements ServiceConnection {

    private final ConnectionDispatcher<S> dispatcher;

    public BaseServiceConnectionImpl(final ConnectionDispatcher<S> connectionDispatcher) {
        this.dispatcher = connectionDispatcher;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        if (binder instanceof BaseBinder) {
            S service = ((BaseBinder<S>) binder).getService();
            if (dispatcher != null)
                dispatcher.onBind(service);
        }
    }

    @Override
    public void onServiceDisconnected(final ComponentName name) {
        if(dispatcher != null) {
            dispatcher.onUnbind();
        }
    }
}

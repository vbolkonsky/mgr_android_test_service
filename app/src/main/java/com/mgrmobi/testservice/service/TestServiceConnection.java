package com.mgrmobi.testservice.service;

import android.content.ComponentName;
import android.os.IBinder;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public final class TestServiceConnection extends BaseServiceConnectionImpl<TestServiceImpl> {

    private boolean isBound;

    public TestServiceConnection(ConnectionDispatcher<TestServiceImpl> connectionDispatcher) {
        super(connectionDispatcher);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        super.onServiceConnected(name, binder);
        isBound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        super.onServiceDisconnected(name);
        isBound = false;
    }

    public boolean isBound() {
        return isBound;
    }
}

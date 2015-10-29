package com.mgrmobi.testservice.service;

import android.os.IBinder;

/**
 * @author Valentin Bolkonsky.
 */
public interface BaseBinder<S> extends IBinder{

    S getService();
}

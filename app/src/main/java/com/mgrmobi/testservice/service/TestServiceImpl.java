package com.mgrmobi.testservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mgrmobi.testservice.application.TestServiceApplication;
import com.mgrmobi.testservice.data.bean.PreferenceBean;
import com.mgrmobi.testservice.ui.activity.ActivitiesNavigation;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Subscription;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class TestServiceImpl extends Service implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    private final IBinder binder = new BinderImpl();

    @Inject
    protected PreferenceBean preferenceBean;

    //Timer
    private Subscription subscription;

    private final class BinderImpl extends Binder implements BaseBinder<TestService> {
        @Override
        public TestService getService() {
            return TestServiceImpl.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TestServiceApplication.get(this).getComponent().inject(this);
    }

    @Override
    public void setPurchaseDateTime(final Date dateTime) {
        preferenceBean.setLastModifyTime(dateTime);
    }

    @Override
    public void subscribeToTimer() {
        if(subscription != null && !subscription.isUnsubscribed()){
            return;
        }
        subscription = rx.Observable.timer(0, 1000, TimeUnit.MILLISECONDS)
                .subscribe(this::checkTime);
    }

    @Override
    public void unsubscribeFromTimer() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unsubscribeFromTimer();
    }

    private void checkTime(long mills) {
        final Date modifyDate = preferenceBean.getLastModifyTime();
        if (modifyDate == null) {
            return;
        }
        final DateTime currentDate = new DateTime(new Date());
        final DateTime lastModifyTime = new DateTime(modifyDate.getTime());
        Months months = Months.monthsBetween(lastModifyTime, currentDate);
        logger.debug("month: " + months.getMonths());
        if (months.getMonths() >= 1) {
            ActivitiesNavigation.startActivityRegister(this);
            unsubscribeFromTimer();
        }
    }
}

package com.mgrmobi.testservice.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.service.ConnectionDispatcher;
import com.mgrmobi.testservice.service.TestService;
import com.mgrmobi.testservice.service.TestServiceConnection;
import com.mgrmobi.testservice.service.TestServiceImpl;
import com.mgrmobi.testservice.ui.fragment.FragmentRegister;
import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class BaseActivity extends AppCompatActivity implements CommonActivity,
        ConnectionDispatcher<TestServiceImpl>, CommonServiceActivity<TestService> {

    protected final Logger logger;

    @LayoutRes
    protected abstract int getResourceLayout();

    @Bind(R.id.fragment_content)
    protected ViewGroup containerFragments;

    protected BaseFragment currentFragment;

    protected TestService service;

    private TestServiceConnection serviceConnection;

    public BaseActivity() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public TestService getService() {
        return service;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());
        ButterKnife.bind(this);
        bindService(new Intent(this, TestServiceImpl.class),
                serviceConnection = new TestServiceConnection(this), BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        //if need destroy service, pls uncomment that
        if (serviceConnection.isBound()) {
            unbindService(serviceConnection);
        }
    }

    @Override
    public void onBind(TestServiceImpl service) {
        this.service = service;

    }

    @Override
    public void onUnbind() {
        this.service = null;
    }

    protected final void replaceFragment(final BaseFragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(containerFragments.getId(), fragment, FragmentRegister.class.getCanonicalName())
                .commit();
        runOnUiThread(() -> {
            getFragmentManager().executePendingTransactions();
            currentFragment = fragment;
        });
    }
}

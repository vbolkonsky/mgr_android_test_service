package com.mgrmobi.testservice.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.mgrmobi.testservice.R;
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
public abstract class BaseActivity extends AppCompatActivity implements CommonActivity {

    protected final Logger logger;

    @LayoutRes
    protected abstract int getResourceLayout();

    @Bind(R.id.fragment_content)
    protected ViewGroup containerFragments;

    public BaseActivity() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected final void replaceFragment(final BaseFragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(containerFragments.getId(), fragment, FragmentRegister.class.getCanonicalName())
                .commit();

    }
}

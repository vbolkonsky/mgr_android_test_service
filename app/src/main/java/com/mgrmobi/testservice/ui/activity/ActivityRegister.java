package com.mgrmobi.testservice.ui.activity;

import android.os.Bundle;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.ui.activity.base.BaseActivity;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.fragment.FragmentsNavigation;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class ActivityRegister extends BaseActivity implements ContainerRegister {

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(FragmentsNavigation.makeFragment(FragmentsNavigation.FragmentCode.FRAGMENT_REGISTER, null));
    }
}

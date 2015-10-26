package com.mgrmobi.testservice.ui.fragment;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class FragmentRegister extends BaseFragment<ContainerRegister> {

    public static FragmentRegister makeFragment() {
        final FragmentRegister fragment = new FragmentRegister();
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_register;
    }
}

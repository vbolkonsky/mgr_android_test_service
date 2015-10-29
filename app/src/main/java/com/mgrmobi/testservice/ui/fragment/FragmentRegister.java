package com.mgrmobi.testservice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.presentation.PresentationRegisterView;
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getView() != null) {
            presentationView = new PresentationRegisterView(getView());
        }

    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void apply() {
        logger.debug("apply pressed");
        if (presentationView.validation()) {
            presentationView.apply();
            activity.getService().setPurchaseDateTime(((PresentationRegisterView) presentationView).getModel().getPurchase());
        }
    }
}

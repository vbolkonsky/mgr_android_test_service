package com.mgrmobi.testservice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.presentation.PresentationRegisterView;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

import butterknife.Bind;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class FragmentRegister extends BaseFragment<ContainerRegister> {

    @Bind(R.id.main_container)
    protected View viewContainer;

    private PresentationRegisterView presentationRegisterView;

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
        presentationRegisterView = new PresentationRegisterView(viewContainer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presentationRegisterView != null) {
            presentationRegisterView.destroy();
        }
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void apply() {
        logger.debug("apply pressed");
        if(presentationRegisterView.validation()){
            presentationRegisterView.apply();
        }
    }
}

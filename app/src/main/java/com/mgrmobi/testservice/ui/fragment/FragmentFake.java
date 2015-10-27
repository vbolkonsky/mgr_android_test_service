package com.mgrmobi.testservice.ui.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.presentation.PresentationFakeView;
import com.mgrmobi.testservice.ui.activity.base.ContainerFake;
import com.mgrmobi.testservice.ui.dialog.DialogRegister;
import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

import butterknife.OnClick;

/**
 * Fake fragment. Using only for test.
 *
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class FragmentFake extends BaseFragment<ContainerFake> {

    private static final String FRAGMENT_ARG_MESSAGE = "fragment.FRAGMENT_ARG_MESSAGE";

    public static FragmentFake makeFragment(final String messageTest) {
        final FragmentFake fragmentFake = new FragmentFake();
        final Bundle args = new Bundle();
        args.putString(FRAGMENT_ARG_MESSAGE, messageTest);
        fragmentFake.setArguments(args);
        return fragmentFake;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presentationView = new PresentationFakeView(viewContainer, getArguments().getString(FRAGMENT_ARG_MESSAGE));
    }

    @OnClick(R.id.btn_show_registration)
    protected void onShowDialog() {
        logger.debug("onShowDialog");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("DialogRegister");
        if(prev != null){
            ft.remove(prev);
        }
        DialogRegister dialogRegister = new DialogRegister();
        dialogRegister.show(ft, "DialogRegister");
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_fake;
    }

    @Override
    public void apply() {
        logger.debug("apply pressed");
    }
}

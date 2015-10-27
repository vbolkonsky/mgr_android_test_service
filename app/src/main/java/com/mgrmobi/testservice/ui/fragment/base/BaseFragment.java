package com.mgrmobi.testservice.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.presentation.PresentationView;
import com.mgrmobi.testservice.ui.activity.base.CommonActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class BaseFragment<A extends CommonActivity> extends DaggerFragment implements CommonFragment<A> {

    @NonNull
    protected A activity;

    @LayoutRes
    protected abstract int getResourceLayout();

    @Bind(R.id.main_container)
    protected View viewContainer;

    protected PresentationView presentationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getResourceLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (A) getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presentationView != null) {
            presentationView.destroy();
            presentationView = null;
        }
        ButterKnife.unbind(this);
    }

}

package com.mgrmobi.testservice.ui.fragment.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.mgrmobi.testservice.application.TestServiceApplication;
import com.mgrmobi.testservice.data.bean.PreferenceBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class DaggerFragment extends Fragment {

    protected final Logger logger;

    @Inject
    protected Context application;

    @Inject
    protected LayoutInflater inflater;

    @Inject
    protected PreferenceBean preferenceBean;

    public DaggerFragment() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TestServiceApplication.get(getActivity()).getComponent().inject(this);
    }
}

package com.mgrmobi.testservice.ui.fragment.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mgrmobi.testservice.application.TestServiceApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class DaggerFragment extends Fragment{

    protected final Logger logger;

    @Inject
    protected TestServiceApplication application;

    public DaggerFragment(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TestServiceApplication.get(getActivity()).getComponent().inject(this);
    }
}

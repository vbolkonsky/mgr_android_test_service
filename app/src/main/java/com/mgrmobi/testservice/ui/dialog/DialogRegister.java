package com.mgrmobi.testservice.ui.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.presentation.PresentationRegisterView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class DialogRegister extends DialogFragment {

    private static final Logger logger = LoggerFactory.getLogger(DialogRegister.class);

    private PresentationRegisterView presentationRegisterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(R.style.Material_App_Dialog_Simple, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_registration, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presentationRegisterView = new PresentationRegisterView(view.findViewById(R.id.main_container));
    }

    @OnClick(R.id.btn_register)
    protected void onRegister() {
        if (presentationRegisterView.validation()) {
            presentationRegisterView.apply();
            logger.debug("register model: " + presentationRegisterView.getModel());
            dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presentationRegisterView != null) {
            presentationRegisterView.destroy();
            presentationRegisterView = null;
        }
        ButterKnife.unbind(this);
    }
}

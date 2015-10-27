package com.mgrmobi.testservice.presentation;

import android.support.annotation.NonNull;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class PresentationFakeView extends AbstractPresentationView<Void> {

    @Bind(R.id.txt_message)
    protected TextView txtMessage;

    public PresentationFakeView(@NonNull View view, final String message) {
        super(view);
        txtMessage.setText(message);
    }

    @Override
    public void apply() {
        logger.debug("not used here");
    }

    @OnClick(R.id.btn_show_registration)
    protected void onShowDialog() {
        logger.debug("onShowDialog");
    }

    @Override
    public boolean validation() {
        //not used here
        return false;
    }
}

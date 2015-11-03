package com.mgrmobi.testservice.presentation;

import android.support.annotation.NonNull;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.rey.material.widget.TextView;

import butterknife.Bind;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class PresentationFakeView extends AbstractPresentationView<Void> {

    @Bind(R.id.txt_message)
    protected TextView txtMessage;

    public PresentationFakeView(@NonNull View view) {
        super(view);
    }

    @Override
    public void apply() {
        logger.debug("not used here");
    }

    public void setMessage(final String message) {
        txtMessage.setText(message);
    }

    @Override
    public boolean validation() {
        //not used here
        return false;
    }
}

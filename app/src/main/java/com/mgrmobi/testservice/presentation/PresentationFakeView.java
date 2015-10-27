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

    public PresentationFakeView(@NonNull View view, final String message) {
        super(view);
        txtMessage.setText(message);
    }

    @Override
    public void apply() {
        logger.debug("not used here");
    }

    @Override
    public boolean validation() {
        //not used here
        return false;
    }
}

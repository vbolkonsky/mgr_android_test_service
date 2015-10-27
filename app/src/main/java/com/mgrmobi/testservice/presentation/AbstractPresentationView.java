package com.mgrmobi.testservice.presentation;

import android.support.annotation.NonNull;
import android.view.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import butterknife.ButterKnife;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public abstract class AbstractPresentationView<T> extends DaggerPresentationView {

    protected final Logger logger;
    protected T model;
    protected View contentView;

    public AbstractPresentationView(@NonNull View view) {
        super(view.getContext());
        this.contentView = view;
        logger = LoggerFactory.getLogger(this.getClass());
        ButterKnife.bind(this, view);
    }

    @Override
    public void destroy() {
        ButterKnife.unbind(this);
    }

    public T getModel() {
        return model;
    }

    @Override
    public void clear() {
        model = null;
    }

    public View getContentView() {
        return contentView;
    }
}

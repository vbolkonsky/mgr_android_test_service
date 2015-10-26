package com.mgrmobi.testservice.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.common.collect.Lists;
import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.application.TestServiceApplication;
import com.mgrmobi.testservice.data.model.ProductModel;
import com.rey.material.widget.TextView;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class AdapterProducts extends BaseAdapter {

    @Inject
    protected LayoutInflater inflater;

    private List<ProductModel> models;

    public AdapterProducts(final Context context) {
        models = Lists.newArrayList();
        TestServiceApplication.get(context).getComponent().inject(this);
    }

    @Override
    public int getCount() {
        return models != null ? models.size() : 0;
    }

    @Override
    public ProductModel getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_item_product, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.txt_display)).setText(getItem(position).getDisplay());
        return convertView;
    }

    public void addAll(final List<ProductModel> models) {
        this.models.addAll(models);
        notifyDataSetChanged();
    }
}

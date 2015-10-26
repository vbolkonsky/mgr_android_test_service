package com.mgrmobi.testservice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.data.model.ProductModel;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.adapter.AdapterProducts;
import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;
import com.rey.material.widget.Spinner;

import butterknife.Bind;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class FragmentRegister extends BaseFragment<ContainerRegister> {

    @Bind(R.id.spinner_products)
    protected Spinner spinnerProducts;

    public static FragmentRegister makeFragment() {
        final FragmentRegister fragment = new FragmentRegister();
        return fragment;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdapterProducts adapterProducts = new AdapterProducts(getActivity());
        spinnerProducts.setAdapter(adapterProducts);
        adapterProducts.addAll(ProductModel.generateModels(getActivity()));
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_register;
    }


}

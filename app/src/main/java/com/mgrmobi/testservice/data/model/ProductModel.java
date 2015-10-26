package com.mgrmobi.testservice.data.model;

import android.content.Context;

import com.google.common.collect.Lists;
import com.mgrmobi.testservice.R;

import java.util.List;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class ProductModel {

    private String display;
    private long id;
    private ProductType type;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", type=" + type +
                ", display=" + display +
                "}";
    }

    public static List<ProductModel> generateModels(final Context context) {
        final String[] displayProducts = context.getResources().getStringArray(R.array.products);
        List<ProductModel> models = Lists.newArrayList();
        int i = 0;
        for (ProductType type : ProductType.values()) {
            final ProductModel model = new ProductModel();
            model.setDisplay(displayProducts[i]);
            model.setId(i);
            model.setType(type);
            models.add(model);
            i++;
        }
        return models;
    }
}

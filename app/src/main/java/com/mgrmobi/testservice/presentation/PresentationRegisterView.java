package com.mgrmobi.testservice.presentation;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.data.model.ProductModel;
import com.mgrmobi.testservice.data.model.RegistrationModel;
import com.mgrmobi.testservice.ui.adapter.AdapterProducts;
import com.mgrmobi.testservice.utils.DateUtils;
import com.mgrmobi.testservice.utils.MiscUtils;
import com.mgrmobi.testservice.utils.WidgetUtils;
import com.rey.material.widget.EditText;
import com.rey.material.widget.Spinner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class PresentationRegisterView extends AbstractPresentationView<RegistrationModel> {

    private static final Logger logger = LoggerFactory.getLogger(PresentationRegisterView.class);

    @Bind(R.id.txt_serial)
    protected EditText txtSerial;
    @Bind(R.id.spinner_products)
    protected Spinner spinnerProducts;
    @Bind(R.id.txt_name)
    protected EditText txtName;
    @Bind(R.id.txt_email)
    protected EditText txtEmail;
    @Bind(R.id.txt_address)
    protected EditText txtAddress;
    @Bind(R.id.txt_contact)
    protected EditText txtContact;
    @Bind(R.id.txt_purchase)
    protected com.rey.material.widget.TextView txtPurchase;

    public PresentationRegisterView(final View view) {
        super(view);
        fillControls();
    }

    @Override
    public boolean validation() {
        final CharSequence name = txtName.getText();
        if (StringUtils.isBlank(name)) {
            txtName.setError(application.getString(R.string.error_name_required));
            return false;
        }
        final CharSequence email = txtEmail.getText();
        if (StringUtils.isBlank(email) ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.setError(application.getString(R.string.error_email_required));
            return false;
        }
        return true;
    }

    @Override
    public void apply() {
        clear();
        model = new RegistrationModel();
        model.setName(WidgetUtils.getStringFromView(txtName.getText()));
        model.setMail(WidgetUtils.getStringFromView(txtEmail.getText()));
        model.setAddress(WidgetUtils.getStringFromView(txtAddress.getText()));
        model.setContact(WidgetUtils.getStringFromView(txtContact.getText()));
        model.setProductModel((ProductModel) spinnerProducts.getSelectedItem());
        model.setPurchase(DateUtils.getDateFromString(application, WidgetUtils.getStringFromView(txtPurchase.getText()), R.string.date_template_simple));
        logger.debug("apply model: " + model);
    }

    @OnFocusChange({R.id.txt_name, R.id.txt_email})
    protected void onFocusChange(final View v, boolean hasFocus) {
        if (hasFocus) {
            ((EditText) v.getParent()).setError(null);
        }
    }

    @OnEditorAction({R.id.textfield_name_et_label_input, R.id.textfield_email_et_label_input})
    protected boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_NEXT || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            final EditText txtField = (EditText) v.getParent();
            switch (txtField.getId()) {
                case R.id.txt_name:
                    final CharSequence name = txtName.getText();
                    if (StringUtils.isBlank(name)) {
                        txtName.setError(application.getString(R.string.error_name_required));
                    }
                    break;
                case R.id.txt_email:
                    final CharSequence email = txtEmail.getText();
                    if (StringUtils.isBlank(email) ||
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        txtEmail.setError(application.getString(R.string.error_email_required));
                    }
                    break;
            }
        }
        return false;
    }

    @OnClick(R.id.txt_purchase)
    protected void onClickPurchase() {
        logger.debug("onClickPurchase");
    }

    private void fillControls() {
        final AdapterProducts adapterProducts = new AdapterProducts(application.getApplicationContext());
        spinnerProducts.setAdapter(adapterProducts);
        adapterProducts.addAll(ProductModel.generateModels(application));
        txtSerial.setText(MiscUtils.getHardwareId());
        txtPurchase.setText(DateUtils.getStringFromDate(application, new Date(), R.string.date_template_simple));
    }

}

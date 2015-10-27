package com.mgrmobi.testservice.data.model;

import java.util.Date;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class RegistrationModel {

    private String name;
    private String address;
    private String mail;
    private ProductModel productModel;
    private String contact;
    private String serial;
    private Date purchase;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getPurchase() {
        if (purchase != null) {
            return new Date(purchase.getTime());
        }
        return null;
    }

    public void setPurchase(Date purchase) {
        if (purchase != null) {
            this.purchase = new Date(purchase.getTime());
            return;
        }
        this.purchase = null;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "name=" + name +
                ", address=" + address +
                ", contact=" + contact +
                ", mail=" + mail +
                ", serial=" + serial +
                ", purchase=" + purchase +
                ", product=" + productModel +
                "}";
    }
}

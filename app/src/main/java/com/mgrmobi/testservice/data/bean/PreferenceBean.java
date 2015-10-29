package com.mgrmobi.testservice.data.bean;

import java.util.Date;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public interface PreferenceBean {

    void setLastModifyTime(final Date date);

    Date getLastModifyTime();
}

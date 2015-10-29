package com.mgrmobi.testservice.service;

import java.util.Date;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public interface TestService {

    void setPurchaseDateTime(final Date dateTime);

    void subscribeToTimer();

    void unsubscribeFromTimer();
}

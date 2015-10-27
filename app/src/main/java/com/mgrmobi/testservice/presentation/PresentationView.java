package com.mgrmobi.testservice.presentation;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public interface PresentationView {

    /**
     * Apply change to model
     */
    void apply();

    /**
     * Dispose resources
     */
    void destroy();

    /**
     * Clear model
     */
    void clear();

    boolean validation();
}

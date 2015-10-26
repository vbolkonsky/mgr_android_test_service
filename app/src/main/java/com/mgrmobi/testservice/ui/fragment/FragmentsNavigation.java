package com.mgrmobi.testservice.ui.fragment;

import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public final class FragmentsNavigation {


    private FragmentsNavigation() {

    }

    public static BaseFragment makeFragment(final FragmentCode code) {
        switch (code) {
            case FRAGMENT_REGISTER:
                return FragmentRegister.makeFragment();
            default:
                return null;
        }
    }


    /**
     * Fragments Codes
     */
    public enum FragmentCode{
        FRAGMENT_REGISTER, FRAGMENT_FAKE;
    }

}

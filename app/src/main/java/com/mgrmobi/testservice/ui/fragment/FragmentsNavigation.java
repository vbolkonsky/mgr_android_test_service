package com.mgrmobi.testservice.ui.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mgrmobi.testservice.ui.fragment.base.BaseFragment;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public final class FragmentsNavigation {


    private FragmentsNavigation() {

    }

    public static BaseFragment makeFragment(final @NonNull FragmentCode code, final @Nullable String message) {
        switch (code) {
            case FRAGMENT_REGISTER:
                return FragmentRegister.makeFragment();
            case FRAGMENT_FAKE:
                return FragmentFake.makeFragment(message);
            default:
                return null;
        }
    }


    /**
     * Fragments Codes
     */
    public enum FragmentCode {
        FRAGMENT_REGISTER, FRAGMENT_FAKE;
    }

}

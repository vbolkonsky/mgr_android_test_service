package com.mgrmobi.testservice.dagger;

import android.util.Log;

import com.mgrmobi.testservice.ui.activity.ActivityMain;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class InjectedActivityMain extends InjectedBaseActivityTest<ActivityMain> {

    public InjectedActivityMain() {
        super(ActivityMain.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testDaggerCreated(){
        Log.d("InjectedActivityMain", "Current Application Name: " + application.getApplicationName());
        assertNotNull("fake application name", application.getApplicationName());
        assertEquals("test application", application.getApplicationName());
    }

}

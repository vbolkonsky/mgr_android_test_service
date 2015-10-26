package com.mgrmobi.testservice;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

import com.mgrmobi.testservice.ui.activity.ActivityMain;
import com.robotium.solo.Solo;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 * @see com.mgrmobi.testservice.ui.activity.ActivityMain
 */

/**
 * A simple test of creating the main screen
 */
public class ActivityMainTest extends ActivityInstrumentationTestCase2<ActivityMain> {

    private ActivityMain activityMain;
    private Solo solo;

    public ActivityMainTest() {
        super(ActivityMain.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        activityMain = getActivity();
        setActivityInitialTouchMode(true);
        System.setProperty(
                "dexmaker.dexcache",
                getInstrumentation().getTargetContext().getCacheDir().getPath());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testPreconditions() {
        assertNotNull("activityMain is null", activityMain);
    }

    @MediumTest
    public void testNavigationDrawable() {
        final DrawerLayout drawerLayout = (DrawerLayout)activityMain.findViewById(R.id.drawer_layout);
        assertNotNull("DrawerLayout is not null", drawerLayout);
        solo.waitForCondition(() -> drawerLayout.isDrawerOpen(GravityCompat.START), 5000);

    }
}

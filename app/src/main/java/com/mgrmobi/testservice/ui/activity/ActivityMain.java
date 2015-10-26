package com.mgrmobi.testservice.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.ui.activity.base.BaseDrawerActivity;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.fragment.FragmentsNavigation;

import butterknife.OnClick;

public class ActivityMain extends BaseDrawerActivity implements ContainerRegister {

    private FragmentsNavigation.FragmentCode pendingFragmentCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logger.debug("ActivityMain created");
    }

    @OnClick(R.id.fab)
    protected void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_navigation_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_register:
                pendingFragmentCode = FragmentsNavigation.FragmentCode.FRAGMENT_REGISTER;
            default:
        }
        return super.onNavigationItemSelected(item);
    }

    @Override
    protected void onEventDrawerClosed() {
        super.onEventDrawerClosed();
        if (pendingFragmentCode != null) {
            replaceFragment(FragmentsNavigation.makeFragment(pendingFragmentCode));
            pendingFragmentCode = null;
        }
    }
}

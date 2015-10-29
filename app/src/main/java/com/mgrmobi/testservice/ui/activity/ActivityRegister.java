package com.mgrmobi.testservice.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mgrmobi.testservice.R;
import com.mgrmobi.testservice.ui.activity.base.BaseActivity;
import com.mgrmobi.testservice.ui.activity.base.ContainerRegister;
import com.mgrmobi.testservice.ui.fragment.FragmentsNavigation;

import butterknife.OnClick;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class ActivityRegister extends BaseActivity implements ContainerRegister {


    @Override
    protected int getResourceLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(FragmentsNavigation.makeFragment(FragmentsNavigation.FragmentCode.FRAGMENT_REGISTER, null));
    }

    @OnClick(R.id.btn_register)
    protected void onRegisterPressed(){
        logger.debug("onRegisterPressed");
        if(currentFragment != null){
            currentFragment.apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_skip) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

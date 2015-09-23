package com.allancaine.nymoma;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by allancaine on 2015-08-08.
 */
public abstract class OneFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    protected abstract int getFragmentContainerId();

    protected abstract int getFragmentContainerLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getFragmentContainerLayout());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getFragmentContainerId());

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(getFragmentContainerId(), fragment)
                    .commit();
        }

    }
}

package com.allancaine.nymoma;

import android.support.v4.app.Fragment;

/**
 * Created by allancaine on 2015-08-09.
 */
public class MomaWebSiteActivity extends OneFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MomaWebSiteFragment();
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected int getFragmentContainerLayout() {
        return R.layout.activity_modern_art;
    }
}

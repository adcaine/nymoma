package com.allancaine.nymoma;


import android.support.v4.app.Fragment;

public class ModernArtActivity extends OneFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ModernArtFragment();
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

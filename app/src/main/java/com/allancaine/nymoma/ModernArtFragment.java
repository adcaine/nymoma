package com.allancaine.nymoma;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by allancaine on 2015-08-08.
 */
public class ModernArtFragment extends Fragment {

    private static final String MONA_DIALOG = "mona_dialog";

    private static final int REQUEST_MOMA_DIALOG_RESPONSE = 0;

    TextView mPanel1, mPanel2, mPanel3, mPanel4, mPanel5, mPanel6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_modern_art, container, false);
        v.setBackgroundColor(Color.BLACK);

        mPanel1 = (TextView)v.findViewById(R.id.panel1);
        mPanel2 = (TextView)v.findViewById(R.id.panel2);
        mPanel3 = (TextView)v.findViewById(R.id.panel3);
        mPanel4 = (TextView)v.findViewById(R.id.panel4);
        mPanel5 = (TextView)v.findViewById(R.id.panel5);
        mPanel6 = (TextView)v.findViewById(R.id.panel6);
        mPanel1.setEnabled(false);
        mPanel2.setEnabled(false);
        mPanel3.setEnabled(false);
        mPanel4.setEnabled(false);
        mPanel5.setEnabled(false);
        mPanel6.setEnabled(false);
        SeekBar seekBar = (SeekBar)v.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateUI(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
        seekBar.setProgress(0);
        updateUI(0);
        return v;
    }

    private void updateUI(int seekBarProgress){
        mPanel1.setBackgroundColor(0xccFF0000 + seekBarProgress);
        mPanel2.setBackgroundColor(0xccFF00AF + (seekBarProgress << 8));
        mPanel3.setBackgroundColor(0xcc00FF00 + seekBarProgress);
        mPanel4.setBackgroundColor(Color.GRAY);
        mPanel5.setBackgroundColor(0xcc0000FF + (seekBarProgress << 8));
        mPanel6.setBackgroundColor(0xcc00AFFF + (seekBarProgress << 16));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_modern_art, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.more_info_settings:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                MomaDialog dialog = new MomaDialog();
                dialog.setTargetFragment(ModernArtFragment.this, REQUEST_MOMA_DIALOG_RESPONSE);
                dialog.show(fm, MONA_DIALOG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_MOMA_DIALOG_RESPONSE && resultCode == Activity.RESULT_OK){

            Intent intent = new Intent(getActivity(), MomaWebSiteActivity.class);
            Uri momaWebsite = Uri.parse(getString(R.string.moma_website));
            intent.setData(momaWebsite);

            startActivity(intent);
        }
    }
}

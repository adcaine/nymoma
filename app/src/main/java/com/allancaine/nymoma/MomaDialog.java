package com.allancaine.nymoma;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by allancaine on 2015-08-08.
 */
public class MomaDialog extends DialogFragment {

    private void dispatchResult(int resultCode){
        if(getTargetFragment() != null){
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, null);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.moma_dialog_title)
                .setMessage(R.string.moma_dialog_explanation)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dispatchResult(Activity.RESULT_OK);
                    }
                })
                .setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dispatchResult(Activity.RESULT_CANCELED);
                    }
                })
                .create();
    }
}

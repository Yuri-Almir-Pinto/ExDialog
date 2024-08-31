package com.example.exdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setMessage(R.string.dialog_confirm)
                .setTitle(R.string.app_name)
                .setPositiveButton(R.string.sim, this)
                .setNegativeButton(R.string.nao, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE) {
            Toast.makeText(getActivity(), R.string.bye, Toast.LENGTH_SHORT).show();
        }
        else if (i == DialogInterface.BUTTON_NEGATIVE) {
            Toast.makeText(getActivity(), R.string.wuv_u, Toast.LENGTH_SHORT).show();
        }
    }
}

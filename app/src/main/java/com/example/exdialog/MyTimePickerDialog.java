package com.example.exdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.function.Consumer;

public class MyTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private Calendar _currentTime;
    private Consumer<Calendar> _callback;

    public MyTimePickerDialog(Calendar date, Consumer<Calendar> callback) {
        this._currentTime = date;
        this._callback = callback;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int hour = this._currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = this._currentTime.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        this._currentTime.set(Calendar.HOUR, i);
        this._currentTime.set(Calendar.MINUTE, i1);

        this._callback.accept(this._currentTime);
    }
}

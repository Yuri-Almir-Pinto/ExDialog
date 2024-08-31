package com.example.exdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Locale;
import java.util.function.Consumer;

public class MyDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private Calendar _date;
    private Consumer<Calendar> _callback;

    public MyDatePickerDialog(Calendar date, Consumer<Calendar> callback) {
        this._date = date;
        this._callback = callback;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int year = this._date.get(Calendar.YEAR);
        int month = this._date.get(Calendar.MONTH);
        int dayOfMonth = this._date.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this,
                year, month, dayOfMonth);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        this._date.set(Calendar.YEAR, i);
        this._date.set(Calendar.MONTH, i1);
        this._date.set(Calendar.DAY_OF_MONTH, i2);

        this._callback.accept(this._date);
    }
}

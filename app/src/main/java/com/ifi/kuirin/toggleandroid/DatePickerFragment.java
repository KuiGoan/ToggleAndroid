package com.ifi.kuirin.toggleandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by KuiRin on 9/12/2017 AD.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public static DatePickerFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        // Create a new instance of DatePickerDialog and return it
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        c.add(Calendar.DAY_OF_MONTH, -30);
        dialog.getDatePicker().setMinDate(c.getTimeInMillis());
        dialog.setButton(DatePickerDialog.BUTTON_POSITIVE, " 1", dialog);
        dialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, " 2", dialog);
        dialog.setButton(DatePickerDialog.BUTTON_NEUTRAL, " 3", dialog);
        return dialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.d("onDateSet", "onDateSet#year = " + year + " ,month = " + month + " ,day = " + day);
    }
}

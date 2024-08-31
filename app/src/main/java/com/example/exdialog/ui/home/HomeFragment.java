package com.example.exdialog.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.exdialog.MyDatePickerDialog;
import com.example.exdialog.MyTimePickerDialog;
import com.example.exdialog.databinding.FragmentHomeBinding;

import java.util.Calendar;
import java.util.Locale;
import java.util.function.Consumer;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private Calendar _currentTime = Calendar.getInstance();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setDisplayText(this._currentTime);

        binding.btnDate.setOnClickListener(this);
        binding.btnTime.setOnClickListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnTime.getId()) {
            MyTimePickerDialog picker = new MyTimePickerDialog(this._currentTime, new Consumer<Calendar>() {
                @Override
                public void accept(Calendar calendar) {
                    setDisplayText(calendar);
                }
            });

            picker.show(getActivity().getSupportFragmentManager(), "timePicker");
        }

        if (view.getId() == binding.btnDate.getId()) {
            MyDatePickerDialog picker = new MyDatePickerDialog(this._currentTime, new Consumer<Calendar>() {
                @Override
                public void accept(Calendar calendar) {
                    setDisplayText(calendar);
                }
            });

            picker.show(getActivity().getSupportFragmentManager(), "datePicker");
        }
    }

    private void setDisplayText(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String msg = String.format(
                new Locale("pt", "br"),
                "%02d/%02d/%d - %02d:%02d",
                year, month, dayOfMonth, hour, minute
                );

        binding.displayText.setText(msg);
    }
}
package com.example.contacts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


public class DatePickerDialog extends DialogFragment {

    Calendar selectedDate;
    CalendarView cv;
    Button saveButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_date, container); //object allow to get a view from xml
        getDialog().setTitle("Select Date");
        selectedDate = Calendar.getInstance();  //initial calendar object returns the terekh lyum
        cv = view.findViewById(R.id.calendarView);
        saveButton = view.findViewById(R.id.buttonSave);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                selectedDate.set(year,month,day);
                //Log.d("Dialog", selectedDate.getTime().toString());  how to test if its true
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem(selectedDate);
            }
        });


        return view;
    }
    private void saveItem(Calendar calendar){
        SaveDateListener activity = (SaveDateListener)getActivity();
        activity.didFinishDatePickerDialog(selectedDate);
        getDialog().dismiss();
    }

    public interface SaveDateListener{
        void didFinishDatePickerDialog(Calendar selectedDate);
    }


}

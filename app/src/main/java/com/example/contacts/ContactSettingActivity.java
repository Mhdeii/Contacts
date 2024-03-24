package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ContactSettingActivity extends AppCompatActivity {

    ImageButton listImageButton, mapImageButton, settingsImageButton;

    RadioGroup sortByRadioGroup, sortOrderByRadioGroup;
    RadioButton nameRadioButton, cityRadioButton, birthdayRadioButton, descendingRadioButton, ascendingRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        NavBarInitializer.initImageButtons(mapImageButton,listImageButton,settingsImageButton,this);
    }


    private void initLayout() {
        listImageButton = findViewById(R.id.imageButtonList);
        mapImageButton = findViewById(R.id.imageButtonMap);
        settingsImageButton = findViewById(R.id.imageButtonSettings);
        sortByRadioGroup = findViewById(R.id.sortByRadioGroup);
        sortOrderByRadioGroup = findViewById(R.id.radioGroupSortOrder);
        nameRadioButton = findViewById(R.id.radioButtonName);
        cityRadioButton = findViewById(R.id.radioButtonCity);
        birthdayRadioButton = findViewById(R.id.radioButtonBirthday);
        descendingRadioButton = findViewById(R.id.radioDescending);
        ascendingRadioButton = findViewById(R.id.radioAscending);
    }
}
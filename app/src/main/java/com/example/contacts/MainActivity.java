package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener{
    ImageButton listImageButton, mapImageButton, settingsImageButton;
    ToggleButton editToggle;
    EditText nameEditText;
    Button birthdayButton;
    TextView birthdayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        NavBarInitializer.initImageButtons(mapImageButton,listImageButton,settingsImageButton,MainActivity.this);

        listImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                startActivity(intent);
            }
        });

        mapImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactMapActivity.class);
                startActivity(intent);
            }
        });

        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactSettingActivity.class);
                startActivity(intent);
            }
        });


        initToggleButton();
        setForEditing(false);
        initBirthdayButton();

    }

    private void initBirthdayButton() {
        birthdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog dialog = new DatePickerDialog();
                dialog.show(fm,"select date");
            }
        });
    }

    private void  initToggleButton(){
        editToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setForEditing(editToggle.isChecked());
            }
        });
    }
    private void setForEditing(boolean checked){
        nameEditText.setEnabled(checked);

        if(checked)
            nameEditText.requestFocus();
    }

    private void initLayout() {
        listImageButton = findViewById(R.id.imageButtonList);
        mapImageButton = findViewById(R.id.imageButtonMap);
        settingsImageButton = findViewById(R.id.imageButtonSettings);
        editToggle = findViewById(R.id.toggleButtonEdit);
        nameEditText = findViewById(R.id.editName);
        birthdayButton = findViewById(R.id.btnBirthday);
        birthdayText = findViewById(R.id.textViewBirthday);
    }


    @Override
    public void didFinishDatePickerDialog(Calendar selectedDate) {
    birthdayText.setText(DateFormat.format("dd/MM/yyyy", selectedDate));
    }
}
package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    ImageButton listImageButton, mapImageButton, settingsImageButton, saveButton;
    Button changeBirthdayButton, changeRelationshipButton;
    ToggleButton editToggle;
    EditText nameEditText, addressEditText, cityEditText,
            stateEditText, zipEditText, homeEditText,
            cellEditText, emailEditText;
    TextView birthdayText, relationshipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayoutComponents();
        NavBarInitializer.initImageButtons(listImageButton, mapImageButton, settingsImageButton, this);
        initToggleButton();
        setForEditing(false);
        initChangeBirthdayButton();
        initChangeRelationshipButton();
    }

    private void initToggleButton() {
        editToggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setForEditing(editToggle.isChecked());
            }
        });
    }

    private void setForEditing(boolean checked) {
        nameEditText.setEnabled(checked);
        addressEditText.setEnabled(checked);
        cityEditText.setEnabled(checked);
        stateEditText.setEnabled(checked);
        zipEditText.setEnabled(checked);
        homeEditText.setEnabled(checked);
        cellEditText.setEnabled(checked);
        emailEditText.setEnabled(checked);
        changeBirthdayButton.setEnabled(checked);
        changeRelationshipButton.setEnabled(checked);
        saveButton.setEnabled(checked);
        if(checked) {
            nameEditText.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInput(nameEditText, 0);
        }
    }

    private void initChangeBirthdayButton() {
        changeBirthdayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog dialog = new DatePickerDialog();
                dialog.show(fm, "DatePicker");
            }
        });
    }

    private void initChangeRelationshipButton() {
        changeRelationshipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRelationshipPickerDialog();
            }
        });
    }

    private void showRelationshipPickerDialog() {
        RelationshipPickerDialog dialog = new RelationshipPickerDialog(this, relationshipText);
        dialog.show(getSupportFragmentManager(), "RelationshipPickerDialog");
    }

    private void initLayoutComponents(){
        listImageButton = findViewById(R.id.imageButtonList);
        mapImageButton = findViewById(R.id.imageButtonMap);
        settingsImageButton = findViewById(R.id.imageButtonSettings);
        editToggle = findViewById(R.id.toggleButtonEdit);
        nameEditText = findViewById(R.id.editName);
        addressEditText = findViewById(R.id.editAddress);
        cityEditText = findViewById(R.id.editCity);
        stateEditText = findViewById(R.id.editState);
        zipEditText = findViewById(R.id.editZip);
        homeEditText  = findViewById(R.id.editHome);
        cellEditText = findViewById(R.id.editCell);
        emailEditText = findViewById(R.id.editEmail);
        changeBirthdayButton = findViewById(R.id.btnBirthday);
        changeRelationshipButton = findViewById(R.id.buttonSelectRelationship);
        saveButton = findViewById(R.id.imageButtonSave);
        birthdayText = findViewById(R.id.textViewBirthday);
        relationshipText = findViewById(R.id.textRelationship);
    }

    @Override
    public void didFinishDatePickerDialog(Calendar selectedDate) {
        birthdayText.setText(DateFormat.format("dd/MM/yyyy", selectedDate));
    }
}

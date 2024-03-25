package com.example.contacts;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class RelationshipPickerDialog extends DialogFragment {

    private Context context;
    private TextView relationshipTextView;

    public RelationshipPickerDialog(Context context, TextView relationshipTextView) {
        this.context = context;
        this.relationshipTextView = relationshipTextView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_relationship_selection, null);
        builder.setView(dialogView);

        RadioGroup radioGroup = dialogView.findViewById(R.id.radioGroup);
        Button cancelButton = dialogView.findViewById(R.id.buttonCancel);
        Button saveButton = dialogView.findViewById(R.id.buttonSave);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relationshipTextView.setText("Not Set");
                dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton radioButton = dialogView.findViewById(selectedId);
                    String selectedRelationship = radioButton.getText().toString();
                    relationshipTextView.setText(selectedRelationship);
                } else {
                    relationshipTextView.setText("Not Set");
                }
                dismiss();
            }
        });

        return builder.create();
    }
}

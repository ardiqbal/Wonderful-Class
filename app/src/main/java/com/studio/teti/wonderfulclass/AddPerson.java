package com.studio.teti.wonderfulclass;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by msipc on 30/08/2016.
 */
public class AddPerson extends DialogFragment{

    public AddPerson(){

    }


    private RadioGroup radioGroup1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.add_person_pop_window, container, false);

        Button closing = (Button)v.findViewById(R.id.add_peson_cls_btn);

        closing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        radioGroup1 = (RadioGroup)v.findViewById(R.id.radioGroup1);

        // Checked change Listener for RadioGroup 1
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.button_male:

                        break;
                    case R.id.button_female:
                        break;
                }
            }
        });
        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.button_male:
                if (checked)
                    break;
            case R.id.button_female:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }*/
}

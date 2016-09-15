package com.studio.teti.wonderfulclass;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firebase.client.Firebase;
import com.studio.teti.wonderfulclass.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import layout.Kelas;

/**
 * Created by msipc on 30/08/2016.
 */
public class AddPersonFragment extends DialogFragment{

    public static AddPersonFragment newInstance(){
        AddPersonFragment addPerson = new AddPersonFragment();
        Bundle bundle = new Bundle();
        addPerson.setArguments(bundle);
        return addPerson;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    RelativeLayout rl;
    private RadioGroup radioGroup1;
    EditText pName;
    Person p;
    Button bOK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.add_person_pop_window, container, false);
        rl = (RelativeLayout)v.findViewById(R.id.addLayout);
        pName = (EditText)v.findViewById(R.id.pName);
        bOK = (Button)v.findViewById(R.id.bOK);
        p = new Person();

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pName.getText().toString().trim().equals("")){
                    final Snackbar snackBar = Snackbar.make(rl, "Nama tidak boleh kosong.", Snackbar.LENGTH_LONG);
                    snackBar.setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackBar.dismiss();
                        }
                    });
                    snackBar.show();
                }
                else {
                    p.setName(pName.getText().toString());
                    addPerson(p);
                    dismiss();
                }
            }
        });

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
                        p.setImage(R.mipmap.anak_laki);
                        break;
                    case R.id.button_female:
                        p.setImage(R.mipmap.anak_perempuan);
                        break;
                }
            }
        });
        return v;
    }

    public void addPerson(Person model) {
        Firebase listSiswaRef = new Firebase(Constants.FIREBASE_URL_USER_LISTS);

        Firebase newListRef = listSiswaRef.push();
        Person person = new Person();
        person.setName(model.getName());
        person.setImage(model.getImage());

        final String listId = newListRef.getKey();

        newListRef.setValue(person);
        /*String key = mDatabase.child("Persons").push().getKey();
        Map<String, Object> postValues = person.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, postValues);
        mDatabase.updateChildren(childUpdates);*/
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}

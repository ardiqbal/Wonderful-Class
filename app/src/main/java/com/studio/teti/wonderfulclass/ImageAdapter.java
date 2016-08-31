package com.studio.teti.wonderfulclass;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonDetailsAdapter extends BaseAdapter {
    private ArrayList<Person> arrayListPerson;
    private Context context;
    private LayoutInflater inflater;

    public PersonDetailsAdapter(Context context, ArrayList<Person> arrayListPerson) {
        this.context = context;
        this.arrayListPerson = arrayListPerson;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListPerson.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        Holder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.content_kelas, null);
            holder = new Holder();
            holder.PersonName = (TextView) v.findViewById(R.id.PersonName);
            v.setTag(holder);
        } else {
            holder = (Holder) v.getTag();
        }

        holder.PersonName.setText(arrayListPerson.get(position).getName());

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AddOrUpdatePersonActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Position", position);
                context.getApplicationContext().startActivity(intent);
            }
        });
        holder.DeletePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowConfirmDialog(context, position);
            }
        });
        return v;
    }

    class Holder {
        TextView PersonName;
    }

    public static void ShowConfirmDialog(Context context, final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage("Are you sure you want to delete this entry?")
                .setCancelable(true)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.getInstance().deletePerson(position);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
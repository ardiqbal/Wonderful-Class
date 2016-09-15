package com.studio.teti.wonderfulclass;

/**
 * Created by Rifqi Zuliansyah on 31/08/2016.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
            holder.avatar = (ImageView) v.findViewById(R.id.Avatar);
            v.setTag(holder);
        } else {
            holder = (Holder) v.getTag();
        }

        holder.PersonName.setText(arrayListPerson.get(position).getName());
        holder.avatar.setImageResource(arrayListPerson.get(position).getImage());
        return v;
    }

    class Holder {
        TextView PersonName;
        ImageView avatar;
    }
}
package com.example.vladimir.a04_01_18_home_work;

import android.view.*;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by vladimir on 06/01/2018.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Person> personArrayList;
    public MyAdapter() {
        personArrayList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.my_row, viewGroup, false);
        }
        Person p = personArrayList.get(i);
        TextView name = view.findViewById(R.id.row_name);
        TextView phone = view.findViewById(R.id.row_phone);
        TextView email = view.findViewById(R.id.row_email);
        TextView description = view.findViewById(R.id.row_description);

        name.setText(p.getName());
        phone.setText(p.getPhone());
        email.setText(p.getEmail());
        description.setText(p.getDescription());

        return view;
    }

    public void addPerosn(Person p){
        personArrayList.add(0, p);
        notifyDataSetChanged();
    }
}

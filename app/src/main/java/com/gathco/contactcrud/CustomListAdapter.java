package com.gathco.contactcrud;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ModalContact> movieItems;

    public CustomListAdapter(Activity activity, List<ModalContact> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView namaakun = (TextView) convertView.findViewById(R.id.text_akun);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);

        ModalContact m = movieItems.get(position);

//		imageView.setImageResource(R.drawable.ImageView);
//		} else {
//			imageView.setImageResource(R.drawable.ic_person_red_24dp);
//		}

        nama.setText("Nama : "+ m.get_name());
        namaakun.setText("Nomor : "+ m.get_number());

        return convertView;
    }

}

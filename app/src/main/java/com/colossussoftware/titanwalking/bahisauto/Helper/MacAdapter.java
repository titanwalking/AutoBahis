package com.colossussoftware.titanwalking.bahisauto.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.colossussoftware.titanwalking.bahisauto.DataObjects.Mac;
import com.colossussoftware.titanwalking.bahisauto.R;

import java.util.ArrayList;

/**
 * Created by Ali on 6.01.2018.
 */

public class MacAdapter extends ArrayAdapter<Mac> {

    public MacAdapter(@NonNull Context context, ArrayList<Mac> maclar) {
        super(context, 0, maclar);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Mac mac = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_layout, parent, false);
        }
        // Lookup view for data population
        TextView takimlar = (TextView) convertView.findViewById(R.id.txt_takimlar);
        TextView oynanmaYuzdesi = (TextView) convertView.findViewById(R.id.txt_oynanmaYuzdesi);
        TextView kod = (TextView) convertView.findViewById(R.id.txt_kod);
        TextView bahis = (TextView) convertView.findViewById(R.id.txt_bahis);
        TextView oran = (TextView) convertView.findViewById(R.id.txt_oran);
        TextView tarih = (TextView) convertView.findViewById(R.id.txt_tarih);
        ImageView icon = (ImageView) convertView.findViewById(R.id.img_oyunTuru);

        takimlar.setText(mac.getTakimlar());
        oynanmaYuzdesi.setText("% " + String.valueOf(mac.getOynanmaYuzdesi()));
        kod.setText("Kod: \n" + mac.getKod());
        oran.setText(String.valueOf(mac.getOran()));
        bahis.setText(mac.getBahis());
        icon.setImageResource(R.drawable.futbol);
        tarih.setText(mac.getTarih());

        return convertView;
    }
}

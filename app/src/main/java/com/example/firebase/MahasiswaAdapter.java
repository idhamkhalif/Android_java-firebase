package com.example.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MahasiswaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

    public void setMahasiswaList(ArrayList<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public MahasiswaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int i) {
        return mahasiswaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_mahasiswa, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Mahasiswa mahasiswa = (Mahasiswa) getItem(i);
        viewHolder.bind(mahasiswa);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNim, txtName;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_nama);
            txtNim = view.findViewById(R.id.txt_nim);
        }

        void bind(Mahasiswa mahasiswa) {
            txtName.setText(mahasiswa.getNama());
            txtNim.setText(mahasiswa.getNim());
        }
    }
}

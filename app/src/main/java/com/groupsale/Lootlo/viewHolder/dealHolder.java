package com.groupsale.Lootlo.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.groupsale.Lootlo.R;

public class dealHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public TextView textView2;
    public TextView textview3; //clock

    public dealHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        textView = itemView.findViewById(R.id.textview);
        textView2 = itemView.findViewById(R.id.textview2);
        textview3 = itemView.findViewById(R.id.textview3);
    }
}

package com.example.whatsappcloneui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappcloneui.Models.ContactOptionsModel;
import com.example.whatsappcloneui.R;

import java.util.ArrayList;

public class ContactOptionsAdapter extends RecyclerView.Adapter<ContactOptionsAdapter.ContactOptionsHolder> {
    private ArrayList<ContactOptionsModel> contactOptions;

    public ContactOptionsAdapter(ArrayList<ContactOptionsModel> contactOptions) {
        this.contactOptions = contactOptions;
    }

    @NonNull
    @Override
    public ContactOptionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_cardview, parent, false);
        return new ContactOptionsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactOptionsHolder holder, int position) {
        holder.contactOptionImg.setImageResource(R.drawable.profile_photo);
        holder.contactOptionName.setText(contactOptions.get(position).getOptionsName());
    }

    @Override
    public int getItemCount() {
        return contactOptions.size();
    }

    public class ContactOptionsHolder extends RecyclerView.ViewHolder {
        ImageView contactOptionImg;
        TextView contactOptionName;
        public ContactOptionsHolder(@NonNull View itemView) {
            super(itemView);
            contactOptionImg = itemView.findViewById(R.id.contactPhoto);
            contactOptionName = itemView.findViewById(R.id.contactName);
        }
    }
}

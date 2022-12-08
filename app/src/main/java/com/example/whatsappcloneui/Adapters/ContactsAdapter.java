package com.example.whatsappcloneui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappcloneui.Models.ContactModel;
import com.example.whatsappcloneui.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsHolder> {
    private ArrayList<ContactModel> contactModels;

    public ContactsAdapter(ArrayList<ContactModel> contactModels) {
        this.contactModels = contactModels;
    }

    @NonNull
    @Override
    public ContactsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_cardview, parent, false);
        return new ContactsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsHolder holder, int position) {
        holder.contactPhoto.setImageResource(R.drawable.profile_photo);
        holder.contactName.setText(contactModels.get(position).getContactName());
    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class ContactsHolder extends RecyclerView.ViewHolder {
        ImageView contactPhoto;
        TextView contactName;

        public ContactsHolder(@NonNull View itemView) {
            super(itemView);
            contactPhoto = itemView.findViewById(R.id.contactPhoto);
            contactName = itemView.findViewById(R.id.contactName);
        }
    }
}

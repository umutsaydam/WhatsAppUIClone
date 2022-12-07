package com.example.whatsappcloneui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappcloneui.Models.Message;
import com.example.whatsappcloneui.R;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesHolder> {
    private ArrayList<Message> messages;
    private Context context;

    public MessagesAdapter(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public MessagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_row, parent, false);
        return new MessagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesHolder holder, int position) {
        holder.messagesProfilePhoto.setImageResource(messages.get(position).getProfilePhoto());
        holder.senderInfo.setText(messages.get(position).getSender());
        holder.messageTime.setText(messages.get(position).getTime());
        holder.countOfMessages.setText(String.valueOf(messages.get(position).getCountOfMessage()));
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessagesHolder extends RecyclerView.ViewHolder {
        ImageView messagesProfilePhoto;
        TextView senderInfo, sendersMessage, messageTime, countOfMessages;
        public MessagesHolder(@NonNull View itemView) {
            super(itemView);
            messagesProfilePhoto = itemView.findViewById(R.id.messagesProfilePhoto);
            senderInfo = itemView.findViewById(R.id.senderInfo);
            sendersMessage = itemView.findViewById(R.id.sendersMessage);
            messageTime = itemView.findViewById(R.id.messageTime);
            countOfMessages = itemView.findViewById(R.id.countOfMessages);
        }
    }
}

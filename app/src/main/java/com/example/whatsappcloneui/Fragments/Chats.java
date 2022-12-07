package com.example.whatsappcloneui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsappcloneui.Adapters.MessagesAdapter;
import com.example.whatsappcloneui.Models.Message;
import com.example.whatsappcloneui.R;
import java.util.ArrayList;


public class Chats extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(R.drawable.profile_photo, "Umut Saydam", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Emre Yılmaz", "Hi!", "Today", 1));
        messages.add(new Message(R.drawable.profile_photo, "Mehmet Çelik", "I forget to send it ...", "Yestarday", 1));

        recyclerView.setAdapter(new MessagesAdapter(messages, getContext()));

       return view;
    }

}
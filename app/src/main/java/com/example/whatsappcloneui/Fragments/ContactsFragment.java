package com.example.whatsappcloneui.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsappcloneui.Adapters.ContactsAdapter;
import com.example.whatsappcloneui.Models.ContactModel;
import com.example.whatsappcloneui.R;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {
    private RecyclerView contactsPersonsRecycler, contactsOptionsRecycler;
    private ArrayList<ContactModel> contactModels = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        contactsPersonsRecycler = view.findViewById(R.id.contactsPersonsRecycler);
        contactsOptionsRecycler = view.findViewById(R.id.contactsOptionsRecycler);
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 100);
      //  checkPermission();
        return  view;
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            // When permission is not granted then request permission
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 100);
        }else{
            getContactList();
        }
    }

    private void getContactList() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String sort = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC";
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, sort);

        if (cursor.getCount() > 0 && cursor.moveToFirst()){
            while(cursor.moveToNext()){
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                System.out.println(name +"******");
                Uri uriPhone = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =?";
                Cursor phoneCursor = getContext().getContentResolver().query(uriPhone, null, selection, new String[]{id}, null);
                if (phoneCursor.moveToNext()){
                    @SuppressLint("Range") String number = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    ContactModel contactModel = new ContactModel(name, number);
                    contactModels.add(contactModel);
                    phoneCursor.close();
                }
            }
            cursor.close();

            ContactsAdapter adapter = new ContactsAdapter(contactModels);
            contactsPersonsRecycler.setAdapter(adapter);

        }
    }

    ActivityResultLauncher<String> requestPermisionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted ->{
                if (isGranted){
                    getContactList();
                }else{
                    Toast.makeText(getContext(), "Hata 89 line", Toast.LENGTH_SHORT).show();
                    checkPermission();
                }
            });
}
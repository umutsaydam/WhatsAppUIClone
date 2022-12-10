package com.example.whatsappcloneui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappcloneui.Adapters.ViewPagerAdapter;
import com.example.whatsappcloneui.Fragments.CallsFragment;
import com.example.whatsappcloneui.Fragments.ChatsFragment;
import com.example.whatsappcloneui.Fragments.CommunityFragment;
import com.example.whatsappcloneui.Fragments.StatusFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton mainFloatingBtn, cameraFloatingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        mainFloatingBtn = findViewById(R.id.mainFloatingBtn);
        cameraFloatingBtn = findViewById(R.id.cameraFloatingBtn);

        setViewPagerAndTabLayout();
        reduceDrag();

    }

    public void setViewPagerAndTabLayout(){
        ArrayList<String> menuNames = new ArrayList<>();
        menuNames.add("Community");
        menuNames.add("Chats");
        menuNames.add("Status");
        menuNames.add("Calls");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CommunityFragment());
        fragments.add(new ChatsFragment());
        fragments.add(new StatusFragment());
        fragments.add(new CallsFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.setFragments(fragments);
        adapter.setMenuNames(menuNames);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setIcon(R.drawable.ic_community);
                if(position != 0) tab.setText(adapter.getFragmentName(position));
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.ic_community);
                        mainFloatingBtn.setVisibility(View.GONE);
                        cameraFloatingBtn.setVisibility(View.GONE);
                        break;
                    case 1:
                        mainFloatingBtn.setVisibility(View.VISIBLE);
                        cameraFloatingBtn.setVisibility(View.GONE);
                        break;
                    case 2:
                        mainFloatingBtn.setVisibility(View.VISIBLE);
                        cameraFloatingBtn.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mainFloatingBtn.setVisibility(View.VISIBLE);
                        cameraFloatingBtn.setVisibility(View.GONE);
                        System.out.println("");
                        break;

                }
            }
        }).attach();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    void reduceDrag(){
        try {
            Field ff = ViewPager2.class.getDeclaredField("mRecyclerView");
            ff.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) ff.get(viewPager);
            Field touchSlopField = RecyclerView.class.getDeclaredField("mTouchSlop");
            touchSlopField.setAccessible(true);
            int touchSlop = (int) touchSlopField.get(recyclerView);
            touchSlopField.set(recyclerView, touchSlop*4);
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
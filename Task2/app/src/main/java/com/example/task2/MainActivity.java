package com.example.task2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.task2.fragments.Firstfragment;
import com.example.task2.fragments.SecondFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> mylist;
   private FrameLayout f1,f2;
   RecyclerView recyclerView;
   Fragment fr1,fr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#ffff8800"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        fr1=new Firstfragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        fragmentTransaction.replace(R.id.fr01,fr1);
        fragmentTransaction.commit();

        fr2=new SecondFragment();
        FragmentManager sfm=getSupportFragmentManager();
        FragmentTransaction sfragmentTransaction=sfm.beginTransaction();
        sfragmentTransaction.replace(R.id.fr02,fr2);
        sfragmentTransaction.commit();


    }
}
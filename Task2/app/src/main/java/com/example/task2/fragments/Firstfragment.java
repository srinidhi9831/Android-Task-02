package com.example.task2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.task2.R;
import com.example.task2.adapters.RecycleAdapter;
import com.example.task2.model.Mymodel;
import java.util.ArrayList;
import java.util.List;


public class Firstfragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Mymodel> mylist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_firstfragment, container, false);
        recyclerView=view.findViewById(R.id.reView01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mylist=new ArrayList<>();
        RecycleAdapter myadp=new RecycleAdapter(mylist);
        recyclerView.setAdapter(myadp);
        // recyclerView.setAdapter(new RecycleAdapter(mylist));
        getParentFragmentManager().setFragmentResultListener("requestAdd", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("text");

                if (data != null || data != " ") {

                        Mymodel object = new Mymodel(data);
                        myadp.mylist.add(object);
                        myadp.notifyDataSetChanged();

                    }

            }
        });
        getParentFragmentManager().setFragmentResultListener("requestDel", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle res) {
                String isDel= res.getString("delkey");
                if(isDel=="delete"){

                    List<Mymodel> mod=myadp.getChecked();
                    for(Mymodel m:mod){
                        myadp.mylist.remove(m);
                        //recyclerView.setAdapter(myadp);
                    }
                   // recyclerView.setAdapter(myadp);
                    myadp.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
package com.example.task2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task2.R;


public class SecondFragment extends Fragment {


    private Button add,delete;
    private EditText text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        add=view.findViewById(R.id.btAdd);
        delete=view.findViewById(R.id.btDel);
        text=view.findViewById(R.id.etAdd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=text.getText().toString();

                if(t.equals(null) || (t.trim().length()<=0)){
                    Toast.makeText(getContext(),"please add item",Toast.LENGTH_SHORT).show();
                }
                else{
                    Bundle result=new Bundle();
                    result.putString("text",t);
                    getParentFragmentManager().setFragmentResult("requestAdd",result);
                    text.setText("");
                    result.clear();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String x="delete";
                Bundle res=new Bundle();
                res.putString("delkey",x);
                getParentFragmentManager().setFragmentResult("requestDel",res);
                res.clear();

            }
        });
        return view;
    }
}
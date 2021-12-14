package com.example.task2.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2.R;
import com.example.task2.model.Mymodel;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.viewholder> {
public ArrayList<Mymodel> mylist;
public ArrayList<Mymodel> checked=new ArrayList<>();
public RecycleAdapter(ArrayList<Mymodel> mylist){
    this.mylist=mylist;
}

    @Override
    public viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recycle_resource,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
       holder.checkBox.setText(mylist.get(position).getText());
       holder.checkBox.setChecked(false);

  }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public List<Mymodel> getChecked() {
        return checked;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkBox01);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(checkBox.isChecked()){
                        checked.add(mylist.get(getAdapterPosition()));
                    }
                    else{
                        checked.remove(mylist.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}

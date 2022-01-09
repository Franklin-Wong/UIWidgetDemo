package com.integrate.uiwidgetdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShortcutBottomSheet extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);

        handleList(view);
        return view;
    }

    private void handleList(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()),DividerItemDecoration.VERTICAL));
        MyRecyclerAdapter adapter = new MyRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setData(getDatas());
        adapter.notifyDataSetChanged();
    }

    private List<String> getDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ;i<30 ;i++) {
            list.add("android："+i);
        }
        return list;
    }

    public static class MyRecyclerAdapter extends RecyclerView.Adapter{

        private List<String> mData ;

        public void setData(List<String> list) {
            mData = list ;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_item,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
//            myViewHolder.index.setText(mData.get(position)+"");
            myViewHolder.name.setText(mData.get(position)+"");
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 :mData.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            private TextView name ;
            private TextView index ;
            public MyViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_name);
//                index = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_index);
            }
        }
    }
}

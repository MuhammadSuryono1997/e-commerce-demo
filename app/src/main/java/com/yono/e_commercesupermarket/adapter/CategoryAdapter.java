package com.yono.e_commercesupermarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.e_commercesupermarket.databinding.ItemCategoryBinding;
import com.yono.e_commercesupermarket.response.CategoryResponse;

import java.util.ArrayList;

import com.yono.e_commercesupermarket.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private ArrayList<CategoryResponse> categoryResponseArrayList;
    Context context;

    public void setCategoryAdapter(Context context, ArrayList<CategoryResponse> categoryResponses){
        this.categoryResponseArrayList = categoryResponses;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_category,
                parent,
                false
        );

        return new MyViewHolder(itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        holder.binData(categoryResponseArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryResponseArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding itemCategoryBinding;
        public MyViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.itemCategoryBinding = binding;
        }

        public void binData(CategoryResponse categoryResponse){
            itemCategoryBinding.setCategory(categoryResponse);
            itemCategoryBinding.setImages(categoryResponse.getUrlImagesProduct());
        }
    }
}

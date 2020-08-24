package com.yono.e_commercesupermarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.e_commercesupermarket.R;
import com.yono.e_commercesupermarket.databinding.ItemProductBinding;
import com.yono.e_commercesupermarket.response.ProductResponse;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class ProductHomeAdapter extends RecyclerView.Adapter<ProductHomeAdapter.MyViewHolder> {

    private ArrayList<ProductResponse> productResponses;
    Context context;

    public void setProductHomeAdapter(Context context, ArrayList<ProductResponse> productResponses){
        this.productResponses = productResponses;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductHomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding itemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_product,
                parent,
                false
        );
        return new MyViewHolder(itemProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHomeAdapter.MyViewHolder holder, int position) {
        holder.binData(productResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return productResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding itemProductBinding;
        public MyViewHolder(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
            this.itemProductBinding = itemView;
        }

        public void binData(ProductResponse productResponse){
            itemProductBinding.setProduct(productResponse);

            DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols format = new DecimalFormatSymbols();

            format.setCurrencySymbol("$. ");
            format.setMonetaryDecimalSeparator(',');
            format.setGroupingSeparator('.');

            rupiah.setDecimalFormatSymbols(format);

            itemProductBinding.setPrice(rupiah.format(productResponse.getPriceProduct()));
            if (productResponse.getDiscountProduct() != 0){
                itemProductBinding.tvDiscount.setVisibility(View.VISIBLE);
                itemProductBinding.setDiscount(productResponse.getDiscountProduct()+"%");
            }else{
                itemProductBinding.tvDiscount.setVisibility(View.GONE);
            }

        }
    }
}

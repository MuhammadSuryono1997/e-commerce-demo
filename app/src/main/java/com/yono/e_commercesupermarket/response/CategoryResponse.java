package com.yono.e_commercesupermarket.response;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.yono.e_commercesupermarket.R;

public class CategoryResponse {
    @SerializedName("category")
    private String categoryProduct;

    @SerializedName("images")
    private String urlImagesProduct;

    public CategoryResponse(String categoryProduct, String urlImagesProduct) {
        this.categoryProduct = categoryProduct;
        this.urlImagesProduct = urlImagesProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getUrlImagesProduct() {
        return urlImagesProduct;
    }

    public void setUrlImagesProduct(String urlImagesProduct) {
        this.urlImagesProduct = urlImagesProduct;
    }

    @BindingAdapter("imagesCategory")
    public static void loadImage(ImageView view, String urlImagesProduct){
        if (urlImagesProduct.isEmpty()){
            Glide.with(view.getContext()).load(R.drawable.logo).into(view);
        }
    }
}

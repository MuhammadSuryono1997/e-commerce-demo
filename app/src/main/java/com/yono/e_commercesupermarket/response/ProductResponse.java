package com.yono.e_commercesupermarket.response;

import com.google.gson.annotations.SerializedName;

public class ProductResponse {
    @SerializedName("title")
    private String titleProduct;

    @SerializedName("price")
    private int priceProduct;

    @SerializedName("images")
    private String imagesProduct;

    @SerializedName("discount")
    private int discountProduct;

    public ProductResponse(String titleProduct, int priceProduct, String imagesProduct, int discountProduct) {
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
        this.imagesProduct = imagesProduct;
        this.discountProduct = discountProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getImagesProduct() {
        return imagesProduct;
    }

    public void setImagesProduct(String imagesProduct) {
        this.imagesProduct = imagesProduct;
    }

    public int getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(int discountProduct) {
        this.discountProduct = discountProduct;
    }
}

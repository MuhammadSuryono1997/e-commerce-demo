package com.yono.e_commercesupermarket.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yono.e_commercesupermarket.response.CategoryResponse;
import com.yono.e_commercesupermarket.response.ProductResponse;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<CategoryResponse>> categoryResponse;
    private ArrayList<CategoryResponse> categoryResponseArrayList;
    private ArrayList<ProductResponse> productResponseArrayList;
    private MutableLiveData<ArrayList<ProductResponse>> productResponse;

    public HomeViewModel() {
        categoryResponse = new MutableLiveData<>();
        productResponse = new MutableLiveData<>();
        init();
        initProduct();
    }


    public LiveData<ArrayList<CategoryResponse>> getCategory() {
        return categoryResponse;
    }

    public LiveData<ArrayList<ProductResponse>> getProduct(){
        return productResponse;
    }

    private void init() {
        categoryResponseArrayList = new ArrayList<>();

        categoryResponseArrayList.add(new CategoryResponse(
           "Food and Drink",
           ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponseArrayList.add(new CategoryResponse(
                "Food and Drink",
                ""
        ));

        categoryResponse.setValue(categoryResponseArrayList);
    }


    private void initProduct() {
        productResponseArrayList = new ArrayList<>();
        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                10
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                20
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                10
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                20
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                0
        ));

        productResponseArrayList.add(new ProductResponse(
                "Product Name",
                90000,
                "",
                10
        ));

        productResponse.setValue(productResponseArrayList);
    }

}
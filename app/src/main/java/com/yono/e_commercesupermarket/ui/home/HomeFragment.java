package com.yono.e_commercesupermarket.ui.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yono.e_commercesupermarket.MainActivity;
import com.yono.e_commercesupermarket.NetworkChecker;
import com.yono.e_commercesupermarket.R;
import com.yono.e_commercesupermarket.adapter.CategoryAdapter;
import com.yono.e_commercesupermarket.adapter.ProductHomeAdapter;
import com.yono.e_commercesupermarket.databinding.FragmentHomeBinding;
import com.yono.e_commercesupermarket.response.CategoryResponse;
import com.yono.e_commercesupermarket.response.ProductResponse;
import com.yono.e_commercesupermarket.utils.Utils;

import org.imaginativeworld.whynotimagecarousel.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.CarouselType;
import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageCarousel carousel;
    private View root;
    private FragmentHomeBinding binding;
    private CategoryAdapter categoryAdapter;
    private ProductHomeAdapter productHomeAdapter;
    private NetworkChecker networkChecker = new NetworkChecker();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        root = binding.getRoot();
        categoryAdapter = new CategoryAdapter();
        productHomeAdapter = new ProductHomeAdapter();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getActivity().getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            AppBarConfiguration appBarConfiguration;
//            w.getDecorView().setSystemUiVisibility(root.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        LifecycleOwner lifecycleOwner = this;
        homeViewModel.getCategory().observe(lifecycleOwner, updateDataListCategory);
        homeViewModel.getProduct().observe(lifecycleOwner, updateDataListProduct);
        Log.d("Create ac", "cr");
        setCarousel();
        return root;
    }

    Observer<ArrayList<CategoryResponse>> updateDataListCategory = new Observer<ArrayList<CategoryResponse>>() {
        @Override
        public void onChanged(ArrayList<CategoryResponse> categoryResponses) {
            categoryAdapter.setCategoryAdapter(root.getContext(), categoryResponses);
            binding.rvCategory.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));
            binding.rvCategory.setAdapter(categoryAdapter);
            String js = new Gson().toJson(categoryResponses);
            Log.i("Get Data Category", "Response :"+js);
        }
    };

    Observer<ArrayList<ProductResponse>> updateDataListProduct = new Observer<ArrayList<ProductResponse>>() {
        @Override
        public void onChanged(ArrayList<ProductResponse> productResponses) {
            productHomeAdapter.setProductHomeAdapter(root.getContext(), productResponses);
            binding.rvProduct.setLayoutManager(new GridLayoutManager(root.getContext(), 3));
            binding.rvProduct.setAdapter(productHomeAdapter);
            String js = new Gson().toJson(productResponses);
            Log.i("Get Data Product", "Response :"+js);
        }
    };


    private void setCarousel() {
        carousel = root.findViewById(R.id.carousel);

        List<CarouselItem> carousels = new ArrayList<>();

        String imageUrl;
        String caption;

        carousels.add(new CarouselItem(
                imageUrl = "https://i1.wp.com/indonesiago.digital/wp-content/uploads/2018/02/BUKA-LAPAK.jpg?fit=792%2C453&ssl=1",
                caption = "Photo by Aaron Wu on Unsplash"
        ));

        carousels.add(
                new CarouselItem(
                        imageUrl = "https://pluginongkoskirim.com/wp-content/uploads/2020/06/jualan-di-bukalapak.png",
                        caption = "Photo by Johannes Plenio on Unsplash"
                )
        );

        carousel.addData(carousels);

        carousel.setShowTopShadow(true);
        carousel.setTopShadowAlpha(0.2f); // 0 to 1, 1 means 100%

        carousel.setShowBottomShadow(true);
        carousel.setBottomShadowAlpha(0.1f); // 0 to 1, 1 means 100%

        carousel.setShowCaption(true);
        carousel.setShowIndicator(true);
        carousel.setShowNavigationButtons(true);
        carousel.setImageScaleType(ImageView.ScaleType.CENTER);
        carousel.setCarouselBackground(new ColorDrawable(Color.parseColor("#333333")));
        carousel.setImagePlaceholder(ContextCompat.getDrawable(
                root.getContext(),
                R.drawable.ic_picture
        ));
        carousel.setCarouselType(CarouselType.SHOWCASE);

        carousel.setAutoWidthFixing(true);

        carousel.setAutoPlay(true);
        carousel.setAutoPlayDelay(5000);// Milliseconds

        carousel.start();
    }

}
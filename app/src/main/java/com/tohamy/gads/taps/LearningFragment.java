package com.tohamy.gads.taps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.tohamy.gads.Model.Hours;
import com.tohamy.gads.R;
import com.tohamy.gads.adapter.HoursAdapter;
import com.tohamy.gads.data.Common;
import com.tohamy.gads.data.UserInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearningFragment  extends Fragment  {
    RecyclerView recyclerView;
    HoursAdapter adapter;
    LottieAnimationView loadView;

    public static LearningFragment getInstance(){
        return new LearningFragment();
    }

   // ProgressBar progressBar;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learningleaders_tap , container , false);
        recyclerView = (RecyclerView)view.findViewById(R.id.learningLeadersrec);
       // progressBar = (ProgressBar)view.findViewById(R.id.loading);
        loadView = view.findViewById(R.id.googleLoad);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        adapter = new HoursAdapter();
        getAllLearningleaders ();
        return view;





    }



    public void getAllLearningleaders (){

     //   progressBar.setVisibility(View.VISIBLE);
        loadView.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Common.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInterface userInterface = retrofit.create(UserInterface.class);

        Call<List<Hours>> hourList = userInterface.getAllLeadersHours();

        hourList.enqueue(new Callback<List<Hours>>() {
            @Override
            public void onResponse(Call<List<Hours>> call, Response<List<Hours>> response) {
                if (response.isSuccessful()){
                    List<Hours> HList = response.body();
                    adapter.setHours(HList);
                    recyclerView.setAdapter(adapter);
                    loadView.setVisibility(View.INVISIBLE);

                }





            }

            @Override
            public void onFailure(Call<List<Hours>> call, Throwable t) {
                getAllLearningleaders ();

            }
        });

    }

}

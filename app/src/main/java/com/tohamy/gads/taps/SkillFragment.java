package com.tohamy.gads.taps;

import android.app.Activity;
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

import com.tohamy.gads.R;
import com.tohamy.gads.adapter.SkillIqAdapter;
import com.tohamy.gads.data.Common;
import com.tohamy.gads.Model.SkillIq;
import com.tohamy.gads.data.UserInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillFragment extends Fragment {
    RecyclerView recyclerView;
    SkillIqAdapter adapter;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
    }

    public static SkillFragment getInstance() {
        SkillFragment skillFragment = new SkillFragment();
        return skillFragment;
    }
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skilliq_tap, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.skillIqrec);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        adapter = new SkillIqAdapter();
        getAllLearningleaders ();
        return view;
    }






    public void getAllLearningleaders (){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Common.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInterface userInterface = retrofit.create(UserInterface.class);

        Call<List<SkillIq>> iq = userInterface.getallSqillTop();

        iq.enqueue(new Callback<List<SkillIq>>() {
            @Override
            public void onResponse(Call<List<SkillIq>> call, Response<List<SkillIq>> response) {
                if (response.isSuccessful()){
                    List<SkillIq> iqList = response.body();
                    adapter.setSkill(iqList);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<SkillIq>> call, Throwable t) {

            }
        }) ;

    }















}

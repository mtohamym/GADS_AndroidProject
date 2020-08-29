package com.tohamy.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.tohamy.gads.data.Common;
import com.tohamy.gads.data.PostApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Submit extends AppCompatActivity implements View.OnClickListener {
    Button SubmitToForm;
    ImageButton back;
    EditText name, lastName, email, githubLink;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        findId();
        SubmitToForm.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    public void findId() {
        SubmitToForm = findViewById(R.id.submitformbtn);
        back = findViewById(R.id.Backbtn);
        name = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        githubLink = findViewById(R.id.githublink);

    }


    public void postData(String name, String last, String email, String githubLink) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Common.POST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostApi postApiRetrofit = retrofit.create(PostApi.class);
        Call<ResponseBody> call = postApiRetrofit.Submit(name, last, email, githubLink);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                successDialog();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                errorDialog();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Backbtn:
                Intent open = new Intent(Submit.this, LeaderBoradActivity.class);
                startActivity(open);
                finish();
                break;
            case R.id.submitformbtn:
                validate();
                break;

        }
    }
    private void successDialog() {
        dialog = new Dialog(Submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.success_dialog);
        dialog.show();
    }

    private void validate() {
        if (!name.getText().toString().isEmpty() &&
                !lastName.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !githubLink.getText().toString().isEmpty()) {
            ShowDialog();
        } else if (name.getText().toString().isEmpty()) {
            name.setError("Required");
            name.requestFocus();
        } else if (lastName.getText().toString().isEmpty()) {
            lastName.setError("Required");
            lastName.requestFocus();
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Required");
            email.requestFocus();
        } else {
            githubLink.setError("Required");
            githubLink.requestFocus();

        }
    }
    private void errorDialog(){
        dialog = new Dialog(Submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.error_popup);
        dialog.show();
    }
    private void ShowDialog() {
        dialog = new Dialog(Submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_submit);
        Button yesbtn = dialog.findViewById(R.id.ybtn);
        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SendData();

            }
        });

        dialog.show();
    }

    private void SendData() {
        postData(name.getText().toString() ,
                lastName.getText().toString(),
                email.getText().toString(),
                githubLink.getText().toString());
    }

}
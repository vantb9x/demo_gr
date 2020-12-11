package com.example.demo_grab;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewmodel.MainActivityViewModel;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    Button mButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new MainActivityViewModel(this);
//        binding.setVm(viewModel);

        mButtonAdd = findViewById(R.id.btnClickEvent);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // do something here
                viewModel.startLoginFlow();

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String action = intent.getAction();
//        String redirectUrl = intent.getDataString();
        String redirectUrl = "fahasaapp://";
        if (Intent.ACTION_VIEW == action && redirectUrl != null) {
            viewModel.setRedirectUrl(redirectUrl);
            // initiate the token exchange with GRAB ID Partner SDK
            viewModel.getToken();
        }
    }



}

package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class logoActivity extends AppCompatActivity {
    final String TAG = "AnimationTest";
    FrameLayout mFrame;
    ImageView mRocket;
    ImageView mCountDown;
    int mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        mFrame = (FrameLayout) findViewById(R.id.activity_logo);
        mCountDown = (ImageView) findViewById(R.id.countdown);
        mRocket = (ImageView) findViewById(R.id.logo);
    }

    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;


        startCountDownFrameAnimation();

        startlogoTweenAnimation();

    }

    private void startCountDownFrameAnimation() {
        mCountDown.setBackgroundResource(R.drawable.frame_anim);
        AnimationDrawable countdownAnim = (AnimationDrawable) mCountDown.getBackground();
        countdownAnim.start();
    }


    private void startlogoTweenAnimation() {
        Animation logo_anim = AnimationUtils.loadAnimation(this, R.anim.logo);
        mRocket.startAnimation(logo_anim);
        logo_anim.setAnimationListener(animationListener);
    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.i(TAG, "onAnimationEnd");
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.i(TAG, "onAnimationRepeat");
        }


    };

}



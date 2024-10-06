package com.example.practice_f;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn11,btn2,btn22,  btn3,btn33, btn4,btn44;
ImageView img1,img11;
Animation myAnim;
int i1 = 0;
int i2 = 0;

LottieAnimationView lanim, lanim1;
int ai1 = 0;
int ai2 = 0;

String[] aurl = {"https://lottie.host/a5880b33-c2b9-42d4-bce8-1107864fc622/FGqGT2i6sD.json",
                "https://lottie.host/5bad71ea-5410-45ac-aa0a-55d2dc77ad3a/jKeiyEzXZl.json",
                "https://lottie.host/cd1be01c-dda1-493c-880a-1690ff0c900d/OszDusBNRc.json"
};

String[] aurl2 = {"https://lottie.host/a5880b33-c2b9-42d4-bce8-1107864fc622/FGqGT2i6sD.json",
        "https://lottie.host/5bad71ea-5410-45ac-aa0a-55d2dc77ad3a/jKeiyEzXZl.json",
        "https://lottie.host/cd1be01c-dda1-493c-880a-1690ff0c900d/OszDusBNRc.json"
};

String[] urls = {
        "https://img.freepik.com/free-photo/halloween-scene-illustration-anime-style_23-2151794318.jpg",
        "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499089.jpg",
        "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499075.jpg",
        "https://img.freepik.com/free-photo/mythical-dragon-beast-anime-style_23-2151112840.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112760.jpg",
        "https://img.freepik.com/free-photo/anime-moon-landscape_23-2151645896.jpg",
        "https://img.freepik.com/free-photo/mythical-dragon-beast-anime-style_23-2151112842.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112867.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112870.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112767.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112848.jpg",
};
String[] urls1 = {
            "https://img.freepik.com/free-photo/halloween-scene-illustration-anime-style_23-2151794318.jpg",
            "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499089.jpg",
            "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499075.jpg",
            "https://img.freepik.com/free-photo/mythical-dragon-beast-anime-style_23-2151112840.jpg",
            "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112760.jpg",
            "https://img.freepik.com/free-photo/anime-moon-landscape_23-2151645896.jpg",
            "https://img.freepik.com/free-photo/mythical-dragon-beast-anime-style_23-2151112842.jpg",
            "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112867.jpg",
            "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112870.jpg",
            "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112767.jpg",
            "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112848.jpg",
};
  private   InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, initializationStatus -> {});

    // Initialize the ad container view
        LinearLayout adContainerView = findViewById(R.id.adContainerView);

    // Create a new ad view and set the ad unit ID and size
        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-3940256099942544/9214589741"); // Test Ad Unit ID
        adView.setAdSize(AdSize.BANNER);

    // Add the ad view to the container and load the ad
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

    // Start loading the ad
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(MainActivity.this, "Ad Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(MainActivity.this, "Ad Loaded", Toast.LENGTH_SHORT).show();
            }
        });

        //fullscreen
        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn1 = findViewById(R.id.btn1);
        btn11 = findViewById(R.id.btn11);
        img1 = findViewById(R.id.img1);

        btn2 = findViewById(R.id.btn2);
        btn22 = findViewById(R.id.btn22);
        img11 = findViewById(R.id.img11);

        btn3 = findViewById(R.id.btn3);
        btn33 = findViewById(R.id.btn33);
        btn4 = findViewById(R.id.btn4);
        btn44 = findViewById(R.id.btn44);

        lanim = findViewById(R.id.lanim);
        lanim1 = findViewById(R.id.lanim1);



        myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_in);
        Picasso.get().load(urls[i1]).into(img1);
        Picasso.get().load(urls1[i2]).into(img11);

        //--------------IMAGE PICASSO--------------//

        Picasso.get().load(urls[i1]).into(img1);
        Picasso.get().load(urls1[i2]).into(img11);

        // Handlers for img1
        btn1.setOnClickListener(view -> {
            if (i1 > 0) {
                i1--;
            } else {
                i1 = urls.length - 1;
            }
            Picasso.get().load(urls[i1]).into(img1);
            img1.startAnimation(myAnim);
        });

        btn2.setOnClickListener(view -> {
            if (i1 < urls.length - 1) {
                i1++;
            } else {
                i1 = 0;
            }
            Picasso.get().load(urls[i1]).into(img1);
            img1.startAnimation(myAnim);

            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        });

        // Handlers for img11
        btn11.setOnClickListener(view -> {
            if (i2 > 0) {
                i2--;
            } else {
                i2 = urls1.length - 1;
            }
            Picasso.get().load(urls1[i2]).into(img11);
            img11.startAnimation(myAnim);
        });

        btn22.setOnClickListener(view -> {
            if (i2 < urls1.length - 1) {
                i2++;
            } else {
                i2 = 0;
            }
            Picasso.get().load(urls1[i2]).into(img11);
            img11.startAnimation(myAnim);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        });


        //-------------ANIMATION LOTTIE----------------//
        btn3.setOnClickListener(view -> {
            if (ai1 > 0){
                ai1--;
            } else {
                ai1 = aurl.length -1;
            }
            lanim.setAnimationFromUrl(aurl[ai1]);
            lanim.playAnimation();
            lanim.loop(true);
        });

        btn33.setOnClickListener(view -> {
            if (ai1 < aurl.length-1 ){
                ai1++;
            } else {
                ai1 = 0;
            }
            lanim.setAnimationFromUrl(aurl[ai1]);
            lanim.playAnimation();
            lanim.loop(true);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        });

        btn4.setOnClickListener(view -> {
            if (ai2 > 0){
                ai2--;
            } else {
                ai2 = aurl2.length -1;
            }
            lanim1.setAnimationFromUrl(aurl2[ai2]);
            lanim1.playAnimation();
            lanim1.loop(true);
        });

        btn44.setOnClickListener(view -> {
            if (ai2 < aurl2.length-1 ){
                ai2 ++;
            } else {
                ai2 = 0;
            }
            lanim1.setAnimationFromUrl(aurl2[ai2]);
            lanim1.playAnimation();
            lanim1.loop(true);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        });


    }
}
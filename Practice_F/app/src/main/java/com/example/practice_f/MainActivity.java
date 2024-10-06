package com.example.practice_f;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn11,btn2,btn22,  btn3,btn33;
ImageView img1,img11,  img2,img22;
Animation myAnim;
int i = 0;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
        img2 = findViewById(R.id.img2);

        btn33 = findViewById(R.id.btn33);
        img22 = findViewById(R.id.img22);


        myAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_in);
        Picasso.get().load(urls[i]).into(img1);
        Picasso.get().load(urls1[i]).into(img11);

        //--------------IMAGE PICASSO--------------//
        btn1.setOnClickListener(view -> {
            if (i < urls.length -1){
                i++;
            }else {
                i = 0;
            }
            Picasso.get().load(urls[i]).into(img1);
            img1.startAnimation(myAnim);
        });

        btn11.setOnClickListener(view -> {
            if (0 <i ){
                i--;
            }else {
                i = urls.length -1;
            }
            Picasso.get().load(urls[i]).into(img1);
            img1.startAnimation(myAnim);
        });

        btn2.setOnClickListener(view -> {
            if (i < urls.length -1){
                i++;
            }else {
                i = 0;
            }
            Picasso.get().load(urls1[i]).into(img1);
            img1.startAnimation(myAnim);
        });

        btn22.setOnClickListener(view -> {
            if (0 <i ){
                i--;
            }else {
                i = urls.length -1;
            }
            Picasso.get().load(urls1[i]).into(img1);
            img1.startAnimation(myAnim);
        });


        //-------------ANIMATION LOTTIE----------------//
        btn3.setOnClickListener(view -> {
            img2.
        });

        btn33.setOnClickListener(view -> {

        });


    }
}
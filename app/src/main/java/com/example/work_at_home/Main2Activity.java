package com.example.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Main2Activity extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int images[] = {R.drawable.zcc, R.drawable.xcv, R.drawable.hjk};
        viewFlipper = findViewById(R.id.v_flipper);
        //for(int i=0; i<images.length ; i++){
     /*   flipperImages(images[i]);
    }*/
        for (int image : images) {
            flipperImages(image);
        }
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);

    }

    public void signins(View view) {
        startActivity(new Intent(Main2Activity.this, Log_in.class));
        Animatoo.animateSwipeLeft(this);
    }

    public void signups(View view) {
        finish();
        startActivity( new Intent(Main2Activity.this, Login.class));
        Animatoo.animateSlideUp(this);

    }
    public void onBackPressed() {
     moveTaskToBack(true);
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }

    public void serv(View view) {
        startActivity( new Intent(Main2Activity.this, Avaliable_Devices.class));
        Animatoo.animateSlideUp(this);
    }

    public void seller(View view) {
        startActivity(new Intent(Main2Activity.this, sellers.class));
        Animatoo.animateSlideUp(this);
    }
}

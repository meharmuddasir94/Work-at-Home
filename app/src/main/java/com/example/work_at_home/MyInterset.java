package com.example.work_at_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MyInterset extends AppCompatActivity {
    Button btn;
    TextView email;
    ScrollView sl;
    LinearLayout log,logni,buss,trafi,social,shirt,voc,seo,photos,blogs,word,illus,mob,crat,arts,wess,resume,video,mus,otrs;
    int i = 0;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore objectFirebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interset);
        firebaseAuth = FirebaseAuth.getInstance();
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
                btn=findViewById(R.id.btnss );
                sl=findViewById(R.id.slv);
                sl.setSmoothScrollingEnabled(true);
                log=findViewById(R.id.log);
                logni=findViewById(R.id.logni);
                email=findViewById(R.id.random);
                buss=findViewById(R.id.buss);
                trafi=findViewById(R.id.trafi);
                social=findViewById(R.id.social);
                voc=findViewById(R.id.voc);
                shirt=findViewById(R.id.shirt);
                otrs=findViewById(R.id.otrs);
                seo=findViewById(R.id.seo);
                photos=findViewById(R.id.photos);
                blogs=findViewById(R.id.blogs);
                word=findViewById(R.id.word);
                mus=findViewById(R.id.mus);
                illus=findViewById(R.id.illus);
                mob=findViewById(R.id.mob);
                crat=findViewById(R.id.crat);
                wess=findViewById(R.id.wess);
                arts=findViewById(R.id.arts);
                video=findViewById(R.id.video);
                resume=findViewById(R.id.resume);
            }

            public void dropdown(View view) {
                onBackPressed();
                Animatoo.animateSlideRight(this);

            }

            public void logo(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            log.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.logod;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            logni.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);

                        }else if(i==2){

                            log.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            log.setBackground(highlight);
                            logni.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);
                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }

            public void glogs(View view) {

onBackPressed();
            }

            public void logoani(View view){
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            logni.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.logoA;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            logni.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            logni.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void bus(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            buss.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.busc;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            logni.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            buss.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            buss.setBackground(highlight);
                            log.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);
                            logni.setClickable(true);
                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void traf(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            trafi.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.traf;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            logni.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            trafi.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            trafi.setBackground(highlight);
                            log.setClickable(true);
                            logni.setClickable(true);
                            buss.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void media(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            social.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.soc;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            logni.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            social.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            social.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            logni.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void shir(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            shirt.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.tshir;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            logni.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            shirt.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            shirt.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            logni.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void voic(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            voc.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.voice;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            logni.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            voc.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            voc.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            logni.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void seos(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            seo.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.seo;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            logni.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            seo.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            seo.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            logni.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void phot(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            photos.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.photo;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            logni.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            photos.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            photos.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            logni.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void blogss(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            blogs.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.artic;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            logni.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            blogs.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            blogs.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            logni.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void prees(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            word.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.word;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            logni.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            word.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            word.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            logni.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void ills(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            illus.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.ill;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            logni.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            illus.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            illus.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            logni.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);
                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void mobi(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            mob.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.mob;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            logni.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            mob.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            mob.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            logni.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void cret(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            crat.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.cra;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            logni.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            crat.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            crat.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            logni.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void art(View view){
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            arts.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.inte;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            logni.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            arts.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            arts.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            logni.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void webs(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            wess.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.websd;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            logni.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            wess.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            wess.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            logni.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void vid(View view){
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            video.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.vid;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            logni.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            video.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            video.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            logni.setClickable(true);
                            resume.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void resu(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            resume.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.res;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            logni.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            resume.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            resume.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            logni.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void musi(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            mus.setBackground(highlight);
                            btn.setText("Continue");
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            logni.setClickable(false);
                            otrs.setClickable(false);
                        }else if(i==2){

                            mus.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            mus.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            logni.setClickable(true);
                            otrs.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }


            public void oth(View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            Drawable highlight = getResources().getDrawable( R.drawable.outline);
                            otrs.setBackground(highlight);
                            btn.setText("Save");
                            int d=R.string.other;
                            String f= Integer.toString(d) ;
                            pickinterest(f);
                            log.setClickable(false);
                            buss.setClickable(false);
                            trafi.setClickable(false);
                            social.setClickable(false);
                            shirt.setClickable(false);
                            voc.setClickable(false);
                            seo.setClickable(false);
                            photos.setClickable(false);
                            blogs.setClickable(false);
                            word.setClickable(false);
                            illus.setClickable(false);
                            mob.setClickable(false);
                            crat.setClickable(false);
                            arts.setClickable(false);
                            wess.setClickable(false);
                            resume.setClickable(false);
                            video.setClickable(false);
                            mus.setClickable(false);
                            logni.setClickable(false);
                        }else if(i==2){

                            otrs.setBackgroundColor(0);
                            Drawable highlight = getResources().getDrawable( R.drawable.border);
                            otrs.setBackground(highlight);
                            log.setClickable(true);
                            buss.setClickable(true);
                            trafi.setClickable(true);
                            social.setClickable(true);
                            shirt.setClickable(true);
                            voc.setClickable(true);
                            seo.setClickable(true);
                            photos.setClickable(true);
                            blogs.setClickable(true);
                            word.setClickable(true);
                            illus.setClickable(true);
                            mob.setClickable(true);
                            crat.setClickable(true);
                            arts.setClickable(true);
                            wess.setClickable(true);
                            resume.setClickable(true);
                            video.setClickable(true);
                            mus.setClickable(true);
                            logni.setClickable(true);

                            btn.setText("Continue");
                            i=0;

                        }

                    }
                },500);
            }
public void pickinterest(String s){
    try {
        if(firebaseAuth != null){
            String i =firebaseAuth.getCurrentUser().getEmail();
            email.setText(i);
        }
            Map<String, String> objectMap = new HashMap<>();
            objectMap.put("Category",s);
            objectMap.put("email",email.getText().toString());

            objectFirebaseFirestore.collection("Interest")
                    .document(email.getText().toString())
                    .set(objectMap)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {


                            Toast.makeText(MyInterset.this, "Automatically logging in ", Toast.LENGTH_SHORT).show();




                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MyInterset.this, "F", Toast.LENGTH_SHORT).show();
                        }
                    });

    } catch (Exception e) {
        Toast.makeText(MyInterset.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}

}
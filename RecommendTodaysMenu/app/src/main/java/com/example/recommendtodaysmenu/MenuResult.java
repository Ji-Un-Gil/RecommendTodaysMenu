package com.example.recommendtodaysmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuResult extends AppCompatActivity {

    String[] text_if_cold = new String[] {"국밥", "덮밥", "라멘", "국수", "자장면", "짬뽕",
            "리조또", "라면", "수제비", "만두", "떡볶이", "돈가스", "치킨"};
    int[] images_if_cold = new int[] {R.drawable.googbap, R.drawable.deopbap, R.drawable.ramen,
            R.drawable.noodle, R.drawable.jajangmyun, R.drawable.jjambbong, R.drawable.risotto,
            R.drawable.ramyun, R.drawable.sujebi, R.drawable.dumpling, R.drawable.ddeokboki,
            R.drawable.porkcutlet, R.drawable.chicken};

    String[] text_if_hot = new String[] {"비빔밥", "초밥", "파스타", "족발", "보쌈", "빵", "냉면", "모밀"};
    int[] images_if_hot = new int[] {R.drawable.bibimbap, R.drawable.sushi, R.drawable.pasta,
            R.drawable.porkfeet, R.drawable.bossam, R.drawable.bread,
            R.drawable.coldnoodle, R.drawable.buckwheat};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        Intent intent = getIntent();
        float temperature = intent.getFloatExtra("온도", 10.0F);
        int randomId;

        if (temperature >= 10.0F){
            randomId = (int)(Math.random() * images_if_hot.length);

            TextView textView = (TextView) findViewById(R.id.result);
            textView.setText("오늘의 메뉴 추천은 " + text_if_hot[randomId] + "입니다!");

            ImageView imageView = (ImageView) findViewById(R.id.result_image);
            imageView.setImageResource(images_if_hot[randomId]);
        }
        else{
            randomId = (int)(Math.random() * images_if_cold.length);

            TextView textView = (TextView) findViewById(R.id.result);
            textView.setText("오늘의 메뉴 추천은 " + text_if_cold[randomId] + "입니다!");

            ImageView imageView = (ImageView) findViewById(R.id.result_image);
            imageView.setImageResource(images_if_cold[randomId]);
        }

        Button restart_button = (Button) findViewById(R.id.restart_button);
        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

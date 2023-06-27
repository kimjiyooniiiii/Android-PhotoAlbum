package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    ImageView imageView;
    EditText editText;

    String imgArray[] = {"0", "img1", "img2", "img3", "img4", "img5", "img6", "img7", "img8", "img9", "img10", "img11",
            "img12", "img13", "img14", "img15", "img16", "img17", "img18", "img19", "img20", "img21", "img22",
            "img23", "img24", "img25", "img26", "img27", "img28", "img29", "img30"};

    int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName6);
        imageView = findViewById(R.id.imageView);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setHorizontalScrollBarEnabled(true);

        imageChange(imgArray[1], 1);                   // 첫화면 이미지


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {       // 이전 버튼
            @Override
            public void onClick(View view) {
                if(current <= 1){
                    Toast.makeText(getApplicationContext(), "사진은 1~30까지만 있습니다.", Toast.LENGTH_LONG).show();
                }
                else{
                    imageChange(imgArray[current - 1], current - 1);

                }
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {      // 다음 버튼
            @Override
            public void onClick(View view) {
                if(current >= 30){
                    Toast.makeText(getApplicationContext(), "사진은 1~30까지만 있습니다.", Toast.LENGTH_LONG).show();
                }
                else{
                    imageChange(imgArray[current + 1], current + 1);

                }
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {              // 원하는 페이지 입력
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView != null){
                    float editNum = Float.parseFloat(textView.getText().toString());

                    if(editNum < 1){
                        Toast.makeText(getApplicationContext(), "사진은 1~30까지만 있습니다.", Toast.LENGTH_LONG).show();
                        imageChange(imgArray[1], 1);

                    }
                    if(editNum > 30){
                        Toast.makeText(getApplicationContext(), "사진은 1~30까지만 있습니다.", Toast.LENGTH_LONG).show();
                        imageChange(imgArray[30], 30);

                    }
                    else{
                        imageChange(imgArray[Math.round(editNum)], Math.round(editNum));
                    }
                }
                return true;
            }
        });
    }

    public void imageChange(String img, int imgIndex){                         // 사진 변환 메소드

        int resources = getResources().getIdentifier(img,"drawable",getPackageName());
        imageView.setImageResource(resources);

        current = imgIndex;
        editText.setText(Integer.toString(imgIndex));
    }
}
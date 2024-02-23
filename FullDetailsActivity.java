package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FullDetailsActivity extends AppCompatActivity {

    ImageView imgBackArr;
    LottieAnimationView animationClimate;
    TextView tvDegreeClimate,tvSunRise,tvSunSet,tvHumidity,tvWind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);
        tvSunRise=findViewById(R.id.tvSunRise);
        tvSunSet=findViewById(R.id.tvSunSet);
        imgBackArr=findViewById(R.id.imgBackArr);
        tvHumidity=findViewById(R.id.tvHumidity);
        tvWind=findViewById(R.id.tvWindSpeed);


        imgBackArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FullDetailsActivity.this,com.example.apitest.SearchPage.class));
                finish();
            }
        });
        int humidity=getIntent().getIntExtra("humidity",0);
        double windspeed=getIntent().getDoubleExtra("wind",0);
        tvHumidity.setText("Humidity:"+humidity+"%");
        tvWind.setText("Speed:"+windspeed+"m/s");
        long sunrise = getIntent().getLongExtra("sunrise",0);
        long sunset= getIntent().getLongExtra("sunset",0);
        Date sunriseDate=new Date(sunrise* 1000L);
        Date sunsetDate=new Date(sunset* 1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String sunriseTime=sdf.format(sunriseDate);
        String sunsetTime=sdf.format(sunsetDate);
        tvSunRise.setText("Dawn:"+sunriseTime);
        tvSunSet.setText("Dusk:"+sunsetTime);
        String climateCondition=getIntent().getStringExtra("climate");
        int degree=getIntent().getIntExtra("temp",0);
        RequestQueue queue= Volley.newRequestQueue(this);
        animationClimate=findViewById(R.id.animationClimate);
        tvDegreeClimate=findViewById(R.id.tvDegreeClimate);
        //General url structure => https://api.openweathermap.org/data/2.5/weather?q=tirupur&appid=a44a501bfabe1c2865c7599c0d45d01b
        if(climateCondition.equals("cold")){
            animationClimate.setAnimation(R.raw.cold);
            tvDegreeClimate.setText(degree+"˚C"+"/"+climateCondition);
        }

        else if(climateCondition.equals("warm")){
            animationClimate.setAnimation(R.raw.warm);
            tvDegreeClimate.setText(degree+"˚C"+"/"+climateCondition);
        }

        else if(climateCondition.equals("mild")){
            animationClimate.setAnimation(R.raw.mild);
            tvDegreeClimate.setText(degree+"˚C"+"/"+climateCondition);
        }
        else if(climateCondition.equals("hot")){
            animationClimate.setAnimation(R.raw.hot);
            tvDegreeClimate.setText(degree+"˚C"+"/"+climateCondition);
        }

    }

    public String climateRange(int temp){
        if(temp<10.0)
            return "cold";
        else if (temp>=10.0 && temp<20.0)
            return "mild";
        else if (temp>=20.0 && temp<30.0)
            return "warm";
        else if (temp>=30.0)
            return "hot";
        else
            return "";
    }
}
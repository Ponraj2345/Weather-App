package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
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

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity implements RecyclerInterface{
    private final String APIKEY="a44a501bfabe1c2865c7599c0d45d01b";
    private final String URL="https://api.openweathermap.org/data/2.5/weather?q=";
    RecyclerView popularCityRec;
    PopularCitiesAdapter adapter;
    ListView list;
    ArrayList<DataClassForPopular> datas;
    RequestQueue queue;
    SearchView searchBarCityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        //General url structure => https://api.openweathermap.org/data/2.5/weather?q=tirupur&appid=a44a501bfabe1c2865c7599c0d45d01b
        searchBarCityName=findViewById(R.id.searchBarCityName);
        //list=findViewById(R.id.list);
        popularCityRec=findViewById(R.id.popularCityRec);
        datas=new ArrayList<>();

        queue=Volley.newRequestQueue(this);
        JsonObjectRequest tirupur=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=tirupur&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="very cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest delhi=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=delhi&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="very cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest pollachi=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=pollachi&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="very cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest palani=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=palani&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="very cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest coimbatore=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=coimbatore&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="very cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest chennai=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=chennai&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="cold";
                    else if (temp>=20.0 && temp<25.0)
                        climateCondition="mild";
                    else if (temp>=25.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        JsonObjectRequest shimla=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q=shimla&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature=response.getJSONObject("main");
                    double temp=temperature.getDouble("temp")-273.15;
                    String cityName=response.getString("name");
                    String climateCondition="";
                    if(temp<10.0)
                        climateCondition="cold";
                    else if (temp>=10.0 && temp<20.0)
                        climateCondition="mild";
                    else if (temp>=20.0 && temp<30.0)
                        climateCondition="warm";
                    else if (temp>=30.0)
                        climateCondition="hot";
                    datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //throw new RuntimeException(e);
                    Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(palani);
        queue.add(shimla);
        queue.add(tirupur);
        queue.add(chennai);
        queue.add(coimbatore);
        queue.add(pollachi);
        queue.add(delhi);
       // ArrayAdapter adapterer=new ArrayAdapter<>(this,R.layout.popular_cities_recycler,datas);
        //list.setAdapter(adapterer);
        adapter=new PopularCitiesAdapter(datas,SearchPage.this,this);
        //adapter.notifyDataSetChanged();
        popularCityRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        popularCityRec.setAdapter(adapter);
        searchBarCityName.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                JsonObjectRequest request=new JsonObjectRequest("https://api.openweathermap.org/data/2.5/weather?q="+s+"&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject temperature=response.getJSONObject("main");
                            JSONObject sunrise=response.getJSONObject("sys");
                            JSONObject wind=response.getJSONObject("wind");
                            double windSpeed=wind.getDouble("speed");
                            int humidty=temperature.getInt("humidity");
                            long rise=sunrise.getLong("sunrise");
                            long set=sunrise.getLong("sunset");
                            int temp=(int)Math.round(temperature.getDouble("temp")-273.15);
                            String cityName=response.getString("name");
                            String climateCondition=climateRange(temp);
                            datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });
                            if(climateCondition.equals("cold")) {
                                Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                                intent.putExtra("climate",climateCondition);
                                intent.putExtra("temp",temp);
                                intent.putExtra("sunrise",rise);
                                intent.putExtra("humidity",humidty);
                                intent.putExtra("wind",windSpeed);
                                intent.putExtra("sunset",set);
                                startActivity(intent);
                            }
                            else if(climateCondition.equals("warm")) {
                                Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                                intent.putExtra("climate",climateCondition);
                                intent.putExtra("temp",temp);
                                intent.putExtra("wind",windSpeed);
                                intent.putExtra("humidity",humidty);
                                intent.putExtra("sunrise",rise);
                                intent.putExtra("sunset",set);
                                startActivity(intent);
                            }
                            else if(climateCondition.equals("mild")){
                                Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                                intent.putExtra("climate",climateCondition);
                                intent.putExtra("temp",temp);
                                intent.putExtra("wind",windSpeed);
                                intent.putExtra("humidity",humidty);
                                intent.putExtra("sunrise",rise);
                                intent.putExtra("sunset",set);
                                startActivity(intent);
                            }
                            else if(climateCondition.equals("hot")){
                                Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                                intent.putExtra("climate",climateCondition);
                                intent.putExtra("temp",temp);
                                intent.putExtra("wind",windSpeed);
                                intent.putExtra("humidity",humidty);
                                intent.putExtra("sunrise",rise);
                                intent.putExtra("sunset",set);
                                startActivity(intent);
                            }
//
                            //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            //throw new RuntimeException(e);
                            Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchPage.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(request);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
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

    @Override
    public void onCityClick(int position) {
          String cityname=datas.get(position).getCity();
          JsonObjectRequest recRec=new JsonObjectRequest(" https://api.openweathermap.org/data/2.5/weather?q=" + cityname + "&appid=a44a501bfabe1c2865c7599c0d45d01b", new Response.Listener<JSONObject>() {
              @Override
              public void onResponse(JSONObject response) {
                  try {
                      JSONObject temperature=response.getJSONObject("main");
                      JSONObject sunrise=response.getJSONObject("sys");
                      JSONObject wind=response.getJSONObject("wind");
                      double windSpeed=wind.getDouble("speed");
                      int humidty=temperature.getInt("humidity");
                      long rise=sunrise.getLong("sunrise");
                      long set=sunrise.getLong("sunset");
                      int temp=(int)Math.round(temperature.getDouble("temp")-273.15);
                      String cityName=response.getString("name");
                      String climateCondition=climateRange(temp);
                      datas.add(new DataClassForPopular(temp,cityName,climateCondition));
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              adapter.notifyDataSetChanged();
                          }
                      });
                      if(climateCondition.equals("cold")) {
                          Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                          intent.putExtra("climate",climateCondition);
                          intent.putExtra("temp",temp);
                          intent.putExtra("sunrise",rise);
                          intent.putExtra("humidity",humidty);
                          intent.putExtra("wind",windSpeed);
                          intent.putExtra("sunset",set);
                          startActivity(intent);
                      }
                      else if(climateCondition.equals("warm")) {
                          Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                          intent.putExtra("climate",climateCondition);
                          intent.putExtra("temp",temp);
                          intent.putExtra("wind",windSpeed);
                          intent.putExtra("humidity",humidty);
                          intent.putExtra("sunrise",rise);
                          intent.putExtra("sunset",set);
                          startActivity(intent);
                      }
                      else if(climateCondition.equals("mild")){
                          Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                          intent.putExtra("climate",climateCondition);
                          intent.putExtra("temp",temp);
                          intent.putExtra("wind",windSpeed);
                          intent.putExtra("humidity",humidty);
                          intent.putExtra("sunrise",rise);
                          intent.putExtra("sunset",set);
                          startActivity(intent);
                      }
                      else if(climateCondition.equals("hot")){
                          Intent intent=new Intent(SearchPage.this,com.example.apitest.FullDetailsActivity.class);
                          intent.putExtra("climate",climateCondition);
                          intent.putExtra("temp",temp);
                          intent.putExtra("wind",windSpeed);
                          intent.putExtra("humidity",humidty);
                          intent.putExtra("sunrise",rise);
                          intent.putExtra("sunset",set);
                          startActivity(intent);
                      }
//
                      //Toast.makeText(SearchPage.this, cityName, Toast.LENGTH_SHORT).show();

                  } catch (JSONException e) {
                      //throw new RuntimeException(e);
                      Toast.makeText(SearchPage.this, e.toString(), Toast.LENGTH_SHORT).show();
                  }

              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {

              }
          });
        queue.add(recRec);
    }
}
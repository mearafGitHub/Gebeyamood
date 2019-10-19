package com.example.gebeya_mood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyMoodsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @SerializedName("name")
    TextView userInfo;
    ConnectApi connectApi;
    TextView team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moods);

        userInfo = findViewById(R.id.username);
        team = findViewById(R.id.teamText);
        Spinner filterMood = findViewById(R.id.mood_filter);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterMood.setAdapter(arrayAdapter);
        filterMood.setOnItemSelectedListener(this);

        // API CONNECTION
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        connectApi = retrofit.create(ConnectApi.class);

        // Get Users from API
        getUsersCall();

        // Moods Here
        getMoodsCall();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        // send ad filter by choice to api and display result
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getUsersCall() {

        Call<List<User>> call = connectApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    userInfo.setText("result: " + response.code());
                    return;
                }
                /*============= users fetched here ===============*/
                List<User> users = response.body();
                for(User user : users){
                    String content = "";
                    content += "ID: " + user.getId() + "\n";
                    content += "Name: " + user.getUsername() + "\n";
                    content += "Email: " + user.getEmail() + "\n";
                    content += "Team: " + user.getTeam() + "\n\n";

                    userInfo.setText(content);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
    }

    private void getMoodsCall() {

        Call<List<Mood>> call = connectApi.getMoods();
        call.enqueue(new Callback<List<Mood>>() {
            @Override
            public void onResponse(Call<List<Mood>> call, Response<List<Mood>> response) {
                if(!response.isSuccessful()){
                    team.setText("result: " + response.code());
                    return;
                }
                /*============= users fetched here ===============*/
                List<Mood> moods = response.body();
                for(Mood mood : moods){
                    String content = "";
                    content += "ID: " + mood.getUserId() + "\n";
                    content += "Name: " + mood.getEmotion() + "\n";
                    content += "Email: " + mood.getDate() + "\n\n";

                    team.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Mood>> call, Throwable t) {
            }
        });
    }

}

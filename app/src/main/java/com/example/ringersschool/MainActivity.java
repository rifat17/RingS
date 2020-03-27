package com.example.ringersschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


import com.example.ringersschool.Model.Student;
import com.example.ringersschool.Model.Students;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner loginSpinner;
    Button LoginBtn, GuestBtn;
    EditText IdEdit;

    Students searchedStudent = null;


    List<Students> studentList;
    Call<List<Students>> student;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginBtn = findViewById(R.id.loginButton);
        GuestBtn = findViewById(R.id.loginGuestButton);
        loginSpinner = findViewById(R.id.login_spinner_id);
        IdEdit = findViewById(R.id.IdEditText);


        LoginBtn.setOnClickListener(this);
        GuestBtn.setOnClickListener(this);


        final List<String> AddId = new ArrayList<>();
        AddId.add("Apple");

        //Handler for Retrofit
        GetDataService service = RetrofitClientInstances.getRetrofitInstances().create(GetDataService.class);
        student = service.getAllStudents("students");


      /* final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>
               (MainActivity.this,R.layout.support_simple_spinner_dropdown_item,AddId);
       loginSpinner.setAdapter(arrayAdapter);

/*
       LoginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String ID=IdEdit.getText().toString();
               AddId.add(ID);
               IdEdit.setText("");

               if(ID.isEmpty())
               {
                   Toast.makeText(getApplicationContext(),"Please Enter your valid Id",Toast.LENGTH_SHORT).show();


               }
               else
               {

                   Intent Dash=new Intent(MainActivity.this,DashBoard.class);
                   startActivity(Dash);

               }



           }
       });


*/
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginButton:
//                sendAndRequestResponse();
                if (whenIdEditTextIsNotEmpty()) {
                    fetchUser(IdEdit.getText().toString());
                    if (searchedStudent != null) {
                        Log.d(TAG, "Enter IF");
                        Intent dashBoard = new Intent(getApplicationContext(), DashBoard.class);
                        dashBoard.putExtra("name", searchedStudent.getName());
                        dashBoard.putExtra("roll", searchedStudent.getRoll_no());
                        // dashBoard.putExtra("image",Img);
                        startActivity(dashBoard);

                        Toast.makeText(getApplicationContext(), "Welcome " + searchedStudent.getName() + "in Our School App", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                else {
                    SystemClock.sleep(1500);
                    Toast.makeText(getApplicationContext(), "Please Enter Your Valid Card Number", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.loginGuestButton:
                Intent Dash = new Intent(MainActivity.this, DashBoard.class);
                startActivity(Dash);
                break;


        }

    }

    private boolean whenIdEditTextIsNotEmpty() {

        return !(IdEdit.getText().toString().isEmpty());
    }


    private void fetchUser(String id) {

        student.clone().enqueue(new Callback<List<Students>>() {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {

                for (Students s : response.body()) {

                    if (s.getCard_id().equalsIgnoreCase(id)) {

                        searchedStudent = s;
                        break;
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed is call" + t, LENGTH_LONG).show();

            }
        });

    }


    //send and request of student api
    private void sendAndRequestResponse() {
        Log.d(TAG, "sendAndRequestResponse");
        student.enqueue(new Callback<List<Students>>() {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {

                studentList = response.body();
                if (studentList != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "isSuccessful");
                        for (Students s : studentList) {
                            String card = s.getCard_id();
                            String name = s.getName();
                            int classRoll = s.getRoll_no();
                            // String Img=s.getImage();
                            Log.d(TAG, "forEachLoop");

                            try {
                                if (card.equals(IdEdit.getText().toString())) {

                                    Log.d(TAG, "Enter IF");
                                    Intent dashBoard = new Intent(getApplicationContext(), DashBoard.class);
                                    dashBoard.putExtra("name", name);
                                    dashBoard.putExtra("roll", classRoll);
                                    // dashBoard.putExtra("image",Img);
                                    startActivity(dashBoard);
                                    Toast.makeText(getApplicationContext(), "Welcome " + name + "in Our School App", Toast.LENGTH_SHORT).show();
                                    break;

                                } else {
                                    Toast.makeText(getApplicationContext(), "Please Enter Your Valid Card Number", Toast.LENGTH_SHORT).show();
                                    break;

                                }

                            } catch (Exception e) {
                                Log.d(TAG, "Catch is " + e);
                                Toast.makeText(getApplicationContext(), "Catch is " + e, Toast.LENGTH_SHORT).show();

                            }


                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Something is Wrong", Toast.LENGTH_SHORT).show();

                    }


                }


            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed is call" + t, LENGTH_LONG).show();
            }
        });


    }
}

package com.example.ringersschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ringersschool.Adapter.DashBoardRecyeclerViewAdapter;
import com.example.ringersschool.Adapter.SliderAdapterExample;
import com.example.ringersschool.Model.Student;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.Transformations.TossTransformation;

public class DashBoard extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView navigationView;

    Bundle  bundle;
    String name,roll,image;
    RecyclerView recyclerView;
    Context context;
    RecyclerView.Adapter recyclerView_Adapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;


    //Static DashName Define
    String[] numbers = {
            "Principal Message","About School","Notice", "Directors", "Diary",
            "Results", "Gallery", "Routine","Attendence","Teacher","Documents","Admission"
    };
    //Static DashImage  Define
    int[] img={R.drawable.principal_message,R.drawable.school,R.drawable.notice,R.drawable.directors
            ,R.drawable.diary,R.drawable.result,R.drawable.gallary,R.drawable.routine,
            R.drawable.attendence,R.drawable.teacher,R.drawable.documents,R.drawable.admisson
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        context = getApplicationContext();
        //find Id
        navigationView=findViewById(R.id.NavigationDrawerId);
        recyclerView = (RecyclerView) findViewById(R.id.RecycleViewId);


         bundle =getIntent().getExtras();
        if(bundle!=null)
        {
            name= bundle.getString("name");
            roll=bundle.getString("roll");
           // image=bundle.getString("image");


        }

        TextView txtProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header_loginUserName);
        txtProfileName.setText(name);
        TextView txtProfileRoll = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header_loginUserRoll);
        txtProfileRoll.setText("Roll No : "+roll);
       // TextView txtProfileImage = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header_loginImage);
       // txtProfileImage.setText(image);



        //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
        recyclerViewLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);


        //Sent Numbers and Image in DashRecyclerViewAdapter
        recyclerView_Adapter = new DashBoardRecyeclerViewAdapter(context,numbers,img);
        recyclerView.setAdapter(recyclerView_Adapter);













        //Toolbar setup
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("DashBoard");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout=findViewById(R.id.naviDrawerId);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        toggle.syncState();



        //SliderView is setup here
        SliderView sliderView = findViewById(R.id.imageSlider);
        SliderAdapterExample adapter = new SliderAdapterExample(DashBoard.this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId())
                {
                    case R.id.navi_Profile:

                        Intent dashBoard=new Intent(getApplicationContext(),DashBoard.class);
                        startActivity(dashBoard);
                        break;
                    case  R.id.nav_header_loginUserName:

                        break;





                }

                return false;
            }
        });

























    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}

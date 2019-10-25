package com.muyu.zhibo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.muyu.zhibo.ligui.LoginActivity;
import com.muyu.zhibo.ligui.MajorActivity;
import com.muyu.zhibo.utils.JSUtils;


public class HomeActivity extends AppCompatActivity {

    private android.widget.Button gozhibo;
    private Button goliGui;
    private View home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home = findViewById(R.id.home);
        this.goliGui = (Button) findViewById(R.id.goliGui);
        this.gozhibo = (Button) findViewById(R.id.gozhibo);
        initListener();
    }

    private void initListener() {
        gozhibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        goliGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPic();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void checkPic() {
        Intent intent=new Intent(this, MajorActivity.class);
        startActivity(intent);
    }

}

package com.example.brian.restaurantreservation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    private static Button button_sbm;
    private static Button button_sbm2;
    private static Button button_sbm3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
    }
    public void onClickButtonListener(){
        button_sbm = (Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.brian.restaurantreservation.SecondActivity");
                        startActivity(intent);

                    }
                }
        );
    }
    public void onClickButton2Listener(){
        button_sbm2 = (Button)findViewById(R.id.button2);
        button_sbm2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.brian.restaurantreservation.ThirdActivity");
                        startActivity(intent);

                    }
                }
        );
    }
    public void onClickButton3Listener(){
        button_sbm3 = (Button)findViewById(R.id.button3);
        button_sbm3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.brian.restaurantreservation.ThirdActivity");
                        startActivity(intent);

                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


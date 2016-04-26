package com.example.brian.restaurantreservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editName,editDay,editTime;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myDb = new DataBaseHelper(this);
        editName = (EditText)findViewById(R.id.editText_name);
        editDay = (EditText)findViewById(R.id.editText_day);
        editTime = (EditText)findViewById(R.id.editText_time);
        btnAddData = (Button)findViewById(R.id.button_add);


    }
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        boolean isInserted =  myDb.insertData(editName.getText().toString(),editDay.getText().toString(),editTime.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(SecondActivity.this,"Reservation Made",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SecondActivity.this,"Couldnt Make Reservation",Toast.LENGTH_LONG).show();


                    }
                }
        );
    }

}

package com.example.lifecycleofactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
    private TextView showtheguess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra=getIntent().getExtras();
        setContentView(R.layout.activity_show_guess);
        showtheguess = findViewById(R.id.receve_text);
        //
        if(extra!=null){

            showtheguess.setText(extra.getString("guess"));
//            Log.d("extra1","onCreate: "+extra.getString("name"));
//            Log.d("extra2","onCreate: "+extra.getInt("age"));
//            Log.d("extra3","onCreate: "+extra.getBoolean("name2"));

        }
        showtheguess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                intent.putExtra("massage_back","Main screen");
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }
}
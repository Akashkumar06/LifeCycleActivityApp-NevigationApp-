package com.example.lifecycleofactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button showguess;
    private EditText guessfield;
    private final int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(MainActivity.this,"OnCreate() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onCreate: ");
         showguess=findViewById(R.id.guess_button);
         guessfield=findViewById(R.id.guess_field);

         showguess.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String guess=guessfield.getText().toString().trim();
                if(!guess.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this,ShowGuess.class);
                    intent.putExtra("guess",guess);
//                    intent.putExtra("name","AKASH");
//                    intent.putExtra("name2",true);
//                    intent.putExtra("Age",18);
//                           startActivity(intent);
                    startActivityForResult(intent,REQUEST_CODE);
                }
                     else{
                         Toast.makeText(MainActivity.this,"Enter guess",Toast.LENGTH_SHORT).show();
                    }


             }
         });

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE){

            assert data != null;
            String massage=data.getStringExtra("massage_back");
            Toast.makeText(MainActivity.this,massage,Toast.LENGTH_SHORT).show();
        }
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this,"OnStart() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle"," OnStart");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(MainActivity.this,"OnStop() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onStop:");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(MainActivity.this,"OnStart() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onRestart: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(MainActivity.this,"OnDestroy() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onDestroy");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this,"OnPause() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onPause: ");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this,"onResume() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onResume");
//    }
}

package com.jmk.edu.threedepthresponsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText=(EditText)findViewById(R.id.editText);
        String message=editText.getText().toString();
        if(v.getId()==R.id.button){
            Bundle bundle=new Bundle();
            bundle.putString("message",message);
            Intent intent=new Intent(this, SecondActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent,Activity.RESULT_FIRST_USER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        TextView textView=(TextView) findViewById(R.id.textView);
        if(data.hasExtra("resultValue")){
            textView.setText(data.getStringExtra("resultValue"));
        }

    }





}

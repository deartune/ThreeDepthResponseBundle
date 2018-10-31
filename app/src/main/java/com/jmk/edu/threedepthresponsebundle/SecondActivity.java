package com.jmk.edu.threedepthresponsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle=getIntent().getExtras();
        editText=(EditText)findViewById(R.id.editText);
        editText.setText(bundle.getString("message","no"));

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String message=editText.getText().toString();
        if(v.getId()==R.id.button){
            Bundle bundle1=new Bundle();
            bundle1.putString("message",message);
            Intent intent=new Intent(this, ThirdActivity.class);
            intent.putExtras(bundle1);
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

    public void finish() {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultValue", ((EditText)editText).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }



}

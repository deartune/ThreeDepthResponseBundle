package com.jmk.edu.threedepthresponsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle bundle1=getIntent().getExtras();
        editText=(EditText)findViewById(R.id.editText);
        editText.setText(bundle1.getString("message","no"));


    }

    public void finish() {

        Intent intent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("resultValue", ((EditText)editText).getText().toString());
        intent.putExtras(bundle1);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }






}

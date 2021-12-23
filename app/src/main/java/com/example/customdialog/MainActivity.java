package com.example.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialogListener {

    private TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv1 = (TextView) findViewById(R.id.textView);
         tv2 = (TextView) findViewById(R.id.textView2);
         Button btnOP = (Button) findViewById(R.id.button);
          btnOP.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   OpenDialog();
              }
          });
    }

    public void OpenDialog(){
     ExampleDialog ed = new ExampleDialog();
      ed.show(getSupportFragmentManager(),"Example Dialog");
    }

    @Override
    public void applyText(String username, String password) {
        tv1.setText(username);
        tv2.setText(password);
    }
}

package com.example.logindemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtUserName;
    private EditText edtPassWord;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        edtPassWord = findViewById(R.id.edtPassWord);
        edtUserName = findViewById(R.id.edtUserName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUserName.getText().toString().equals("admin") && edtPassWord.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, second_screen.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "sai tk hoặc mk", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

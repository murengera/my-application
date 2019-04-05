package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnLogin;
    EditText _txtEmail, _txtPass;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new Mydatabase(this);
        db = openHelper.getReadableDatabase();
        _btnLogin = (Button)findViewById(R.id.btnLogin);
        _txtEmail = (EditText)findViewById(R.id.etemail);
        _txtPass = (EditText)findViewById(R.id.etpassword);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();
                cursor = db.rawQuery(" SELECT * FROM " + Mydatabase.TABLE_NAME + " WHERE " + Mydatabase.COL_5 + " =? AND " + Mydatabase.COL_4 + " =?" , new String[]{email,pass});

           if (cursor != null){
               if (cursor.getCount()>0){
                   Toast.makeText(getApplicationContext(), "login successful" , Toast.LENGTH_LONG).show();
               }else {
                   Toast.makeText(getApplication(),"invalid username or password" , Toast.LENGTH_LONG).show();
               }
           }
            }
        });
    }
}

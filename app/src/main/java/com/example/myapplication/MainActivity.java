package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg , _btnLogin;
    EditText _txtfname, _txtlastname, _txtpass, _txtemail,_txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new Mydatabase(this);
        _btnLogin = (Button)findViewById(R.id.btnLogin);
        _btnreg = (Button)findViewById(R.id.etbutton);

        _txtfname = (EditText) findViewById(R.id.txtfname);
        _txtlastname = (EditText)findViewById(R.id.txtlname);
        _txtpass = (EditText) findViewById(R.id.etpassword);
        _txtemail = (EditText)findViewById(R.id.etemail);
        _txtphone = (EditText)findViewById(R.id.etphone);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getReadableDatabase();
                String fname = _txtfname.getText().toString();
                String lname = _txtlastname.getText().toString();
                String pass = _txtpass.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();
                Toast.makeText(getApplicationContext(), "registration successful", Toast.LENGTH_LONG).show();
            }
        });
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
    }
    public void insertdata (String fname, String lname, String pass, String email, String phone){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Mydatabase.COL_2, fname);
        contentValues.put(Mydatabase.COL_3,lname);
        contentValues.put(Mydatabase.COL_4, pass);
        contentValues.put(Mydatabase.COL_5, email);
        contentValues.put(Mydatabase.COL_6, phone);
        long id = db.insert(Mydatabase.TABLE_NAME, null, contentValues);
    }
}

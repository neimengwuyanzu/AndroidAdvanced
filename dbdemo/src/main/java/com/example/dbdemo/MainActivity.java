package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dbdemo.bean.Address;
import com.example.dbdemo.bean.User;
import com.example.dbdemo.dao.UserDbHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDb();
        insertData();
        getData();
    }

    private void getData() {
        List<User> userList = dbHelper.getAllUsers();
        Log.d("zyzyzy", "getData: " + userList.toString());
    }

    private void insertData() {
        // Add a user
        User user = new User();
        user.setName("阿宇");
        List<Address> addresses = new ArrayList<>();
        Address address1 = new Address();
        address1.setStreet("林场路");
        address1.setCity("巴彦淖尔");
        address1.setState("CA");
        address1.setCountry("中国");
        Address address2 = new Address();
        address2.setStreet("东小口镇");
        address2.setCity("北京");
        address2.setState("CA");
        address2.setCountry("中国");
        addresses.add(address1);
        addresses.add(address2);
        user.setAddresses(addresses);
        dbHelper.addUser(user);

    }

    private void initDb() {
        // Initialize UserDbHelper
        dbHelper = new UserDbHelper(this);
    }
}
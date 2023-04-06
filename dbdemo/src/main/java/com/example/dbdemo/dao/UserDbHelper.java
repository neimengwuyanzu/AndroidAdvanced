package com.example.dbdemo.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dbdemo.bean.Address;
import com.example.dbdemo.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/6
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myapp.db";

    // User table
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";

    // Address table
    private static final String TABLE_ADDRESSES = "addresses";
    private static final String COLUMN_ADDRESS_ID = "address_id";
    private static final String COLUMN_STREET = "street";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_USER_FK = "user_id_fk";

    private static final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USER_NAME + " TEXT )";

    private static final String CREATE_ADDRESSES_TABLE = "CREATE TABLE " + TABLE_ADDRESSES + "("
            + COLUMN_ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STREET + " TEXT, "
            + COLUMN_CITY + " TEXT, "
            + COLUMN_STATE + " TEXT, "
            + COLUMN_COUNTRY + " TEXT, "
            + COLUMN_USER_FK + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_USER_FK + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + ") )";

    // Constructor
    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(CREATE_ADDRESSES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESSES);
        // Create tables again
        onCreate(db);
    }

    // Adding a user
    public long addUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());

        long userId = db.insert(TABLE_USERS, null, values);

        for (Address address : user.getAddresses()) {
            ContentValues addressValues = new ContentValues();
            addressValues.put(COLUMN_STREET, address.getStreet());
            addressValues.put(COLUMN_CITY, address.getCity());
            addressValues.put(COLUMN_STATE, address.getState());
            addressValues.put(COLUMN_COUNTRY, address.getCountry());
            addressValues.put(COLUMN_USER_FK, userId);
            db.insert(TABLE_ADDRESSES, null, addressValues);
        }

        db.close();

        return userId;
    }

    // Getting all users
    @SuppressLint("Range")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                //先查询user表
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));

                //根据user表里的ID 查询addresses表
                String addressesQuery = "SELECT * FROM " + TABLE_ADDRESSES + " WHERE " + COLUMN_USER_FK + " = ?";
                Cursor cursorAddresses = db.rawQuery(addressesQuery, new String[]{String.valueOf(user.getId())});

                if (cursorAddresses.moveToFirst()) {
                    List<Address> addresses = new ArrayList<>();
                    do {
                        Address address = new Address();
                        address.setStreet(cursorAddresses.getString(cursorAddresses.getColumnIndex(COLUMN_STREET)));
                        address.setCity(cursorAddresses.getString(cursorAddresses.getColumnIndex(COLUMN_CITY)));
                        address.setState(cursorAddresses.getString(cursorAddresses.getColumnIndex(COLUMN_STATE)));
                        address.setCountry(cursorAddresses.getString(cursorAddresses.getColumnIndex(COLUMN_COUNTRY)));
                        addresses.add(address);
                    } while (cursorAddresses.moveToNext());
                    user.setAddresses(addresses);
                }

                users.add(user);
            } while (cursor.moveToNext());
        }

        return users;
    }
}

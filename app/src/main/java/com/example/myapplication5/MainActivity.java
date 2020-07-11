package com.example.myapplication5;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;




public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {


    int selectedItem = -1;
    private int userList;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<Users> usersList = new ArrayList<>();
        Users user1 = new Users("Ahmed", "25", "Cairo");
        usersList.add(user1);
        Users user2 = new Users("Sarah", "30", "London");
        usersList.add(user2);
        Users user3 = new Users("Khaled", "38", "Cuba");
        usersList.add(user3);
        Users user4 = new Users("Omran", "40", "Jeddah");
        usersList.add(user4);


        // Creating adapter for spinner
        ArrayAdapter<Users> dataAdapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, usersList) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = null;
                v = super.getDropDownView(position, null, parent);
                // If this is the selected item position
                if (position == selectedItem) {
                    v.setBackgroundColor(Color.RED);
                } else {
                    // for other views
                    v.setBackgroundColor(Color.WHITE);

                }
                return v;
            }
        };

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        Users Item = (Users) parent.getItemAtPosition(position);
        selectedItem = position;
        // Showing selected spinner item


        Toast.makeText(this, Item.getCity().toString() + Item.getAge().toString(), Toast.LENGTH_SHORT).show();

    }


    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
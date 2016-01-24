package com.example.grunert.complexlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Car> myCars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        populateCarList();
        populateListView();
        registerClickCallback();
    }


    private void populateCarList() {
        myCars.add(new Car("Ford",1940,R.drawable.ford,"Needing work"));
        myCars.add(new Car("Audi",2010,R.drawable.audi,"Good shape"));
        myCars.add(new Car("VW",2016,R.drawable.vw,"Perfect"));
    }

    private void populateListView() {
        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Car> {
        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view, myCars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }
            // return super.getView(position, convertView, parent);
            Car currentCar = myCars.get(position);

            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentCar.getIconID());

            TextView makeText = (TextView)itemView.findViewById(R.id.item_Make);
            makeText.setText(currentCar.getMake());

            TextView conditionText = (TextView)itemView.findViewById(R.id.txtCondition);
            conditionText.setText(currentCar.getCondition());

            TextView yearText = (TextView)itemView.findViewById(R.id.item_txtYear);
            yearText.setText("" + currentCar.getYear());

            return itemView;
        }
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car clickedCar = myCars.get(position);
                String message = "You clicked position " + position
                        + " Make " + clickedCar.getMake();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
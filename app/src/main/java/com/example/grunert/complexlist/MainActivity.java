// Car -> message class
// MyListAdapter + ListViev -> messageboard class
// Constants -> messagetypes class
// http://stackoverflow.com/questions/6958279/how-to-use-a-custom-arrayadapter-in-a-separate-class
// http://stackoverflow.com/questions/3346080/android-references-to-a-context-and-memory-leaks
// http://stackoverflow.com/questions/7759504/access-locationmanager-locationlistener-from-class
// http://www.vogella.com/tutorials/AndroidLocationAPI/article.html#locationapi_criteria

package com.example.grunert.complexlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // private List<Car> myCars = new ArrayList<Car>();
    public GlobalVariables gv = new GlobalVariables(); // one and only one instance
    // private ArrayAdapter<Car> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCarList();
        populateCarList2();
        populateListView();
        registerClickCallback();
    }


    private void populateCarList() {
        List<Car> myCars = gv.getMyCars();
        myCars.add(new Car("Ford", Constants.FORD, R.drawable.ford, "Needing work"));
        myCars.add(new Car("Audi", Constants.AUDI, R.drawable.audi, "Good shape"));
        myCars.add(new Car("VW", Constants.VW, R.drawable.vw, "Perfect"));
    }

    private void populateCarList2() {
        List<Car> myCars = GlobalVariables.getMyCars();
        myCars.add(new Car("Beatle", Constants.BEATLE, R.drawable.ford,"Old"));
        myCars.add(new Car("Wartburg", Constants.WARTBURG, R.drawable.audi,"Newer"));
        myCars.add(new Car("Skoda",Constants.SKODA,R.drawable.vw,"Lala"));
    }

    private void populateListView() {
        // adapter = new MyListAdapter();
        List<Car> myCars = GlobalVariables.getMyCars();
        GlobalVariables.adapter = new CarAdapter(MainActivity.this,0,myCars);
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setAdapter(GlobalVariables.adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Car> myCars = GlobalVariables.getMyCars();

                Car clickedCar = myCars.get(position);
                String message = "You clicked position " + position
                        + " Make " + clickedCar.getMake();

                // changes only 1st row found, should be simplified using global adapter and list my cars
                // Car.setField(GlobalVariables.adapter, myCars, Constants.FORD, "Trabant");
                Car.setField(Constants.FORD, "Trabant");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

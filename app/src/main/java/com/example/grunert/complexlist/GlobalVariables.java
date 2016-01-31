// http://stackoverflow.com/questions/9613055/declaring-a-global-variable-to-use-in-all-activities
// http://stackoverflow.com/questions/21810240/how-to-create-a-global-variable-in-android

package com.example.grunert.complexlist;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Werner-Jens Grunert on 1/29/2016.
 */
public class GlobalVariables extends Application {
    static private List<Car> myCars;
    public static ArrayAdapter<Car> adapter;

    public GlobalVariables() {
        myCars =new ArrayList<Car>();
    }

    static public List<Car> getMyCars() {
        return myCars;
    }

    public void setMyCars(List<Car> myCars) {
        this.myCars = myCars;
    }
}

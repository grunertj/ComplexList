package com.example.grunert.complexlist;

import android.content.res.ColorStateList;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by grunert on 1/24/16.
 */

public class Car {
    private String make;
    private int year;
    private int iconID;
    private String condition;

    static public void setField(ArrayAdapter<Car> adapter, List<Car> myCars, int field, String message) {
        for (Car car: myCars) {
            if (car.getYear() == field) {
                car.setMake(message);
                car.setCondition("Good");
                adapter.notifyDataSetChanged();
                break;
            }
        }
    }

    public Car(String make, int year, int iconID, String condition) {
        this.make = make;
        this.year = year;
        this.iconID = iconID;
        this.condition = condition;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getIconID() {
        return iconID;
    }

    public String getCondition() {
        return condition;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

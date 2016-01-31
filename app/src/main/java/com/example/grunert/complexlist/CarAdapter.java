package com.example.grunert.complexlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Werner-Jens Grunert on 1/29/2016.
 */
public class CarAdapter extends ArrayAdapter<Car> {
    Context mContext;
    private List<Car> myCars;

    public CarAdapter(Context context, int resource, List<Car> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.myCars = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            itemView = inflater.inflate(R.layout.item_view, parent, false);
        }
        // return super.getView(position, convertView, parent);
        Car currentCar = myCars.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
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
